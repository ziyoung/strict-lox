grammar Lox;

compilationUnit
    : packageDeclaration topLevelObject*
    ;

packageDeclaration
    : 'package' ID ';'
    ;

topLevelObject
    : classDeclaration
    | functionDeclaration
    | variableDeclaration
    ;

classDeclaration
    : 'class' ID '{' memberDeclaration* '}'
    ;

memberDeclaration
    : proptertyDeclaration
    | methodDeclaration
    ;

proptertyDeclaration
    : ID ':' type ('=' expression)? ';'
//    | ID '=' expression ';'
    ;

functionDeclaration
    : 'fun' methodDeclaration
    ;

methodDeclaration
    : ID '(' typeParameters? ')' (':' type)* blockStatement
    ;

blockStatement
    : '{' statement* '}'
    ;

statement
    : expressionStatement
    | variableDeclaration
    | blockStatement
    ;

expressionStatement
    : expression ';'
    ;

typeParameters
    : typeParameter (',' typeParameter)*
    ;

typeParameter
    : ID ':' type
    ;

//type
//    : ID ('.' ID)*
//    ;
type
    : ID ('.' ID)*
    ;

variableDeclaration
    : 'var' ID ':' type ('=' expression)? ';'
//    | 'var' ID '=' expression ';'
    ;


expression
    : expression '(' expressionList* ')'
    | expression '.' ID
    | <asscos=right> ('-' | '!') expression
    | expression op=('*' | '/' | '%') expression
    | expression op=('+' | '-') expression
    | expression op=('>' | '<' | '>=' | '<=') expression
    | expression op=('==' | '!=') expression
    | expression op='=' expression
    | literal
    | ID
    ;

expressionList
    : expression (',' expression)*
    ;

literal
    : BOOL_LITERAL
    | INT_LITERAL
    | DOUBLE_LITERAL
    | STRING_LITERAL
    | NULL_LITERAL
    ;

// Keywords
INT: 'int';
FLOAT: 'float';
DOUBLE: 'double';
LONG: 'long';
STRING : 'string';
PACKAGE: 'package';
IMPORT: 'import';
CLASS: 'class';
INTERFACE: 'interface';
FUN: 'fun';
OBJECT: 'object';
VAL: 'val';
VAR: 'var';
CONSTRUCTOR: 'constructor';
THIS: 'this';
SUPER: 'super';
IF: 'if';
ELSE: 'else';
MATCH: 'match';
TRY: 'try';
CATCH: 'catch';
FINALLY: 'finally';
THROW: 'throw';
FOR: 'for';
WHILE: 'while';
RETURN: 'return';
CONTINUE: 'continue';
BREAK: 'break';

INT_LITERAL : '-'? INTEGER
    ;

fragment INTEGER
    : '0' | [1-9] [0-9]*
    ;

DOUBLE_LITERAL
    : INT_LITERAL '.' [0-9]+
    ;

BOOL_LITERAL : 'true' | 'false'
    ;

NULL_LITERAL : 'null'
    ;

STRING_LITERAL
    : '"' (ESC | ~["\\])* '"'
    ;

CLASS_ID
    : [A-Z](LETTER | [0-9])*
    ;

ID
    : LETTER (LETTER | [0-9])*
    ;

fragment LETTER
    : [a-zA-Z]
    ;

fragment ESC
    : '\\' (["\\/bfnrt] | UNICODE)
    ;

fragment UNICODE
    : 'u' HEX HEX HEX HEX
    ;

fragment HEX
    : [0-9a-fA-F]
    ;

WS  : [ \t\r\n]+ -> skip;

SINGLE_LINE_COMMENT
    : '//' ~[\r\n]* -> skip
    ;

MULTI_LINE_COMMENT
    : '/*' .*? '*/' -> skip
    ;