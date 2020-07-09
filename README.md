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
cp ./compiler/target/compiler-1.0-SNAPSHOT-shaded.jar ./exmaple

# compile
java -jar compiler-1.0-SNAPSHOT-shaded.jar Hello.lox

# run
java Hello
```

## TODO

- [x] Hello World
- [x] Arithmetic
- [ ] String Concat
- [ ] If Statement
- [ ] For Statement
- [ ] Return Statement
- [ ] Class & Custom Type
- [ ] Instance Method
- [ ] null
