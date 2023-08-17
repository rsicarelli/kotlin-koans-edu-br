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
# Python não suporta named argument.

# noinspection PyShadowingNames
def join_options(options):
    return ', '.join(options)


options = ['Option 1', 'Option 2', 'Option 3']
result = join_options(options)
print(result)
