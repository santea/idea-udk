package org.octopussy.udkplugin.lang.parser.parsing;

import org.octopussy.udkplugin.lang.UnrealElementTypes;
import org.octopussy.udkplugin.lang.parser.parsing.ClassParser;
import org.octopussy.udkplugin.lang.parser.util.UnrealPsiBuilder;

import static org.octopussy.udkplugin.lang.UnrealTokenTypes.*;

/**
 * User: dmonych
 * Date: 19.04.12
 */
public class FileParser implements UnrealElementTypes {
  public static void parse(UnrealPsiBuilder builder) {
    ClassParser.parse(builder);
  }
}
