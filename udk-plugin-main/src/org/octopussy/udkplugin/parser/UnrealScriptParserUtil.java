package org.octopussy.udkplugin.parser;

import com.intellij.lang.PsiBuilder;

/**
 * Created with IntelliJ IDEA.
 * User: dmonych
 * Date: 17.04.12
 * Time: 16:35
 */
public class UnrealScriptParserUtil extends GeneratedParserUtilBase {
  public static boolean parseGrammar(PsiBuilder builder_, int level, Parser parser) {
    ErrorState state = ErrorState.get(builder_);
    return parseAsTree(state, builder_, level, DUMMY_BLOCK, true, parser, TRUE_CONDITION);
  }
}
