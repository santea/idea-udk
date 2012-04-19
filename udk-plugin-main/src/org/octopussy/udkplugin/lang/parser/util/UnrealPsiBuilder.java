package org.octopussy.udkplugin.lang.parser.util;

import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import org.octopussy.udkplugin.UdkBundle;

/**
 * User: dmonych
 * Date: 19.04.12
 */

public class UnrealPsiBuilder {
  private final PsiBuilder myBuilder;

  public UnrealPsiBuilder(PsiBuilder builder) {
    myBuilder = builder;
  }

  public void match(){
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
}
