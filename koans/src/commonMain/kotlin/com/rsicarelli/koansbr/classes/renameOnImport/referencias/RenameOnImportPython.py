#  SPDX-License-Identifier: MIT
#  Copyright (c) 2023-2023 Rodrigo Sicarelli
#

# noinspection PyUnresolvedReferences
from JavaRandom import JavaRandom as JRandom
# noinspection PyUnresolvedReferences
from KotlinRandom import KotlinRandom as KRandom


def use_different_random_classes():
    return f"Kotlin random: {KRandom().next_int(2)} Java random: {JRandom().next_int(2)}."


# noinspection PyShadowingBuiltins
def print(param):
    pass


print(use_different_random_classes())
