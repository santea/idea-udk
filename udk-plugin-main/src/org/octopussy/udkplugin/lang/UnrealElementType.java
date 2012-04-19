package org.octopussy.udkplugin.lang;

import com.intellij.psi.tree.IElementType;
import org.octopussy.udkplugin.UnrealFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class UnrealElementType extends IElementType {
  public UnrealElementType(@NotNull @NonNls String debugName) {
    super(debugName, UnrealFileType.UNREAL_SCRIPT_LANGUAGE);
  }
}
