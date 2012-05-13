package org.octopussy.udkplugin.lang;

/**
 * User: dmonych
 * Date: 19.04.12
 */
public interface UnrealElementTypes {
  UnrealElementType TYPE_ELEMENT = new UnrealElementType("Type element");

  UnrealElementType CLASS_DECLARATION = new UnrealElementType("Unreal class declaration");
  UnrealElementType VARIABLE_DECLARATION = new UnrealElementType("Variable declaration");
  UnrealElementType REFERENCE_ELEMENT = new UnrealElementType("Reference element");
  UnrealElementType EXTENDS_CLAUSE_ELEMENT = new UnrealElementType("Extends clause");
}
