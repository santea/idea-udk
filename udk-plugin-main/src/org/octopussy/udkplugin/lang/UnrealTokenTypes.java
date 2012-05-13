package org.octopussy.udkplugin.lang;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

/**
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
  UnrealElementType LOCAL_KEYWORD = new UnrealElementType("local");

  // common tokens
  UnrealElementType LPAREN = new UnrealElementType("(");
  UnrealElementType RPAREN = new UnrealElementType(")");
  UnrealElementType COMMA = new UnrealElementType(",");
  UnrealElementType LCURLY = new UnrealElementType("{");
  UnrealElementType RCURLY = new UnrealElementType("}");

  // type keywords
  UnrealElementType BYTE_KEYWORD = new UnrealElementType("byte");
  UnrealElementType INT_KEYWORD = new UnrealElementType("int");
  UnrealElementType BOOL_KEYWORD = new UnrealElementType("bool");
  UnrealElementType FLOAT_KEYWORD = new UnrealElementType("float");
  UnrealElementType STRING_KEYWORD = new UnrealElementType("string");
  UnrealElementType NAME_KEYWORD = new UnrealElementType("name");

  UnrealElementType IF_KEYWORD = new UnrealElementType("if");
  UnrealElementType FOR_KEYWORD = new UnrealElementType("for");

  // other keywords
  UnrealElementType NATIVE_KEYWORD = new UnrealElementType("native");
  UnrealElementType NATIVEREPLICATION_KEYWORD = new UnrealElementType("nativereplication");
  UnrealElementType ABSTRACT_KEYWORD = new UnrealElementType("abstract");
  UnrealElementType GUID_KEYWORD = new UnrealElementType("guid");
  UnrealElementType TRANSIENT_KEYWORD = new UnrealElementType("transient");
  UnrealElementType CONFIG_KEYWORD = new UnrealElementType("config");
  UnrealElementType PLACEABLE_KEYWORD = new UnrealElementType("placeable");
  UnrealElementType NOTPLACEABLE_KEYWORD = new UnrealElementType("notplaceable");
  UnrealElementType HIDECATEGORY_KEYWORD = new UnrealElementType("hidecategory");
  UnrealElementType NOEXPORT_KEYWORD = new UnrealElementType("noexport");

  UnrealElementType CONST_KEYWORD = new UnrealElementType("const");
  UnrealElementType EDITCONST_KEYWORD = new UnrealElementType("editconst");
  UnrealElementType INPUT_KEYWORD = new UnrealElementType("input");
  UnrealElementType PRIVATE_KEYWORD = new UnrealElementType("private");
  UnrealElementType TRAVEL_KEYWORD = new UnrealElementType("travel");
  UnrealElementType EXPORT_KEYWORD = new UnrealElementType("export");
  UnrealElementType PROTECTED_KEYWORD = new UnrealElementType("protected");
  UnrealElementType ARCHETYPE_KEYWORD = new UnrealElementType("archetype");

  UnrealElementType FUNCTION_KEYWORD = new UnrealElementType("function");

  UnrealElementType STATIC_KEYWORD = new UnrealElementType("static");
  UnrealElementType SINGULAR_KEYWORD = new UnrealElementType("singular");
  UnrealElementType LATENT_KEYWORD = new UnrealElementType("latent");
  UnrealElementType ITERATOR_KEYWORD = new UnrealElementType("iterator");
  UnrealElementType FINAL_KEYWORD = new UnrealElementType("final");
  UnrealElementType SIMULATED_KEYWORD = new UnrealElementType("simulated");
  UnrealElementType OPERATOR_KEYWORD = new UnrealElementType("operator");
  UnrealElementType PREOPERATOR_KEYWORD = new UnrealElementType("preOperator");
  UnrealElementType POSTOPERATOR_KEYWORD = new UnrealElementType("postOperator");
  UnrealElementType EVENT_KEYWORD = new UnrealElementType("event");

  UnrealElementType OUT_KEYWORD = new UnrealElementType("out");
  UnrealElementType OPTIONAL_KEYWORD = new UnrealElementType("optional");
  UnrealElementType COERCE_KEYWORD = new UnrealElementType("coerce");

  TokenSet BUILTIN_TYPES = TokenSet.create(BYTE_KEYWORD, INT_KEYWORD, BOOL_KEYWORD, FLOAT_KEYWORD, STRING_KEYWORD, NAME_KEYWORD);

  TokenSet CLASS_KEYWORDS = TokenSet.create(NATIVE_KEYWORD, NATIVEREPLICATION_KEYWORD, ABSTRACT_KEYWORD, GUID_KEYWORD, TRANSIENT_KEYWORD, CONFIG_KEYWORD,
          PLACEABLE_KEYWORD, NOTPLACEABLE_KEYWORD, HIDECATEGORY_KEYWORD, NOEXPORT_KEYWORD);

  TokenSet VARIABLE_KEYWORDS = TokenSet.create(CONST_KEYWORD, EDITCONST_KEYWORD, INPUT_KEYWORD, TRANSIENT_KEYWORD,
          NATIVE_KEYWORD, PRIVATE_KEYWORD, TRAVEL_KEYWORD, CONFIG_KEYWORD, EXPORT_KEYWORD, PROTECTED_KEYWORD, ARCHETYPE_KEYWORD);

  TokenSet FUNCTION_KEYWORDS = TokenSet.create(STATIC_KEYWORD, SINGULAR_KEYWORD, NATIVE_KEYWORD, LATENT_KEYWORD, ITERATOR_KEYWORD,
          FINAL_KEYWORD, SIMULATED_KEYWORD, OPERATOR_KEYWORD, PREOPERATOR_KEYWORD, POSTOPERATOR_KEYWORD, EVENT_KEYWORD);

  TokenSet PARAMETER_KEY_KEYWORDS = TokenSet.create(OUT_KEYWORD, OPTIONAL_KEYWORD, COERCE_KEYWORD);

  TokenSet OTHER_KEYWORDS = TokenSet.create(FUNCTION_KEYWORD, CLASS_KEYWORD, EXTENDS_KEYWORD,
          VAR_KEYWORD, LOCAL_KEYWORD, IF_KEYWORD, FOR_KEYWORD);

}
