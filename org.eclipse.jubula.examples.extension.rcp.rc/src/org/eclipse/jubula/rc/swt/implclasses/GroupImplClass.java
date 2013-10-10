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
package org.eclipse.jubula.rc.swt.implclasses;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

/**
 * Tester Class for the RcpAccessor. This class realizes the technical access to
 * provide testability for new component type: Group. By implementing the
 * abstract class "AbstractControlImplClass" you only have to implement a few
 * methods to enable testability of your new component on the
 * "Graphics Component"-level.
 * 
 * @author BREDEX GmbH
 * 
 */
public class GroupImplClass extends AbstractControlImplClass {
    /** the managed component */
    private Group m_group;

    /**
     * getter for the new supported component
     * 
     * @return the component
     */
    public Control getComponent() {
        return m_group;
    }

    /**
     * as Group is no component which by default displays any kind of
     * descriptive text, this method should return null
     * 
     * @return null in case of a non-textual component
     */
    public String[] getTextArrayFromComponent() {
        return null;
    }

    /**
     * setter for the new supported component
     * 
     * @param graphics
     *            the ui object to set
     */
    public void setComponent(Object graphics) {
        m_group = (Group) graphics;

    }
}