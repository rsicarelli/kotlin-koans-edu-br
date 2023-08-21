# Kotlin Koans BR 🇧🇷

Uma coleção de conteúdo baseada no renomado [Kotlin Koans](https://play.kotlinlang.org/koans/overview) para aprender Kotlin em português
🇧🇷, com conteúdo exclusivo e adaptações para 9 outras linguagens de programação.

## 🌌 Inspiração

O [Kotlin Koans original](https://github.com/Kotlin/kotlin-koans-edu) foi criado pela JetBrains e se tornou um método preferido por quem
conhece Java para iniciar no Kotlin. Esta versão em português traz conteúdo exclusivo e traduções para outras linguagens como: Swift, Dart,
JavaScript, TypeScript, Python, Go, entre outras.

## 🧩 Formato e utilização

Os exercícios são propostos como desafios que começam com um teste unitário falhando. Você pode explorar os exercícios de três formas:

1. 🥉**Pelo site [Kotlin Koans](https://play.kotlinlang.org/koans/overview)**: Ambiente online para quem é fluente em inglês.
2. 🥈**Usando
   o [Plugin para IntelliJ ou Android Studio](https://plugins.jetbrains.com/plugin/10081-jetbrains-academy/docs/learner-start-guide.html)**:
   Para quem prefere integração ao ambiente de desenvolvimento e tem facilidade com o inglês.
3. 🥇**Através deste projeto**: Conteúdo e exemplos em português, incluindo traduções em outras linguagens, analogias, casos de uso e boas
   práticas.

### 🗂️ Estrutura do Projeto

A estrutura deste repositório foi desenhada para oferecer uma experiência de aprendizado fluida, com uma organização lógica dos tópicos e
exemplos.

#### 📁 `koans/src/commonMain`

Aqui, os exercícios e soluções do Kotlin Koan estão organizados por módulos. Cada módulo tem seu próprio diretório, como `introduction`, que
hospeda tópicos introdutórios.

**Dentro de cada diretório de módulo:**

- `README.md`: Serve como um guia para o tópico, com sugestões e informações que enriquecem o aprendizado.

- `NomeDoTopicoKotlin.kt`: É a solução principal do Kotlin Koan. Embora seja tentador, tente resolver o Koan sem espiar a solução. Está aqui
  para ajudá-lo a compreender se estiver preso.

- `references/`: Este diretório é uma adição especial. Contém adaptações da solução principal para outras linguagens de programação,
  permitindo uma comparação lado a lado.

#### 📁 `koans/src/commonTest`

> 💡 Os testes em conjunto com a solução torna a experiência completa.

> ✅ No final de cada exercício, verifique o teste correspondente para máxima absorção.

Aqui estão os testes unitários que verificam as soluções dos Koans. Estes testes são escritos seguindo o
padrão [Gherkin](https://cucumber.io/docs/gherkin/), tornando-os compreensíveis mesmo para quem é novo em testes.

### 📂 Exemplo

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

## 🎬 Por onde começar?

🔗 [Introdução](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/README.md)

## 🌱 Como Contribuir

Se você tem dúvidas, sugestões ou quer ajudar com traduções e revisões:

- **Criando uma nova Issue**: [Abra uma nova issue](https://github.com/rsicarelli/kotlin-koans-edu-br/issues/new) e faça suas sugestões,
  ideias, solicitações ou dúvidas.
- **Contribuindo com as traduções de código**: em cada pasta, você encontrará soluções em várias linguagens. Ajude revisando, corrigindo,
  sugerindo ou contribuindo com novas linguagens.

## 📜 Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE.txt](LICENSE.txt) para detalhes.
