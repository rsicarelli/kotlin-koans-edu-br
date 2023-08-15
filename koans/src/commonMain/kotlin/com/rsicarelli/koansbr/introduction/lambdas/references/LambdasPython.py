#  SPDX-License-Identifier: MIT
#  Copyright (c) 2014-2019 JetBrains s.r.o.
#  Copyright (c) 2023-2023 Rodrigo Sicarelli
#
#
#
#
#
#
#
#

from typing import List

def contains_even(collection: List[int]) -> bool:
    return any(item % 2 == 0 for item in collection)
