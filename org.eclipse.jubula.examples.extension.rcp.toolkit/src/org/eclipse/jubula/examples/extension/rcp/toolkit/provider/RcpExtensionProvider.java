/*******************************************************************************
 * Copyright (c) 2004, 2010 BREDEX GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     BREDEX GmbH - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.jubula.examples.extension.rcp.toolkit.provider;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import org.eclipse.jubula.examples.extension.rcp.toolkit.Activator;
import org.eclipse.jubula.toolkit.common.IToolKitProvider;
import org.eclipse.jubula.toolkit.common.utils.ToolkitUtils;
import org.eclipse.swt.widgets.Composite;


/**
 * Toolkit Provider Class
 * 
 * This class provides the Jubula Client with all necessary information:
 * which new components have been added by the user (see the
 * ComponentConfiguration.xml), from what kind of components they inherit and
 * where to search for translatable keys.
 * 
 * @author BREDEX GmbH
 * 
 */
public class RcpExtensionProvider implements IToolKitProvider {
    /** the bundle location */
    public static final String BUNDLE = "org.eclipse.jubula.examples.extension.rcp.toolkit.i18n.i18n"; //$NON-NLS-1$
    
    /**
     * As this should be a toolkit extension instead of a seperated toolkit, you
     * do not have to implement your own AUT-Configuration dialog. 
     * {@inheritDoc}
     */
    public Composite getAutConfigDialog(Composite arg0, int arg1, Map arg2,
            String arg3) {
        return null;
    }

    /**
     * this method returns the path where the client searches for your client
     * toolkit extension XML-file. This file contains all necessary information
     * for the client. 
     * {@inheritDoc}
     */
    public URL getComponentConfigurationFileURL() {
        return ToolkitUtils.getURL(Activator.getDefault(),
            "resources/xml/MyComponentConfiguration.xml"); //$NON-NLS-1$
    }

    /**
     * this method should return a i18n properties file location for
     * translatable strings. 
     * {@inheritDoc}
     */
    public ResourceBundle getI18nResourceBundle() {
        return ResourceBundle.getBundle(BUNDLE);
    }
}