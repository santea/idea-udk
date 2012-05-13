package org.octopussy.udkplugin.lang.parser.parsing.toplevel;

import com.intellij.lang.PsiBuilder;
import org.octopussy.udkplugin.lang.UnrealElementTypes;
import org.octopussy.udkplugin.lang.parser.parsing.ReferenceParser;
import org.octopussy.udkplugin.lang.parser.util.UnrealPsiBuilder;

import static org.octopussy.udkplugin.lang.UnrealTokenTypes.*;

/**
 * User: dmonych
 * Date: 19.04.12
 */
public class FileParser implements UnrealElementTypes {
  public static void parse(UnrealPsiBuilder builder) {
    if (!builder.compareToken(CLASS_KEYWORD)){
      builder.error("class.expected");
      builder.cleanAfterError();
      return;
    }
    ClassParser.parse(builder);
    builder.cleanAfterError();
  }
}
