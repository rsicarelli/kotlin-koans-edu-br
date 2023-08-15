from JavaRandom import JavaRandom as JRandom
from KotlinRandom import KotlinRandom as KRandom


def use_different_random_classes():
    return f"Kotlin random: {KRandom().next_int(2)} Java random: {JRandom().next_int(2)}."


def print(param):
    pass


print(use_different_random_classes())
