void failWithWrongAge(int? age) {
  throw ArgumentError('Wrong age: $age');
}

void checkAge(int? age) {
  if (age == null || age < 0 || age > 150) failWithWrongAge(age);
  print("Congrats! Next year you'll be ${age! + 1}.");
}

void main() {
  checkAge(10); // Outputs: Congrats! Next year you'll be 11.
}
