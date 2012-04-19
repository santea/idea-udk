package org.octopussy.udkplugin.lang.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import org.octopussy.udkplugin.lang.UnrealElementTypes;
import org.octopussy.udkplugin.lang.psi.impl.UnrealClassDefImpl;
import org.octopussy.udkplugin.lang.psi.impl.UnrealPsiElementImpl;
import org.octopussy.udkplugin.lang.psi.impl.UnrealRefImpl;

/**
 * Created with IntelliJ IDEA.
 * User: dmonych
 * Date: 19.04.12
 * Time: 16:35
 */
public class UnrealPsiFactory implements UnrealElementTypes{
  public static PsiElement createElement(ASTNode node) {
    final IElementType type = node.getElementType();

    if (type.equals(CLASS_DECLARATION)){
      return new UnrealClassDefImpl(node);
    }

    if (type.equals(CLASS_REF)){
      return new UnrealRefImpl(node);
    }

    return new UnrealPsiElementImpl(node);
  }
}
