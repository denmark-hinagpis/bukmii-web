package com.kowd.bukmii.app.aws;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.kowd.bukmii.app.exception.BukmiiException;
import com.kowd.bukmii.enumeration.PictureSize;
import com.kowd.bukmii.hibernate.beans.Photo;

/**
 * @author dchinagpis
 *
 */
public class S3Upload {

	/***/
	private static final Logger LOGGER = LogManager.getLogger(S3Upload.class);

	/***/
	private static final String AWS_ENV_NAME = "AWS_ENV_NAME";

	/***/
	public S3Upload() {
	}

	/***
	 * @param photo Photo
	 * @param data byte[]
	 * @throws BukmiiException e
	 */
	public void uploadPhoto(final Photo photo, final byte[] data) throws BukmiiException {
		try {
			final AWSS3Access access = AWSS3Access.getInstance();
			final AWSCredentials credentials = new BasicAWSCredentials(access.getAccessKey(), access.getSecretKey());
			final AmazonS3 s3client = new AmazonS3Client(credentials);
			final String bucketName = System.getProperty(AWS_ENV_NAME, "bukmii-test");

			if (!s3client.doesBucketExist(bucketName)) {
				s3client.createBucket(bucketName);
			}

			final String folderName = "images";

			upload(photo, new ByteArrayInputStream(data), s3client, bucketName, folderName, PictureSize.ORIGINAL);

			final BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(data));

			int type = BufferedImage.TYPE_INT_ARGB;
			if (originalImage.getType() != 0) {
				type = originalImage.getType();
			}
			final BufferedImage thumbImage = resizeImage(originalImage, type, 100, 100);
			upload(photo, getInputStream(thumbImage, photo.getFileType()), s3client, bucketName, folderName, PictureSize.THUMB);

			final BufferedImage mediumImage = resizeImage(originalImage, type, originalImage.getWidth(), originalImage.getHeight());
			upload(photo, getInputStream(mediumImage, photo.getFileType()), s3client, bucketName, folderName, PictureSize.MEDIUM);
		} catch (final IOException e) {
			LOGGER.error("An error occured when uploading to server.", e);
			throw new BukmiiException("An error occured when uploading to server.", 403);
		}
	}

	/***
	 * @param photo Photo
	 * @param in InputStream
	 * @param s3client AmazonS3
	 * @param bucketName String
	 * @param folderName String
	 * @param medium PictureSize
	 * @throws IOException e
	 * @throws BukmiiException e
	 */
	private void upload(final Photo photo,
						final InputStream in,
						final AmazonS3 s3client,
						final String bucketName,
						final String folderName,
						final PictureSize medium) throws IOException, BukmiiException {
		final File temp = saveToTemp(photo.getImagePath(medium), in);
		uploadS3(s3client,
				 bucketName,
				 folderName + "/" + photo.getImagePath(medium),
				 temp);
		temp.delete();
	}

	/**
	 *
	 * @param imagePath String
	 * @param in InputStream
	 * @return File
	 * @throws BukmiiException e
	 */
	private File saveToTemp(final String imagePath, final InputStream in) throws BukmiiException {
		final String workingDir = System.getProperty("user.dir");
		final File targetTemp = new File(workingDir, imagePath);
		if (!targetTemp.getParentFile().exists()) {
			targetTemp.getParentFile().mkdirs();
		}

		FileOutputStream out = null;
		try {
			out = new FileOutputStream(targetTemp);
			int read = 0;
			final byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.close();
		} catch (final FileNotFoundException e) {
			LOGGER.error("An error occured when uploading to server.", e);
			throw new BukmiiException("An error occured when uploading to server.", 403);
		} catch (final IOException e) {
			LOGGER.error("An error occured when uploading to server.", e);
			throw new BukmiiException("An error occured when uploading to server.", 403);
		} finally {
			if (null != out) {
				try {
					out.close();
				} catch (final IOException e) {
					LOGGER.error("An error occured when uploading to server.", e);
				}
			}
		}
		return targetTemp;
	}

	/**
	 *
	 * @param s3client AmazonS3
	 * @param bucketName String
	 * @param fileName String
	 * @param file File
	 * @throws IOException e
	 */
	private void uploadS3(final AmazonS3 s3client,
						  final String bucketName,
						  final String fileName,
						  final File file) throws IOException {
		final PutObjectRequest obj = new PutObjectRequest(bucketName, fileName, file);
		obj.withCannedAcl(CannedAccessControlList.PublicRead);
		s3client.putObject(obj);
	}

	/**
	 *
	 * @param img BufferedImage
	 * @param fileType String
	 * @return InputStream
	 * @throws IOException e
	 */
	private InputStream getInputStream(final BufferedImage img,
									   final String fileType) throws IOException {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(img, fileType, baos);
		return new ByteArrayInputStream(baos.toByteArray());
	}

	/**
	 *
	 * @param originalImage BufferedImage
	 * @param type int
	 * @param width int
	 * @param height int
	 * @return BufferedImage
	 */
	private BufferedImage resizeImage(final BufferedImage originalImage,
									  final int type,
									  final int width,
									  final int height) {
		final BufferedImage resizedImage = new BufferedImage(width, height, type);
		final Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();
		return resizedImage;
	}

}
