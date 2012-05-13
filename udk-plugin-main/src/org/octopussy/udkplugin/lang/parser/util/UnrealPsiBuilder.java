package org.octopussy.udkplugin.lang.parser.util;

import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.octopussy.udkplugin.UdkBundle;
import org.octopussy.udkplugin.lang.UnrealElementType;

import static org.octopussy.udkplugin.lang.UnrealTokenTypes.SEMICOLON;
import static org.octopussy.udkplugin.lang.UnrealTokenTypes.WHITE_SPACE;

/**
 * User: dmonych
 * Date: 19.04.12
 */

public class UnrealPsiBuilder {
  private final PsiBuilder myBuilder;

  public UnrealPsiBuilder(PsiBuilder builder) {
    myBuilder = builder;
  }

  public void matchAny(){
    myBuilder.advanceLexer();
  }

  public boolean match(IElementType element){
    if (element.equals(myBuilder.getTokenType())){
      myBuilder.advanceLexer();
      return true;
    }

    return false;
  }

  public boolean match(IElementType element, String errorMessage) {
    if (element.equals(myBuilder.getTokenType())) {
      myBuilder.advanceLexer();
      return true;
    } else {
      error(errorMessage);
    }
    return false;
  }

  public boolean eof() {
    return myBuilder.eof();
  }

  public boolean compareToken(IElementType type) {
    return type.equals(myBuilder.getTokenType());
  }

  public PsiBuilder.Marker mark() {
    return myBuilder.mark();
  }

  public void error(String errorMessage) {
    myBuilder.error(UdkBundle.message(errorMessage));
  }

  public void eatError(String errorMessage) {
    PsiBuilder.Marker marker = myBuilder.mark();
    myBuilder.advanceLexer();
    marker.error(UdkBundle.message(errorMessage));
  }

  public String getTokenText() {
    return myBuilder.getTokenText();
  }

  public void cleanAfterError() {
    int i = 0;
    PsiBuilder.Marker em = mark();
    while (!myBuilder.eof() && !(compareToken(WHITE_SPACE)) || compareToken(SEMICOLON)) {
      matchAny();
      i++;
    }
    if (i > 0) {
      em.error("separator.expected");
    } else {
      em.drop();
    }
  }

  public IElementType getTokenType() {
    return myBuilder.getTokenType();
  }

  public int getFirstTokenPos(UnrealElementType token) {
    int result = 0;
    IElementType lookupElement = myBuilder.lookAhead(result);
    while(lookupElement != null && !lookupElement.equals(token)){
      lookupElement = myBuilder.lookAhead(++result);
    }

    return result;
  }

  public IElementType fastForwardTo(final TokenSet tokens) {
    while(!tokens.contains(myBuilder.getTokenType())){
      myBuilder.advanceLexer();
    }

    return myBuilder.getTokenType();
  }
}
