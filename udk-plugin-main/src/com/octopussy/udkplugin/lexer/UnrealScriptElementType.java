package com.octopussy.udkplugin.lexer;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import com.octopussy.udkplugin.UnrealScriptFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class UnrealScriptElementType extends IElementType{
    public UnrealScriptElementType(@NotNull @NonNls String debugName) {
        super(debugName, UnrealScriptFileType.UNREAL_SCRIPT_LANGUAGE);
    }
}
