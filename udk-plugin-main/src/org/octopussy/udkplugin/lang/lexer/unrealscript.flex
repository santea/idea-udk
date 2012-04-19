package org.octopussy.udkplugin.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import org.octopussy.udkplugin.lang.UnrealTokenTypes;

%%

%class _UnrealLexer
%implements FlexLexer, UnrealTokenTypes
%unicode
%public

%type IElementType

%function advance

%eof{ return;
%eof}

WHITE_SPACE_CHAR=[\ \n\r\t\f]

IDENTIFIER=[:jletter:] [:jletterdigit:]*

C_STYLE_COMMENT=("/*"[^"*"]{COMMENT_TAIL})|"/*"
DOC_COMMENT="/*""*"+("/"|([^"/""*"]{COMMENT_TAIL}))?
COMMENT_TAIL=([^"*"]*("*"+[^"*""/"])?)*("*"+"/")?
LINE_COMMENT="/""/"[^\r\n]*

DIGIT=[0-9]
DIGIT_OR_UNDERSCORE=[_0-9]
HEX_DIGIT=[0-9A-Fa-f]
HEX_DIGIT_OR_UNDERSCORE=[_0-9A-Fa-f]

DIGITS={DIGIT}|({DIGIT}{DIGIT_OR_UNDERSCORE}*{DIGIT})
HEX_DIGITS={HEX_DIGIT}|({HEX_DIGIT}{HEX_DIGIT_OR_UNDERSCORE}*{HEX_DIGIT})
BINARY_DIGITS={BINARY_DIGIT}|({BINARY_DIGIT}{BINARY_DIGIT_OR_UNDERSCORE}*{BINARY_DIGIT})

INTEGER_LITERAL={DECIMAL_INTEGER_LITERAL}|{HEX_INTEGER_LITERAL}
DECIMAL_INTEGER_LITERAL=0|([1-9]({DIGIT_OR_UNDERSCORE}*{DIGIT})?)
HEX_INTEGER_LITERAL=0[Xx]{HEX_DIGITS}?

FLOAT_LITERAL=({FLOATING_POINT_LITERAL1}|{FLOATING_POINT_LITERAL2}|{FLOATING_POINT_LITERAL3}|{FLOATING_POINT_LITERAL4})[Ff]
DOUBLE_LITERAL=(({FLOATING_POINT_LITERAL1}|{FLOATING_POINT_LITERAL2}|{FLOATING_POINT_LITERAL3})[Dd]?)|({FLOATING_POINT_LITERAL4}[Dd])
FLOATING_POINT_LITERAL1={DIGITS}"."{DIGITS}?{EXPONENT_PART}?
FLOATING_POINT_LITERAL2="."{DIGITS}{EXPONENT_PART}?
FLOATING_POINT_LITERAL3={DIGITS}{EXPONENT_PART}
FLOATING_POINT_LITERAL4={DIGITS}
EXPONENT_PART=[Ee]["+""-"]?{DIGITS}?

BINARY_EXPONENT=[Pp][+-]?{DIGITS}
HEX_SIGNIFICAND={HEX_INTEGER_LITERAL}|{HEX_INTEGER_LITERAL}.|0[Xx]{HEX_DIGITS}?.{HEX_DIGITS}

CHARACTER_LITERAL="'"([^\\\'\r\n]|{ESCAPE_SEQUENCE})*("'"|\\)?
STRING_LITERAL=\"([^\\\"\r\n]|{ESCAPE_SEQUENCE})*(\"|\\)?
ESCAPE_SEQUENCE=\\[^\r\n]

%%

{WHITE_SPACE_CHAR}+     { return WHITE_SPACE; }
{C_STYLE_COMMENT}       { return C_STYLE_COMMENT; }
{LINE_COMMENT}          { return LINE_COMMENT; }

//{DOC_COMMENT}           { return DOC_COMMENT; }
//{INTEGER_LITERAL}       { return INTEGER_LITERAL; }
//{FLOAT_LITERAL}         { return FLOAT_LITERAL; }
//{CHARACTER_LITERAL}     { return CHARACTER_LITERAL; }

{STRING_LITERAL}        { return STRING_LITERAL; }

";"                     { return SEMICOLON; }

"class"                 { return CLASS; }
"extends"               { return EXTENDS; }
   /*
"true"                  { return TRUE_KEYWORD; }
"false"                 { return FALSE_KEYWORD; }
"None"                  { return NONE_KEYWORD; }
"var"                   { return VAR_KEYWORD; }
"bool"                  { return BOOLEAN_KEYWORD; }
"break"                 { return BREAK_KEYWORD; }
"case"                  { return CASE_KEYWORD; }
"class"                 { return CLASS_KEYWORD; }
"continue"              { return CONTINUE_KEYWORD; }
"do"                    { return DO_KEYWORD; }
"else"                  { return ELSE_KEYWORD; }
"float"                 { return FLOAT_KEYWORD; }
"for"                   { return FOR_KEYWORD; }
"goto"                  { return GOTO_KEYWORD; }
"if"                    { return IF_KEYWORD; }
"int"                   { return INT_KEYWORD; }
"native"                { return NATIVE_KEYWORD; }
"new"                   { return NEW_KEYWORD; }
"private"               { return PRIVATE_KEYWORD; }
"interface" { return INTERFACE_KEYWORD; }
"public" { return PUBLIC_KEYWORD; }
"super" { return SUPER_KEYWORD; }
"switch" { return SWITCH_KEYWORD; }
"same" { return SAME_KEYWORD; }
"protected" { return PROTECTED_KEYWORD; }
"return" { return RETURN_KEYWORD; }
"void" { return VOID_KEYWORD; }
"static" { return STATIC_KEYWORD; }
"while" { return WHILE_KEYWORD; }
"extends" { return EXTENDS_KEYWORD; }
"dependson" { return DEPENDSON_KEYWORD; }
 {IDENTIFIER} { return IDENTIFIER; }
 "==" { return EQEQ; }
"!=" { return NE; }
"||" { return OROR; }
"++" { return PLUSPLUS; }
"--" { return MINUSMINUS; }
 "<" { return LT; }
"<=" { return LE; }
"<<=" { return LTLTEQ; }
"<<" { return LTLT; }
">" { return GT; }
"&" { return AND; }
"&&" { return ANDAND; }
 "+=" { return PLUSEQ; }
"-=" { return MINUSEQ; }
"*=" { return ASTERISKEQ; }
"/=" { return DIVEQ; }
"&=" { return ANDEQ; }
"|=" { return OREQ; }
"^=" { return XOREQ; }
"%=" { return PERCEQ; }
 "("   { return LPARENTH; }
")"   { return RPARENTH; }
"{"   { return LBRACE; }
"}"   { return RBRACE; }
"["   { return LBRACKET; }
"]"   { return RBRACKET; }
";"   { return SEMICOLON; }
","   { return COMMA; }
"..." { return ELLIPSIS; }
"."   { return DOT; }
 "=" { return EQ; }
"!" { return EXCL; }
"~" { return TILDE; }
"?" { return QUEST; }
":" { return COLON; }
"+" { return PLUS; }
"-" { return MINUS; }
"*" { return ASTERISK; }
"/" { return DIV; }
"|" { return OR; }
"^" { return XOR; }
"%" { return PERC; }
"@" { return AT; }
                            */
{IDENTIFIER}            { return IDENTIFIER; }
.                       { return BAD_CHARACTER; }