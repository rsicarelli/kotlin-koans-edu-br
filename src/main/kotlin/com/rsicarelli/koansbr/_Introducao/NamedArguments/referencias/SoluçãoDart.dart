String joinOptions(List<String> options) {
  return '[' + options.join(', ') + ']';
}

void main() {
  print(joinOptions([
    'Option 1',
    'Option 2',
    'Option 3'
  ])); // Outputs: [Option 1, Option 2, Option 3]
}
