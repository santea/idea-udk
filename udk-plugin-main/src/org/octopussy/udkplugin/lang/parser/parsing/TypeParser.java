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
public class TypeParser implements UnrealElementTypes {
  public static final boolean parse(UnrealPsiBuilder builder){
    final IElementType currentToken = builder.getTokenType();

    if(!currentToken.equals(IDENTIFIER) && !BUILTIN_TYPES.contains(currentToken)){
      return false;
    }

    PsiBuilder.Marker typeMarker = builder.mark();
    builder.skipElement();
    typeMarker.done(TYPE_ELEMENT);

    return true;
  }
}
