# strict-lox

StrictLox is restricted for lox programming language. It uses jvm as backend.

> The compiler is a work in progress.

## Types

Primitive types: `int`, `long`, `float`, `double`, `string`.
Reference types: `class`, `array`, `null`.

Unlike lox, function is allowed to declare in global environment or class.
Function or method can't be used as a return value. Also, closure is not supported. 

## Usage

```shell script
mvn install && mvn package
cd compiler
java -jar ./target/compiler-1.0-SNAPSHOT-shaded.jar ./test.lox
```

