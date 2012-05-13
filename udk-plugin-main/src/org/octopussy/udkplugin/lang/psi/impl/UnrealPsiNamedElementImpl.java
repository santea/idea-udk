package org.octopussy.udkplugin.lang.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.octopussy.udkplugin.lang.psi.api.UnrealPsiElement;
import org.octopussy.udkplugin.lang.psi.api.UnrealPsiNamedElement;

/**
 * User: dmonych
 * Date: 17.04.12
 */
public abstract class UnrealPsiNamedElementImpl extends UnrealPsiElementImpl implements UnrealPsiNamedElement {
  public UnrealPsiNamedElementImpl(ASTNode node) {
    super(node);
  }

  @Override
  public String toString() {
    return getNode().getElementType().toString();
  }

  @Override
  public abstract PsiElement getNameElement();


  @Override
  public String getName() {
    PsiElement nameElement = getNameElement();
    if (nameElement != null) {
      return nameElement.getText();
    }
    return null;
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
    return null;
  }
}
