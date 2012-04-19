package org.octopussy.udkplugin.lang.psi.impl;

import com.intellij.lang.ASTNode;
import org.octopussy.udkplugin.lang.psi.api.UnrealClassDef;

/**
 * User: dmonych
 * Date: 19.04.12
 */
public class UnrealClassDefImpl extends UnrealPsiElementImpl implements UnrealClassDef{
  public UnrealClassDefImpl(ASTNode node) {
    super(node);
  }
}
