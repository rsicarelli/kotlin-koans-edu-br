String foo(String name, [int number = 42, bool toUpperCase = false]) {
  return (toUpperCase ? name.toUpperCase() : name) + number.toString();
}

List<String> useFoo() {
  return [
    foo("a"),
    foo("b", 1),
    foo("c", 42, true),
    foo("d", 2, true)
  ];
}

void main() {
  print(useFoo());
}
