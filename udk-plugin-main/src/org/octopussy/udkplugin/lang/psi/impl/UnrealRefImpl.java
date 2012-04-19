package org.octopussy.udkplugin.lang.psi.impl;

import com.intellij.lang.ASTNode;
import org.octopussy.udkplugin.lang.psi.api.UnrealRef;

/**
 * User: dmonych
 * Date: 19.04.12
 */
public class UnrealRefImpl extends UnrealPsiElementImpl implements UnrealRef{
  public UnrealRefImpl(ASTNode node) {
    super(node);
  }
}
