package org.octopussy.udkplugin.lang.parser.parsing;

import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.octopussy.udkplugin.lang.UnrealElementTypes;
import org.octopussy.udkplugin.lang.parser.util.UnrealPsiBuilder;

import static org.octopussy.udkplugin.lang.UnrealTokenTypes.*;

/**
 * User: octopussy
 * Date: 13.05.12
 * Time: 18:08
 */
public class VariableParser implements UnrealElementTypes {
  public static final boolean tryParse(UnrealPsiBuilder builder, boolean isLocalScope) {
    final TokenSet tokens = TokenSet.create(LOCAL_KEYWORD, VAR_KEYWORD);
    final IElementType actualToken = builder.compareToken(tokens);
    if (actualToken == null)
      return false;

    // var(category) keyword name[]
    PsiBuilder.Marker varMarker = builder.mark();
    if (actualToken.equals(LOCAL_KEYWORD) && !isLocalScope)
      builder.eatError("local.variable.not.allowed");
    else if (actualToken.equals(VAR_KEYWORD) && isLocalScope)
      builder.eatError("class.variable.not.allowed");
    else
      builder.eatElement(actualToken);

    if (!isLocalScope && tryParseCategory(builder, varMarker))
      return true;

    parseKeywords(builder);

    // type
    if (!TypeParser.parse(builder)) {
      builder.eatError(varMarker, "type.expected");
      return true;
    }

    String varName;
    if (!builder.compareToken(IDENTIFIER)) {
      builder.eatError(varMarker, "identifier.expected");
      return true;
    } else {
      varName = builder.getTokenText();
      builder.skipElement();
    }

    builder.match(SEMICOLON, "semicolon.expected");

    varMarker.done(VARIABLE_DECLARATION);

    return true;
  }

  private static boolean tryParseCategory(UnrealPsiBuilder builder, PsiBuilder.Marker varMarker) {
    String category;
    if (builder.compareToken(LPAREN)) {
      builder.skipElement();
      if (builder.compareToken(IDENTIFIER)) {
        category = builder.getTokenText();
        builder.skipElement();
      } else {
        category = "";
      }

      if (builder.fastForwardTo(TokenSet.create(SEMICOLON, RPAREN)).equals(RPAREN)) {
        builder.skipElement();
      } else {
        builder.eatError(varMarker, "rparen.expected");
        return true;
      }
    }
    return false;
  }

  private static void parseKeywords(UnrealPsiBuilder builder) {
    PsiBuilder.Marker keywordsMarker = builder.mark();
    final int semicolonPos = builder.getFirstTokenPos(SEMICOLON);
    int keywordsTokensNum = semicolonPos - 2;

    IElementType current = builder.getTokenType();
    while(keywordsTokensNum >0){
      if (VARIABLE_KEYWORDS.contains(current))
        current = builder.eatElement(current);
      else
        current = builder.eatError("wrong.variable.keyword");
      --keywordsTokensNum;
    }

    keywordsMarker.done(VARIABLE_KEYWORDS_CLAUSE_ELEMENT);
  }
}
