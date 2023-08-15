from typing import List

def contains_even(collection: List[int]) -> bool:
    return any(item % 2 == 0 for item in collection)
