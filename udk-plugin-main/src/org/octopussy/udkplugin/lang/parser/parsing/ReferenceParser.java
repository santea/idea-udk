package org.octopussy.udkplugin.lang.parser.parsing;

import com.intellij.lang.PsiBuilder;
import org.octopussy.udkplugin.lang.UnrealElementTypes;
import org.octopussy.udkplugin.lang.UnrealTokenTypes;
import org.octopussy.udkplugin.lang.parser.util.UnrealPsiBuilder;

/**
 * User: dmonych
 * Date: 19.04.12
 */
public class ReferenceParser implements UnrealElementTypes {
  public static final boolean parseExtends(UnrealPsiBuilder builder){
    PsiBuilder.Marker clauseMarker = builder.mark();
    if (!builder.match(UnrealTokenTypes.EXTENDS_KEYWORD)){
      clauseMarker.rollbackTo();
      return false;
    }

    PsiBuilder.Marker refMarker = builder.mark();
    if (!builder.match(UnrealTokenTypes.IDENTIFIER)){
      refMarker.rollbackTo();
      clauseMarker.rollbackTo();
      return false;
    }else{
      refMarker.done(REFERENCE_ELEMENT);
    }

    clauseMarker.done(EXTENDS_CLAUSE_ELEMENT);

    return true;
  }
}
