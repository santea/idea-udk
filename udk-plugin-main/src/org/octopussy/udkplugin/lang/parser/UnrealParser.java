package org.octopussy.udkplugin.lang.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.octopussy.udkplugin.lang.parser.parsing.RootParser;
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
    builder.setDebugMode(true);
    PsiBuilder.Marker rootMarker = builder.mark();
    RootParser.parse(new UnrealPsiBuilder(builder));
    rootMarker.done(root);
    return builder.getTreeBuilt();
  }
}
