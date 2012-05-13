package org.octopussy.udkplugin.lang.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.octopussy.udkplugin.lang.parser.parsing.toplevel.FileParser;
import org.octopussy.udkplugin.lang.parser.util.UnrealPsiBuilder;

/**
 * Created with IntelliJ IDEA.
 * User: dmonych
 * Date: 19.04.12
 * Time: 16:07
 */

public class UnrealParser implements PsiParser{
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
}
