package org.octopussy.udkplugin.lang.psi.api;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;

/**
 * User: dmonych
 * Date: 17.04.12
 */

public interface UnrealPsiNamedElement extends PsiNamedElement {
  PsiElement getNameElement();
}
