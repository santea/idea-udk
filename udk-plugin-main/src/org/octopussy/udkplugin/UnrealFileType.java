package org.octopussy.udkplugin;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class UnrealFileType extends LanguageFileType{

    public static final String UNREAL_SCRIPT_EXTENSION = "uc";
    public static final UnrealFileType UNREAL_SCRIPT_FILE_TYPE = new UnrealFileType();
    public static final Language UNREAL_SCRIPT_LANGUAGE = UNREAL_SCRIPT_FILE_TYPE.getLanguage();

    private UnrealFileType() {
        super(new UnrealLanguage());
    }

    @NotNull
    @Override
    public String getName() {
        return "UnrealScript";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Unreal Script File";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return UNREAL_SCRIPT_EXTENSION;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Icon getIcon() {
        return UdkPluginIcons.UNREAL_SCRIPT_ICON_16x16;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
