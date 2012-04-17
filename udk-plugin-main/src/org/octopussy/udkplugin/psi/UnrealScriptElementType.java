package org.octopussy.udkplugin.psi;

import com.intellij.psi.tree.IElementType;
import org.octopussy.udkplugin.UnrealScriptFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class UnrealScriptElementType extends IElementType {
  public UnrealScriptElementType(@NotNull @NonNls String debugName) {
    super(debugName, UnrealScriptFileType.UNREAL_SCRIPT_LANGUAGE);
  }
}
