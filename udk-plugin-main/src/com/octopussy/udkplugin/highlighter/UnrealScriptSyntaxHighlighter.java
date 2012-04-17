package com.octopussy.udkplugin.highlighter;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.SyntaxHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.octopussy.udkplugin.parser.UnrealScriptFlexLexer;
import org.jetbrains.annotations.NotNull;
import org.octopussy.udkplugin.psi.UnrealScriptTypes;

import java.util.HashMap;
import java.util.Map;

public class UnrealScriptSyntaxHighlighter extends SyntaxHighlighterBase implements UnrealScriptTypes{
    private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<IElementType, TextAttributesKey>();

    static final TokenSet tCOMMENTS = TokenSet.create(C_STYLE_COMMENT, END_OF_LINE_COMMENT, DOC_COMMENT);
    static final TokenSet tKEYWORDS = TokenSet.create(
            TRUE_KEYWORD,
            FALSE_KEYWORD,
            NONE_KEYWORD,
            VAR_KEYWORD,
            CLASS_KEYWORD,
            CASE_KEYWORD,
            NEW_KEYWORD,
            CONTINUE_KEYWORD,
            FOR_KEYWORD,
            IF_KEYWORD,
            FLOAT_KEYWORD,
            BREAK_KEYWORD,
            STATIC_KEYWORD,
            WHILE_KEYWORD,
            VOID_KEYWORD,
            PROTECTED_KEYWORD,
            ELSE_KEYWORD,
            INTERFACE_KEYWORD,
            BOOLEAN_KEYWORD,
            SWITCH_KEYWORD,
            PUBLIC_KEYWORD,
            SAME_KEYWORD,
            PRIVATE_KEYWORD,
            INT_KEYWORD,
            RETURN_KEYWORD,
            DO_KEYWORD,
            NATIVE_KEYWORD,
            GOTO_KEYWORD,
            SUPER_KEYWORD,
            EXTENDS_KEYWORD,
            DEPENDSON_KEYWORD);

    static final TokenSet tIDENTIFIERS = TokenSet.create(IDENTIFIER);

    static {
        fillMap(ATTRIBUTES, tCOMMENTS, SyntaxHighlighterColors.LINE_COMMENT);
        fillMap(ATTRIBUTES, tKEYWORDS, SyntaxHighlighterColors.KEYWORD);
       // fillMap(ATTRIBUTES, tIDENTIFIERS, SyntaxHighlighterColors.KEYWORD);
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new UnrealScriptFlexLexer();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(ATTRIBUTES.get(tokenType));
    }
}
