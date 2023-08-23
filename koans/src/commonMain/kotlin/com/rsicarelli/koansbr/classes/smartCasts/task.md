## Smart casts

Rewrite the following Java code using [smart casts](https://kotlinlang.org/docs/typecasts.html#smart-casts)
and the [when](https://kotlinlang.org/docs/control-flow.html#when-expression) expression:

```java
public int eval(Expr expr) {
    if (expr instanceof Num) {
        return ((Num) expr).getValue();
    }
    if (expr instanceof Sum) {
        Sum sum = (Sum) expr;
        return eval(sum.getLeft()) + eval(sum.getRight());
    }
    throw new IllegalArgumentException("Unknown expression");
}
```

---


## Índice de exercícios

1. [Classes de Dados (Data Classes)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/classes/dataClasses/README.md
   )

2. ➡️ **[Tipagem inteligente (Smart casts)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/classes/smartCasts/README.md
   )**

3. [Classes seladas (Sealed classes)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/classes/sealedClasses/README.md
   )

4. [Renomear ao importar (Rename on import)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/classes/renameOnImport/README.md
   )

5. [Funções de extensão (Extension functions)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/classes/extensionFunctions/README.md
   )
