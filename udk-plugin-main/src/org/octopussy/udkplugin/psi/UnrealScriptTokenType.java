package org.octopussy.udkplugin.psi;

import com.intellij.psi.tree.IElementType;
import org.octopussy.udkplugin.UnrealScriptFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: dmonych
 * Date: 17.04.12
 * Time: 15:36
 */
public class UnrealScriptTokenType extends IElementType{
  public UnrealScriptTokenType(@NotNull @NonNls String debugName) {
    super(debugName, UnrealScriptFileType.UNREAL_SCRIPT_LANGUAGE);
  }
}
