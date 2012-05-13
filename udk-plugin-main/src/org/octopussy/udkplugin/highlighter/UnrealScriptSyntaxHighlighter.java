package org.octopussy.udkplugin.highlighter;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.SyntaxHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.octopussy.udkplugin.lang.UnrealTokenTypes;
import org.octopussy.udkplugin.lang.lexer.UnrealFlexLexer;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class UnrealScriptSyntaxHighlighter extends SyntaxHighlighterBase implements UnrealTokenTypes {
  private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<IElementType, TextAttributesKey>();

  static final TokenSet tCOMMENTS = TokenSet.create(C_STYLE_COMMENT, LINE_COMMENT, DOC_COMMENT);

  static final TokenSet tIDENTIFIERS = TokenSet.create(IDENTIFIER);

  static {
    fillMap(ATTRIBUTES, tCOMMENTS, SyntaxHighlighterColors.LINE_COMMENT);
    fillMap(ATTRIBUTES, BUILTIN_TYPES, SyntaxHighlighterColors.KEYWORD);
    fillMap(ATTRIBUTES, CLASS_KEYWORDS, SyntaxHighlighterColors.KEYWORD);
    fillMap(ATTRIBUTES, VARIABLE_KEYWORDS, SyntaxHighlighterColors.KEYWORD);
    fillMap(ATTRIBUTES, FUNCTION_KEYWORDS, SyntaxHighlighterColors.KEYWORD );
    fillMap(ATTRIBUTES, PARAMETER_KEY_KEYWORDS, SyntaxHighlighterColors.KEYWORD);
    fillMap(ATTRIBUTES, OTHER_KEYWORDS, SyntaxHighlighterColors.KEYWORD);
  }

  @NotNull
  @Override
  public Lexer getHighlightingLexer() {
    return new UnrealFlexLexer();
  }

  @NotNull
  @Override
  public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
    return pack(ATTRIBUTES.get(tokenType));
  }
}
