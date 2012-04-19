package org.octopussy.udkplugin.lang.parser.parsing;

import com.intellij.lang.PsiBuilder;
import org.octopussy.udkplugin.lang.UnrealElementTypes;
import org.octopussy.udkplugin.lang.parser.util.UnrealPsiBuilder;
import static org.octopussy.udkplugin.lang.UnrealTokenTypes.*;

/**
 * User: dmonych
 * Date: 19.04.12
 */
public class ReferenceParser  implements UnrealElementTypes {
  public static final boolean parseForClass(UnrealPsiBuilder builder){
    if (!builder.compareToken(IDENTIFIER)){
      return false;
    }

    PsiBuilder.Marker marker = builder.mark();
    builder.match();
    marker.done(CLASS_REF);

    return true;
  }
}
