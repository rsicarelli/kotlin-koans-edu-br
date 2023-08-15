function foo(name: string, number: number = 42, toUpperCase: boolean = false) {
    return (toUpperCase ? name.toUpperCase() : name) + number;
}

function useFoo() {
    return [
        foo("a"),
        foo("b", 1),
        foo("c", 42, true),
        foo("d", 2, true)
    ];
}
