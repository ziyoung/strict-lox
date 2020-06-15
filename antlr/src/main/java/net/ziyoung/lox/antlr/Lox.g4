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
    :  ID ':' type ('=' expression)? ';'
    ;

functionDeclaration
    : 'fun' functionPart
    ;

methodDeclaration
    : modifier? functionPart
    ;

functionPart
    : ID '(' typeParameters? ')' (':' type)? blockStatement
    ;

modifier
    : 'static'
    ;

typeParameters
    : typeParameter (',' typeParameter)*
    ;

typeParameter
    : ID ':' type
    ;

type
    : ID ('.' ID)*
    ;

blockStatement
    : '{' statement* '}'
    ;

statement
    : expressionStatement
    | variableDeclaration
    | ifStatement
    | forStatement
    | blockStatement
    | returnStatement
    ;

expressionStatement
    : expression ';'
    ;

ifStatement
    : 'if' '(' expression ')' blockStatement elseBranch?
    ;

elseBranch
    : 'else' (ifStatement | blockStatement)
    ;

forStatement
    : 'for' '(' initPart conditionPart updatePart ')' blockStatement
    ;

initPart
    : variableDeclaration
    | expressionStatement
    | ';'
    ;

conditionPart
    : expression? ';'
    ;

updatePart
    : expression? ';'
    ;

returnStatement
    : 'return' expression? ';'
    ;

variableDeclaration
    : 'var' ID ':' type ('=' expression)? ';'
    ;


expression
    : expression '(' expressionList* ')'                    # Call
    | expression '.' ID                                     # Member
    | '(' expression ')'                                    # Group
    | <asscos=right> ('-' | '!') expression                 # Unary
    | expression op=('*' | '/' | '%') expression            # Binary
    | expression op=('+' | '-') expression                  # Binary
    | expression op=('>' | '<' | '>=' | '<=') expression    # Binary
    | expression op=('==' | '!=') expression                # Binary
    | expression op=('||' | '&&') expression                # Binary
    | expression '=' expression                             # Assign
    | literal                                               # Liter
    | ID                                                    # Ident
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
STATIC: 'static';
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