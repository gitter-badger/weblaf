/*
 * This file is part of WebLookAndFeel library.
 *
 * WebLookAndFeel library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WebLookAndFeel library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with WebLookAndFeel library.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alee.laf.menu;

import com.alee.laf.WebLookAndFeel;
import com.alee.managers.language.LanguageManager;
import com.alee.managers.language.LanguageMethods;
import com.alee.managers.language.updaters.LanguageUpdater;
import com.alee.managers.log.Log;
import com.alee.managers.style.ShapeProvider;
import com.alee.managers.style.StyleId;
import com.alee.managers.style.Styleable;
import com.alee.utils.ReflectUtils;
import com.alee.utils.SwingUtils;
import com.alee.utils.swing.FontMethods;

import javax.swing.*;
import java.awt.*;

/**
 * This JMenu extension class provides a direct access to WebMenuUI methods.
 *
 * @author Mikle Garin
 */

public class WebMenu extends JMenu implements Styleable, ShapeProvider, LanguageMethods, FontMethods<WebMenu>
{
    /**
     * Constructs new menu.
     */
    public WebMenu ()
    {
        super ();
    }

    /**
     * Constructs new menu using the specified settings.
     *
     * @param icon menu icon
     */
    public WebMenu ( final Icon icon )
    {
        super ();
        setIcon ( icon );
    }

    /**
     * Constructs new menu using the specified settings.
     *
     * @param s menu text
     */
    public WebMenu ( final String s )
    {
        super ( s );
    }

    /**
     * Constructs new menu using the specified settings.
     *
     * @param a menu action
     */
    public WebMenu ( final Action a )
    {
        super ( a );
    }

    /**
     * Constructs new menu using the specified settings.
     *
     * @param s    menu text
     * @param icon menu item icon
     */
    public WebMenu ( final String s, final Icon icon )
    {
        super ( s );
        setIcon ( icon );
    }

    /**
     * Constructs new menu.
     *
     * @param id style ID
     */
    public WebMenu ( final StyleId id )
    {
        super ();
        setStyleId ( id );
    }

    /**
     * Constructs new menu using the specified settings.
     *
     * @param id   style ID
     * @param icon menu icon
     */
    public WebMenu ( final StyleId id, final Icon icon )
    {
        super ();
        setIcon ( icon );
        setStyleId ( id );
    }

    /**
     * Constructs new menu using the specified settings.
     *
     * @param id style ID
     * @param s  menu text
     */
    public WebMenu ( final StyleId id, final String s )
    {
        super ( s );
        setStyleId ( id );
    }

    /**
     * Constructs new menu using the specified settings.
     *
     * @param id style ID
     * @param a  menu action
     */
    public WebMenu ( final StyleId id, final Action a )
    {
        super ( a );
        setStyleId ( id );
    }

    /**
     * Constructs new menu using the specified settings.
     *
     * @param id   style ID
     * @param s    menu text
     * @param icon menu item icon
     */
    public WebMenu ( final StyleId id, final String s, final Icon icon )
    {
        super ( s );
        setIcon ( icon );
        setStyleId ( id );
    }

    @Override
    public StyleId getStyleId ()
    {
        return getWebUI ().getStyleId ();
    }

    @Override
    public StyleId setStyleId ( final StyleId id )
    {
        return getWebUI ().setStyleId ( id );
    }

    @Override
    public Shape provideShape ()
    {
        return getWebUI ().provideShape ();
    }

    /**
     * Returns Web-UI applied to this class.
     *
     * @return Web-UI applied to this class
     */
    private WebMenuUI getWebUI ()
    {
        return ( WebMenuUI ) getUI ();
    }

    /**
     * Installs a Web-UI into this component.
     */
    @Override
    public void updateUI ()
    {
        if ( getUI () == null || !( getUI () instanceof WebMenuUI ) )
        {
            try
            {
                setUI ( ( WebMenuUI ) ReflectUtils.createInstance ( WebLookAndFeel.menuUI ) );
            }
            catch ( final Throwable e )
            {
                Log.error ( this, e );
                setUI ( new WebMenuUI () );
            }
        }
        else
        {
            setUI ( getUI () );
        }
        if ( getPopupMenu () != null )
        {
            getPopupMenu ().updateUI ();
        }
    }

    @Override
    public void setLanguage ( final String key, final Object... data )
    {
        LanguageManager.registerComponent ( this, key, data );
    }

    @Override
    public void updateLanguage ( final Object... data )
    {
        LanguageManager.updateComponent ( this, data );
    }

    @Override
    public void updateLanguage ( final String key, final Object... data )
    {
        LanguageManager.updateComponent ( this, key, data );
    }

    @Override
    public void removeLanguage ()
    {
        LanguageManager.unregisterComponent ( this );
    }

    @Override
    public boolean isLanguageSet ()
    {
        return LanguageManager.isRegisteredComponent ( this );
    }

    @Override
    public void setLanguageUpdater ( final LanguageUpdater updater )
    {
        LanguageManager.registerLanguageUpdater ( this, updater );
    }

    @Override
    public void removeLanguageUpdater ()
    {
        LanguageManager.unregisterLanguageUpdater ( this );
    }

    @Override
    public WebMenu setPlainFont ()
    {
        return SwingUtils.setPlainFont ( this );
    }

    @Override
    public WebMenu setPlainFont ( final boolean apply )
    {
        return SwingUtils.setPlainFont ( this, apply );
    }

    @Override
    public boolean isPlainFont ()
    {
        return SwingUtils.isPlainFont ( this );
    }

    @Override
    public WebMenu setBoldFont ()
    {
        return SwingUtils.setBoldFont ( this );
    }

    @Override
    public WebMenu setBoldFont ( final boolean apply )
    {
        return SwingUtils.setBoldFont ( this, apply );
    }

    @Override
    public boolean isBoldFont ()
    {
        return SwingUtils.isBoldFont ( this );
    }

    @Override
    public WebMenu setItalicFont ()
    {
        return SwingUtils.setItalicFont ( this );
    }

    @Override
    public WebMenu setItalicFont ( final boolean apply )
    {
        return SwingUtils.setItalicFont ( this, apply );
    }

    @Override
    public boolean isItalicFont ()
    {
        return SwingUtils.isItalicFont ( this );
    }

    @Override
    public WebMenu setFontStyle ( final boolean bold, final boolean italic )
    {
        return SwingUtils.setFontStyle ( this, bold, italic );
    }

    @Override
    public WebMenu setFontStyle ( final int style )
    {
        return SwingUtils.setFontStyle ( this, style );
    }

    @Override
    public WebMenu setFontSize ( final int fontSize )
    {
        return SwingUtils.setFontSize ( this, fontSize );
    }

    @Override
    public WebMenu changeFontSize ( final int change )
    {
        return SwingUtils.changeFontSize ( this, change );
    }

    @Override
    public int getFontSize ()
    {
        return SwingUtils.getFontSize ( this );
    }

    @Override
    public WebMenu setFontSizeAndStyle ( final int fontSize, final boolean bold, final boolean italic )
    {
        return SwingUtils.setFontSizeAndStyle ( this, fontSize, bold, italic );
    }

    @Override
    public WebMenu setFontSizeAndStyle ( final int fontSize, final int style )
    {
        return SwingUtils.setFontSizeAndStyle ( this, fontSize, style );
    }

    @Override
    public WebMenu setFontName ( final String fontName )
    {
        return SwingUtils.setFontName ( this, fontName );
    }

    @Override
    public String getFontName ()
    {
        return SwingUtils.getFontName ( this );
    }
}