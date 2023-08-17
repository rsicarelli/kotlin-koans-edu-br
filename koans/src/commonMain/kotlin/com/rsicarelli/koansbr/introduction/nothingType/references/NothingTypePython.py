#  SPDX-License-Identifier: MIT
#  Copyright (c) 2023-2023 Rodrigo Sicarelli
#
#
#
#
#
#
#
#

def main():
    try:
        check_age(10)
    except Exception as e:
        print(e)


def fail_with_wrong_age(age):
    raise ValueError(f"Wrong age: {age}")


def check_age(age):
    if age is None or age < 0 or age > 150:
        fail_with_wrong_age(age)
    print(f"Congrats! Next year you'll be {age + 1}.")


main()
