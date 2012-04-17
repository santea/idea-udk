package org.octopussy.udkplugin.psi.impl;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.octopussy.udkplugin.UnrealScriptFileType;
import org.octopussy.udkplugin.psi.UnrealScriptFile;

/**
 * Created with IntelliJ IDEA.
 * User: dmonych
 * Date: 17.04.12
 * Time: 17:01
 */
public class UnrealScriptFileImpl extends PsiFileBase implements UnrealScriptFile{
  public UnrealScriptFileImpl(FileViewProvider fileViewProvider) {
    super(fileViewProvider, UnrealScriptFileType.UNREAL_SCRIPT_LANGUAGE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return UnrealScriptFileType.UNREAL_SCRIPT_FILE_TYPE;
  }
}
