package com.octopussy.udkplugin.lexer;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class UnrealScriptFlexLexer extends FlexAdapter{
    public UnrealScriptFlexLexer() {
        super(new _UnrealScriptLexer((Reader)null));
    }
}
