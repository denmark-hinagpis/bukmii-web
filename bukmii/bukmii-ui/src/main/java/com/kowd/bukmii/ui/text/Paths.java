package com.kowd.bukmii.ui.text;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * @author dhinagpis
 */
public final class Paths {

    /***/
    private static final String BUNDLE_NAME = "paths"; //$NON-NLS-1$

    /***/
    private static final ResourceBundle BUNDLE;

    /***/
    private static final List<String> PATHS = new ArrayList<>();

    static {
        BUNDLE = Texts.getBundle(BUNDLE_NAME);
        setAllPaths();
    }

    /***/
    private Paths() {
    }

    /**
	 *
	 */
	private static void setAllPaths() {
		final Set<String> keys = BUNDLE.keySet();
    	for (final String key : keys) {
    		if (key.endsWith("Servlet.Path")) {
    			PATHS.add(BUNDLE.getString(key));
    		}
    	}
	}

	/**
     * @param key String
     * @return String
     */
    public static String getString(final String key) {
        return Texts.getString(BUNDLE, key);
    }

    /**
     * @param key String
     * @param arg Object
     * @return String
     */
    public static String getString(final String key, final Object arg) {
        return Texts.getString(BUNDLE, key, arg);
    }

    /**
     * @param key String
     * @param args String[]
     * @return String
     */
    public static String getString(final String key, final String[] args) {
        return Texts.getString(BUNDLE, key, args);
    }

    /**
     * @return List<String>
     */
    public static List<String> getAllPaths() {
    	return PATHS;
    }

}