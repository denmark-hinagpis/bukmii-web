package com.kowd.bukmii.ui.text;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author dhinagpis
 */
public final class Texts {

    /***/
    private static final Logger LOGGER = LogManager.getLogger(Texts.class);

    /***/
    private Texts() {
    }

    /**
     * @param bundleName String
     * @return ResourceBundle
     */
    static ResourceBundle getBundle(final String bundleName) {
        try {
            final ResourceBundle bundle = ResourceBundle.getBundle(Texts.class.getPackage().getName() + "." +
            													   bundleName,
            													   Locale.getDefault());
            LOGGER.debug("Using resource bundle " + bundleName + ", locale=" + Locale.getDefault());

            return bundle;
        } catch (final MissingResourceException e) {
            LOGGER.warn("No resource bundle available for " + bundleName);

            return null;
        }
    }

    /**
     * @param bundle ResourceBundle
     * @param key String
     * @return String
     */
    public static String getString(final ResourceBundle bundle, final String key) {
        try {
            return bundle.getString(key);
        } catch (final MissingResourceException e) {
            return "!" + key + "!";
        }
    }

    /**
     * @param bundle ResourceBundle
     * @param key String
     * @param arg Object
     * @return String
     */
    static String getString(final ResourceBundle bundle, final String key, final Object arg) {
        try {
            final String format = bundle.getString(key);
            if (arg == null) {
                return MessageFormat.format(format, new Object[] { "" });
            }

            return MessageFormat.format(format, new Object[] { arg });
        } catch (final MissingResourceException e) {
            return "!" + key + "!"; //$NON-NLS-2$ //$NON-NLS-1$
        }
    }

    /**
     * @param bundle ResourceBundle
     * @param key String
     * @param args String[]
     * @return String
     */
    static String getString(final ResourceBundle bundle, final String key, final String[] args) {
        try {
            return MessageFormat.format(bundle.getString(key), (Object[]) args);
        } catch (final MissingResourceException e) {
            return "!" + key + "!"; //$NON-NLS-2$ //$NON-NLS-1$
        }
    }
}