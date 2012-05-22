package org.octopussy.udkplugin.lang;

/**
 * User: dmonych
 * Date: 19.04.12
 */
public interface UnrealElementTypes {
  UnrealElementType TYPE_ELEMENT = new UnrealElementType("Type element");

  UnrealElementType CLASS_DECLARATION = new UnrealElementType("Unreal class declaration");
  UnrealElementType CLASS_KEYWORD_LIST_ELEMENT = new UnrealElementType("Class keyword list");

  UnrealElementType FUNCTION_DECLARATION = new UnrealElementType("Function declaration");
  UnrealElementType FUNCTION_KEYWORD_LIST_ELEMENT = new UnrealElementType("Function keyword list");

  UnrealElementType VARIABLE_DECLARATION = new UnrealElementType("Variable declaration");
  UnrealElementType VARIABLE_KEYWORD_LIST_ELEMENT = new UnrealElementType("Variable keyword list");

  UnrealElementType REFERENCE_ELEMENT = new UnrealElementType("Reference element");
  UnrealElementType EXTENDS_CLAUSE_ELEMENT = new UnrealElementType("Extends clause");

  UnrealElementType PARAMETER_LIST = new UnrealElementType("Parameter list");
  UnrealElementType PARAMETER_ELEMENT = new UnrealElementType("Parameter element");
  UnrealElementType PARAMETER_KEY_CLAUSE_ELEMENT = new UnrealElementType("Parameter keys");

  UnrealElementType CODE_BLOCK_ELEMENT = new UnrealElementType("Code block");

  UnrealElementType CONDITIONAL_EXPRESSION = new UnrealElementType("Conditional expression");

  UnrealElementType IF_STATEMENT_ELEMENT = new UnrealElementType("If statement");
  UnrealElementType FOR_STATEMENT_ELEMENT = new UnrealElementType("For statement");
}
