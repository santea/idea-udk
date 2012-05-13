package org.octopussy.udkplugin.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.octopussy.udkplugin.lang.UnrealTokenTypes;
import org.octopussy.udkplugin.lang.psi.api.UnrealClassDef;

/**
 * User: dmonych
 * Date: 19.04.12
 */
public class UnrealClassDefImpl extends UnrealPsiNamedElementImpl implements UnrealClassDef{
  public UnrealClassDefImpl(ASTNode node) {
    super(node);
  }

  @Override
  public PsiElement getNameElement() {
    return findChildByClass(UnrealRefImpl.class);
  }
}
