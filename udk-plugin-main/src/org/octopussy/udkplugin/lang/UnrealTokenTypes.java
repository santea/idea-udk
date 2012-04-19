package org.octopussy.udkplugin.lang;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

/**
 * Created with IntelliJ IDEA.
 * User: dmonych
 * Date: 19.04.12
 * Time: 15:17
 */
public interface UnrealTokenTypes {
  IElementType WHITE_SPACE = TokenType.WHITE_SPACE;
  IElementType BAD_CHARACTER = TokenType.BAD_CHARACTER;

  IElementType C_STYLE_COMMENT = new UnrealElementType("C_STYLE_COMMENT");
  IElementType LINE_COMMENT = new UnrealElementType("LINE_COMMENT");

  UnrealElementType IDENTIFIER = new UnrealElementType("IDENTIFIER");

  UnrealElementType STRING_LITERAL = new UnrealElementType("STRING_LITERAL");

  UnrealElementType SEMICOLON = new UnrealElementType(";");

  // keywords
  UnrealElementType CLASS = new UnrealElementType("CLASS");
  UnrealElementType EXTENDS = new UnrealElementType("extends keyword");
}
