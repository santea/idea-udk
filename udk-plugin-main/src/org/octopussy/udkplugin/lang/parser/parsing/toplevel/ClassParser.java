package org.octopussy.udkplugin.lang.parser.parsing.toplevel;

import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.octopussy.udkplugin.lang.UnrealElementTypes;
import org.octopussy.udkplugin.lang.parser.parsing.ReferenceParser;
import org.octopussy.udkplugin.lang.parser.parsing.TypeParser;
import org.octopussy.udkplugin.lang.parser.util.UnrealPsiBuilder;

import static org.octopussy.udkplugin.lang.UnrealTokenTypes.*;

/**
 * User: dmonych
 * Date: 12.05.12
 */
public class ClassParser implements UnrealElementTypes {
  public static boolean parse(UnrealPsiBuilder builder) {
    if (!builder.compareToken(CLASS_KEYWORD)) {
      return false;
    }
    PsiBuilder.Marker marker = builder.mark();
    builder.match(CLASS_KEYWORD);

    String className;
    if (!builder.compareToken(IDENTIFIER)) {
      builder.error("identifier.expected");
      return false;
    } else {
      className = builder.getTokenText();
      builder.matchAny();
    }

    if (builder.compareToken(EXTENDS_KEYWORD)) {
      ReferenceParser.parseExtends(builder);
    }

    builder.match(SEMICOLON, "semicolon.expected");
    builder.match(WHITE_SPACE);

    // parse class content
    while(!builder.eof()){
      final IElementType token = builder.getTokenType();
      if (token.equals(VAR_KEYWORD)){
        parseClassVariable(builder);
      }else {
        builder.matchAny();
        builder.error("syntax.error");
      }

      while (!builder.eof()){
        if (!(builder.match(SEMICOLON) && !builder.match(WHITE_SPACE)))
          break;
      }
    }
    marker.done(CLASS_DECLARATION);

    return true;
  }

  // var(category) keyword name[]
  private static boolean parseClassVariable(UnrealPsiBuilder builder) {
    PsiBuilder.Marker varMarker = builder.mark();
    builder.match(VAR_KEYWORD);

    // (category)
    String category;
    if (builder.compareToken(LPAREN)){
      builder.matchAny();
      if (builder.compareToken(IDENTIFIER)){
        category = builder.getTokenText();
        builder.matchAny();
      }else{
        category = "";
      }

      if (builder.fastForwardTo(TokenSet.create(SEMICOLON, RPAREN)).equals(RPAREN)){
        builder.matchAny();
      }else {
        builder.error("rparen.expected");
      }
    }

    if (!TypeParser.parse(builder)){
      varMarker.error("missing.type");
      return false;
    }

    String varName;
    if (!builder.compareToken(IDENTIFIER)) {
      varMarker.error("identifier.expected");
      return false;
    } else {
      varName = builder.getTokenText();
      builder.matchAny();
    }

    builder.match(SEMICOLON, "semicolon.expected");

    varMarker.done(VARIABLE_DECLARATION);

    return true;
  }
}
