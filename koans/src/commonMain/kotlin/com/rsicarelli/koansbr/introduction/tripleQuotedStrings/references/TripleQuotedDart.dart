/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

const String question = "life, the universe, and everything";
const int answer = 42;

const String tripleQuotedString = '''
#question = "$question"
#answer = $answer
'''.trim().replaceAll('#', '');
