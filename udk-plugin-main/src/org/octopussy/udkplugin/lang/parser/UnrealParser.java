package org.octopussy.udkplugin.lang.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.octopussy.udkplugin.lang.UnrealElementTypes;
import org.octopussy.udkplugin.lang.parser.parsing.ConditionalExpressionParser;
import org.octopussy.udkplugin.lang.parser.parsing.FileParser;
import org.octopussy.udkplugin.lang.parser.parsing.VariableParser;
import org.octopussy.udkplugin.lang.parser.util.UnrealPsiBuilder;

import static org.octopussy.udkplugin.lang.UnrealTokenTypes.*;

/**
 * Created with IntelliJ IDEA.
 * User: dmonych
 * Date: 19.04.12
 * Time: 16:07
 */

public class UnrealParser implements PsiParser, UnrealElementTypes {
  @NotNull
  @Override
  public ASTNode parse(IElementType root, PsiBuilder builder) {
    final UnrealPsiBuilder builderEx = new UnrealPsiBuilder(builder);

    builder.setDebugMode(true);
    PsiBuilder.Marker rootMarker = builderEx.mark();
    FileParser.parse(builderEx);
    rootMarker.done(root);
    return builder.getTreeBuilt();
  }

  public static boolean tryParseStatement(UnrealPsiBuilder builder) {
    if (VariableParser.tryParse(builder, true))
      return true;

    if (tryParseBlock(builder))
      return true;
    if (tryParseIfStatement(builder))
      return true;
    if (tryParseForStatement(builder))
      return true;

    builder.skipElement();

    return true;
  }

  public static boolean tryParseBlock(UnrealPsiBuilder builder) {
    if (!builder.compareToken(LCURLY)) {
      return false;
    }

    PsiBuilder.Marker blockMarker = builder.mark();

    builder.skipElement(); //skip {

    while (true) {
      if (builder.eof() || builder.compareToken(RCURLY)) break;
      if (!tryParseStatement(builder)) break;
    }

    builder.match(RCURLY, "rcurly.expected");

    blockMarker.done(CODE_BLOCK_ELEMENT);

    return true;
  }

  public static boolean tryParseIfStatement(UnrealPsiBuilder builder) {
    if (!builder.compareToken(IF_KEYWORD)) {
      return false;
    }

    PsiBuilder.Marker marker = builder.mark();
    builder.eatElement();

    if (!ConditionalExpressionParser.parse(builder)){
      builder.error("expression.expected");
    }
    tryParseBlock(builder);

    marker.done(IF_STATEMENT_ELEMENT);
    return true;
  }

  public static boolean tryParseForStatement(UnrealPsiBuilder builder) {
    if (!builder.compareToken(FOR_KEYWORD)) {
      return false;
    }

    PsiBuilder.Marker marker = builder.mark();
    builder.eatElement();

    if (!ConditionalExpressionParser.parse(builder)){
      builder.error("expression.expected");
    }
    tryParseBlock(builder);

    marker.done(FOR_STATEMENT_ELEMENT);
    return true;
  }
}
