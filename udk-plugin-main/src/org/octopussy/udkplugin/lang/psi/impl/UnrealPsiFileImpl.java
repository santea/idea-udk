package org.octopussy.udkplugin.lang.psi.impl;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.octopussy.udkplugin.UnrealFileType;
import org.octopussy.udkplugin.lang.psi.api.UnrealPsiFile;

/**
 * Created with IntelliJ IDEA.
 * User: dmonych
 * Date: 17.04.12
 * Time: 17:01
 */
public class UnrealPsiFileImpl extends PsiFileBase implements UnrealPsiFile {
  public UnrealPsiFileImpl(FileViewProvider fileViewProvider) {
    super(fileViewProvider, UnrealFileType.UNREAL_SCRIPT_LANGUAGE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return UnrealFileType.UNREAL_SCRIPT_FILE_TYPE;
  }
}
