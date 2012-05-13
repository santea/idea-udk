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
  IElementType DOC_COMMENT = new UnrealElementType("C_STYLE_COMMENT");
  IElementType LINE_COMMENT = new UnrealElementType("LINE_COMMENT");

  UnrealElementType IDENTIFIER = new UnrealElementType("identifier");

  UnrealElementType STRING_LITERAL = new UnrealElementType("string literal");

  UnrealElementType SEMICOLON = new UnrealElementType(";");

  // keywords
  UnrealElementType CLASS_KEYWORD = new UnrealElementType("class");
  UnrealElementType EXTENDS_KEYWORD = new UnrealElementType("extends");
  UnrealElementType VAR_KEYWORD = new UnrealElementType("var");

  // common tokens
  UnrealElementType LPAREN = new UnrealElementType("(");
  UnrealElementType RPAREN = new UnrealElementType(")");

  // type keywords
  UnrealElementType BYTE_KEYWORD = new UnrealElementType("byte");
  UnrealElementType INT_KEYWORD = new UnrealElementType("int");
  UnrealElementType BOOL_KEYWORD = new UnrealElementType("bool");
  UnrealElementType FLOAT_KEYWORD = new UnrealElementType("float");
  UnrealElementType STRING_KEYWORD = new UnrealElementType("string");
  UnrealElementType NAME_KEYWORD = new UnrealElementType("name");

  TokenSet BUILTIN_TYPES = TokenSet.create(BYTE_KEYWORD, INT_KEYWORD, BOOL_KEYWORD, FLOAT_KEYWORD, STRING_KEYWORD, NAME_KEYWORD);

}
