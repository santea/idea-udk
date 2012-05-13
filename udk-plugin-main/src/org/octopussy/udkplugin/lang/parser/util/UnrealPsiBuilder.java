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

  public IElementType compareToken(TokenSet tokens) {
    if (tokens.contains(myBuilder.getTokenType()))
      return myBuilder.getTokenType();
    return null;
  }

  public PsiBuilder.Marker mark() {
    return myBuilder.mark();
  }

  public void cleanAfterError(String errorText) {
    int i = 0;
    PsiBuilder.Marker em = mark();
    while (!myBuilder.eof() && !(compareToken(WHITE_SPACE)) || compareToken(SEMICOLON)) {
      skipElement();
      i++;
    }
    if (i > 0) {
      eatError(em, errorText);
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
    if (lookupElement != null)
      return result;
    return -1;
  }

  public IElementType fastForwardTo(final TokenSet tokens) {
    while(!myBuilder.eof() && !tokens.contains(myBuilder.getTokenType())){
      myBuilder.advanceLexer();
    }

    return myBuilder.getTokenType();
  }

  public void error(String errorMessage) {
    myBuilder.error(UdkBundle.message(errorMessage));
  }

  public IElementType eatError(String errorMessage) {
    PsiBuilder.Marker marker = myBuilder.mark();
    myBuilder.advanceLexer();
    marker.error(UdkBundle.message(errorMessage));
    return myBuilder.getTokenType();
  }

  public void eatError(PsiBuilder.Marker marker, String errorMessage) {
    marker.error(UdkBundle.message(errorMessage));
  }

  public String getTokenText() {
    return myBuilder.getTokenText();
  }

  public IElementType skipElement(){
    myBuilder.advanceLexer();
    return myBuilder.getTokenType();
  }

  public IElementType eatElement() {
    IElementType current = myBuilder.getTokenType();
    PsiBuilder.Marker marker = myBuilder.mark();
    myBuilder.advanceLexer();
    marker.done(current);
    return myBuilder.getTokenType();
  }

  public IElementType eatElement(IElementType elem) {
    PsiBuilder.Marker marker = myBuilder.mark();
    myBuilder.advanceLexer();
    marker.done(elem);
    return myBuilder.getTokenType();
  }
}
