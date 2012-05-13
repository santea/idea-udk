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
 */
public class ConditionalExpressionParser implements UnrealElementTypes {
  public static boolean parse(UnrealPsiBuilder builder) {
    PsiBuilder.Marker marker = builder.mark();
    if (!builder.compareToken(LPAREN)){
      builder.skipElement(); // '('
      builder.eatError(marker, "lparen.expected");
      return false;
    }

    IElementType ending = builder.fastForwardTo(TokenSet.create(RPAREN));
    if (ending == null){
      builder.eatError(marker, "rparen.expected");
    }
    else {
      builder.skipElement(); // ')'
      marker.done(CONDITIONAL_EXPRESSION);
    }

    return true;
  }
}
