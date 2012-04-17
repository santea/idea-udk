package org.octopussy.udkplugin.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.octopussy.udkplugin.psi.UnrealScriptElement;

/**
 * Created with IntelliJ IDEA.
 * User: dmonych
 * Date: 17.04.12
 * Time: 15:52
 */
public class UnrealScriptElementImpl extends ASTWrapperPsiElement implements UnrealScriptElement{
  public UnrealScriptElementImpl(ASTNode node) {
    super(node);
  }

  @Override
  public String toString() {
    return getNode().getElementType().toString();
  }
}
