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
month = '(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)'


def main():
    print(get_pattern(month))


def get_pattern(local_month):
    return rf'\d{{2}} {local_month} \d{{4}}'


main()
