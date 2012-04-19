package org.octopussy.udkplugin.lang.lexer;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.MergingLexerAdapter;
import com.intellij.psi.tree.TokenSet;

import static org.octopussy.udkplugin.lang.UnrealTokenTypes.*;

import java.io.Reader;

public class UnrealFlexLexer extends MergingLexerAdapter {
    public UnrealFlexLexer() {
        super(new FlexAdapter(new _UnrealLexer((Reader)null) ), TokenSet.create(WHITE_SPACE));
    }
}
