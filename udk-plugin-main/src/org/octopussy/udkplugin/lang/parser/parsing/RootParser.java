package org.octopussy.udkplugin.lang.parser.parsing;

import com.intellij.lang.PsiBuilder;
import org.octopussy.udkplugin.lang.UnrealElementTypes;
import org.octopussy.udkplugin.lang.parser.util.UnrealPsiBuilder;

import static org.octopussy.udkplugin.lang.UnrealTokenTypes.*;

/**
 * User: dmonych
 * Date: 19.04.12
 */
public class RootParser implements UnrealElementTypes {
  public static void parse(UnrealPsiBuilder builder) {
    while (!builder.eof()){
      if (builder.compareToken(CLASS)){
        PsiBuilder.Marker marker = builder.mark();
        builder.match(CLASS);

        if (!ReferenceParser.parseForClass(builder)){
          builder.error("identifier.expected");
        }

        builder.match(SEMICOLON, "semicolon.expected");
        marker.done(CLASS_DECLARATION);
      }else{
        builder.eatError("class.expected");
      }
    }
  }
}
