package com.octopussy.udkplugin.lexer;

import com.intellij.psi.tree.IElementType;

public interface UnrealScriptTokens {
    IElementType NEW_LINE = new UnrealScriptElementType("new line");

    //comments
    IElementType C_STYLE_COMMENT = new UnrealScriptElementType("c style comment");
    IElementType END_OF_LINE_COMMENT = new UnrealScriptElementType("eol comment");
    IElementType DOC_COMMENT = new UnrealScriptElementType("doc comment");

    //
    IElementType IDENTIFIER = new UnrealScriptElementType("identifier");

    // literals
    IElementType LONG_LITERAL = new UnrealScriptElementType("long literal");
    IElementType INTEGER_LITERAL = new UnrealScriptElementType("integer literal");
    IElementType FLOAT_LITERAL = new UnrealScriptElementType("float literal");
    IElementType DOUBLE_LITERAL = new UnrealScriptElementType("double literal");
    IElementType CHARACTER_LITERAL = new UnrealScriptElementType("character literal");
    IElementType STRING_LITERAL = new UnrealScriptElementType("string literal");

    // keywords
    IElementType TRUE_KEYWORD = new UnrealScriptElementType("true keyword");
    IElementType FALSE_KEYWORD = new UnrealScriptElementType("false keyword");
    IElementType NONE_KEYWORD = new UnrealScriptElementType("none keyword");
    IElementType VAR_KEYWORD = new UnrealScriptElementType("var keyword");
    IElementType CLASS_KEYWORD = new UnrealScriptElementType("class keyword");
    IElementType CASE_KEYWORD = new UnrealScriptElementType("case keyword");
    IElementType NEW_KEYWORD = new UnrealScriptElementType("new keyword");
    IElementType CONTINUE_KEYWORD = new UnrealScriptElementType("continue keyword");
    IElementType FOR_KEYWORD = new UnrealScriptElementType("for keyword");
    IElementType IF_KEYWORD = new UnrealScriptElementType("if keyword");
    IElementType FLOAT_KEYWORD = new UnrealScriptElementType("float keyword");
    IElementType BREAK_KEYWORD = new UnrealScriptElementType("break keyword");
    IElementType STATIC_KEYWORD = new UnrealScriptElementType("static keyword");
    IElementType WHILE_KEYWORD = new UnrealScriptElementType("while keyword");
    IElementType VOID_KEYWORD = new UnrealScriptElementType("void keyword");
    IElementType PROTECTED_KEYWORD = new UnrealScriptElementType("protected keyword");
    IElementType ELSE_KEYWORD = new UnrealScriptElementType("else keyword");
    IElementType INTERFACE_KEYWORD = new UnrealScriptElementType("interface keyword");
    IElementType BOOLEAN_KEYWORD = new UnrealScriptElementType("bool keyword");
    IElementType SWITCH_KEYWORD = new UnrealScriptElementType("switch keyword");
    IElementType PUBLIC_KEYWORD = new UnrealScriptElementType("public keyword");
    IElementType SAME_KEYWORD = new UnrealScriptElementType("same keyword");
    IElementType PRIVATE_KEYWORD = new UnrealScriptElementType("private keyword");
    IElementType INT_KEYWORD = new UnrealScriptElementType("int keyword");
    IElementType RETURN_KEYWORD = new UnrealScriptElementType("return keyword");
    IElementType DO_KEYWORD = new UnrealScriptElementType("do keyword");
    IElementType NATIVE_KEYWORD = new UnrealScriptElementType("native keyword");
    IElementType GOTO_KEYWORD = new UnrealScriptElementType("goto keyword");
    IElementType SUPER_KEYWORD = new UnrealScriptElementType("super keyword");
    IElementType EXTENDS_KEYWORD = new UnrealScriptElementType("extends keyword");
    IElementType DEPENDSON_KEYWORD = new UnrealScriptElementType("dependson keyword");

}
