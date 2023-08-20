# Kotlin Koans BR 🇧🇷

Uma coleção de conteúdo baseada no renomado [Kotlin Koans](https://play.kotlinlang.org/koans/overview): uma ferramenta interativa para
aprender Kotlin.

## 🌌 Inspiração

O [Kotlin Koans original](https://github.com/Kotlin/kotlin-koans-edu) é uma sequência de exercícios criados pela JetBrains.

Devido à sua eficácia, o Kotlin Koans se tornou um dos métodos preferidos por quem já conhece Java para iniciar no mundo do Kotlin.

Este repositório apresenta uma adaptação do conteúdo em português 🇧🇷 com muito conteúdo exclusivo que auxilia no aprendizado. Além disso,
foram feitas adaptações para 9 outras linguagens de programação, incluindo:

- Swift, Dart, JavaScript, TypeScript, Python, Go, entre outras.

## 🧩 Formato

Cada exercício é proposto como um desafio: começando com um teste unitário falhando que precisa ser resolvido.

### 🛠️ Como utilizar

Existem três formas principais de explorar os exercícios:

- 🥉**Pelo site do [Kotlin Koans](https://play.kotlinlang.org/koans/overview)**: Ideal para quem gosta de ambientes online e tem facilidade
  com o inglês.
- 🥈**Usando
  o [Plugin para IntelliJ ou Android Studio](https://plugins.jetbrains.com/plugin/10081-jetbrains-academy/docs/learner-start-guide.html)**:
  Recomendado para quem prefere tudo integrado ao ambiente de desenvolvimento com familiaridade com o inglês.
- 🥇**Através deste projeto**, em conjunto com uma das anteriores. Com conteúdo e exemplos totalmente em português, cada solução conta com a
  tradução em outras linguagens como Swift, JavaScript e Dart, além de analogias, casos de uso, boas práticas, etc.

### 🧱Estrutura

```
koans/
├── commonMain/
│   ├── introduction/
│   │   ├── helloWorld/
│   │   │   ├── references/
│   │   │   │   ├── HelloWorldJava.java
│   │   │   │   ├── HelloWorldC#.cs
│   │   │   │   ├── HelloWorldDart.dart
│   │   │   │   ├── HelloWorldGo.go
│   │   │   │   ├── HelloWorldJavaScript.js
│   │   │   │   ├── HelloWorldPHP.php
│   │   │   │   ├── HelloWorldPython.py
│   │   │   │   ├── HelloWorldSwift.swift
│   │   │   │   └── HelloWorldTypeScript.ts
│   │   │   ├── HelloWorldKotlin.kt
│   │   │   └── README.md
│   │   ├── namedArguments/
│   │   │   ├── references/
│   │   │   │   ├── NamedArgumentsSwift.swift
│   │   │   │   └── ...            
│   │   │   ├── NamedArgumentsKotlin.kt
│   │   │   └── README.md
│   │   └── ...    
│   ├── classes
│   └── ...         
└── commonTest/
    ├── introduction/
    │   ├── HelloWorldTests.kt
    │   └── ...
    └── ...
```

## 🚀 Por onde começar?

🔗 [Introdução](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/README.md)

---

## 🌱 Como contribuir

### Criando uma nova Issue

🔗 [Abra uma nova issue](https://github.com/rsicarelli/kotlin-koans-edu-br/issues/new) caso você tenha:

- Alguma dúvida sobre o conteúdo, aplicação, exemplos
- Ideias de como melhorar o conteúdo
- Sugestões de outros formatos, exemplos diferentes
- Sugestões do que adicionar em cada conteúdo
- Algum problema no seu ambiente ou na configuração do projeto

> 💡 **Utilize a busca** antes de abrir uma issue, veja se sua dúvida já foi abordada.

### 🤝 Contribuindo com as traduções de código

Em cada pasta, você encontrará soluções adaptadas para várias linguagens como: Java, C#, Go, JavaScript, PHP, Dart, Python, Swift e
TypeScript. As soluções se adaptaram com base em um conhecimento limitado destas linguagens.

**Como você pode ajudar**:

- **Revisar as implementações**: Se tem conhecimento em alguma destas linguagens, sua revisão será valiosa.
- **Corrigir erros**: Se encontrar erros na tradução ou lógica, informe ou corrija.
- **Sugestões**: Sugira formas mais claras ou eficientes de apresentar soluções.
- **Novas linguagens**: Contribua com soluções em linguagens ainda não abordadas.

## 📜 Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE.txt](LICENSE.txt) para detalhes.
