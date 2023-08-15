def fail_with_wrong_age(age):
    raise ValueError("Wrong age: " + str(age))

def check_age(age):
    if age is None or age < 0 or age > 150:
        fail_with_wrong_age(age)
    else:
        print("Congrats! Next year you'll be " + str(age + 1))

check_age(10)
