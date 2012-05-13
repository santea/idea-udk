package org.octopussy.udkplugin.lang.parser.parsing;

import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import org.octopussy.udkplugin.lang.UnrealElementTypes;
import org.octopussy.udkplugin.lang.parser.util.UnrealPsiBuilder;

import static org.octopussy.udkplugin.lang.UnrealTokenTypes.*;

/**
 * User: dmonych
 * Date: 12.05.12
 */
public class ClassParser implements UnrealElementTypes {
  public static boolean parse(UnrealPsiBuilder builder) {
    if (!builder.compareToken(CLASS_KEYWORD)) {
      builder.cleanAfterError("class.expected");
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
      builder.eatElement(IDENTIFIER);
    }

    // extends
    if (builder.compareToken(EXTENDS_KEYWORD)) {
      ReferenceParser.parseExtends(builder);
    }

    // keywords
    parseKeywords(builder);

    // class content
    while(!builder.eof()){
      final IElementType token = builder.getTokenType();
      if (VariableParser.tryParse(builder, false)){}
        else if(FunctionParser.tryParse(builder)){
      }else {
        builder.skipElement();
        builder.error("syntax.error");
      }
    }
    marker.done(CLASS_DECLARATION);

    return true;
  }

  private static void parseKeywords(UnrealPsiBuilder builder) {
    PsiBuilder.Marker keywordsMarker = builder.mark();

    int semicolonPos = builder.getFirstTokenPos(SEMICOLON);
    if (semicolonPos == -1){
      keywordsMarker.error("semicolon.expected");
      return;
    }

    IElementType current = builder.getTokenType();
    int pos = 0;
    while(pos < semicolonPos){
      builder.eatElement();
      ++pos;
    }

    builder.match(SEMICOLON, "semicolon.expected");
    keywordsMarker.done(CLASS_KEYWORDS_CLAUSE_ELEMENT);
  }
}
