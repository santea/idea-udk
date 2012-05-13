package org.octopussy.udkplugin.lang.parser.parsing;

import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.octopussy.udkplugin.lang.UnrealElementTypes;
import org.octopussy.udkplugin.lang.parser.UnrealParser;
import org.octopussy.udkplugin.lang.parser.util.UnrealPsiBuilder;

import static org.octopussy.udkplugin.lang.UnrealTokenTypes.*;

/**
 * User: octopussy
 * Date: 13.05.12
 */
public class FunctionParser implements UnrealElementTypes {
  public static final boolean tryParse(UnrealPsiBuilder builder) {
    PsiBuilder.Marker functionMarker = builder.mark();

    final int functionKwPos = builder.getFirstTokenPos(FUNCTION_KEYWORD);
    final int lParenPos = builder.getFirstTokenPos(LPAREN);
    final int rParenPos = builder.getFirstTokenPos(RPAREN);
    if (functionKwPos == -1 || lParenPos == -1 || rParenPos == -1 || functionKwPos > lParenPos || lParenPos > rParenPos) {
      functionMarker.rollbackTo();
      return false;
    }

    parseKeywords(builder);

    builder.eatElement(FUNCTION_KEYWORD);

    if (lParenPos - functionKwPos < 3) {
      builder.error("type.expected");
    }
    if (!TypeParser.parse(builder)) {
      builder.eatError("wrong.type");
    }

    String funcName;
    if (builder.compareToken(IDENTIFIER)) {
      funcName = builder.getTokenText();
      builder.eatElement(IDENTIFIER);
    } else {
      builder.eatError("identifier.expected");
    }

    parseParameterList(builder);

    if (!UnrealParser.tryParseBlock(builder)){
      builder.eatError(functionMarker, "syntax.error");
      return true;
    }

    functionMarker.done(FUNCTION_DECLARATION);
    return true;
  }

  private static void parseKeywords(UnrealPsiBuilder builder) {
    PsiBuilder.Marker keywordsMarker = builder.mark();

    IElementType current = builder.getTokenType();
    while (!current.equals(FUNCTION_KEYWORD)) {
      if (!FUNCTION_KEYWORDS.contains(current))
        current = builder.eatError("wrong.function.keyword");
      else
        current = builder.eatElement();
    }

    keywordsMarker.done(FUNCTION_KEYWORDS_CLAUSE_ELEMENT);
  }

  private static void parseParameterList(UnrealPsiBuilder builder) {
    builder.fastForwardTo(TokenSet.create(LPAREN));
    PsiBuilder.Marker marker = builder.mark();
    builder.skipElement();

    while (parseParameter(builder)) {
    }

    marker.done(PARAMETER_LIST);
  }

  private static boolean parseParameter(UnrealPsiBuilder builder) {
    PsiBuilder.Marker paramMarker = builder.mark();

    final int commaPos = builder.getFirstTokenPos(COMMA);
    final int rParenPos = builder.getFirstTokenPos(RPAREN);
    final int endPos = commaPos < rParenPos ? commaPos : rParenPos;
    if (commaPos == -1 || rParenPos == -1){
      builder.eatError(paramMarker, "syntax.error");
      return false;
    }

    parseParameterKeys(builder, endPos - 2);

    if (!TypeParser.parse(builder)) {
      builder.error("type.expected");
    }

    String paramName;
    if (builder.compareToken(IDENTIFIER)) {
      builder.eatElement();
    } else {
      builder.error("identifier.expected");
    }

    builder.fastForwardTo(TokenSet.create(RPAREN, COMMA));
    paramMarker.done(PARAMETER_ELEMENT);
    builder.skipElement();

    return commaPos < rParenPos;
  }

  private static void parseParameterKeys(UnrealPsiBuilder builder, int keyTokensNum) {
    PsiBuilder.Marker keysMarker = builder.mark();

    IElementType current = builder.getTokenType();
    while (keyTokensNum > 0) {
      if (PARAMETER_KEY_KEYWORDS.contains(current))
        current = builder.eatElement();
      else
        current = builder.eatError("wrong.parameter.keyword");

      --keyTokensNum;
    }

    keysMarker.done(PARAMETER_KEY_CLAUSE_ELEMENT);
  }
}
