def foo(name, number=42, to_upper_case=False):
    return (name.upper() if to_upper_case else name) + str(number)


def use_foo():
    return [
        foo("a"),
        foo("b", number=1),
        foo("c", to_upper_case=True),
        foo(name="d", number=2, to_upper_case=True)
    ]
