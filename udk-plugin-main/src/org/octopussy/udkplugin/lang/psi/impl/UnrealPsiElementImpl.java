package org.octopussy.udkplugin.lang.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.octopussy.udkplugin.lang.psi.api.UnrealPsiElement;

/**
 * User: dmonych
 * Date: 17.04.12
 */
public class UnrealPsiElementImpl extends ASTWrapperPsiElement implements UnrealPsiElement {
  public UnrealPsiElementImpl(ASTNode node) {
    super(node);
  }

  @Override
  public String toString() {
    return getNode().getElementType().toString();
  }
}
