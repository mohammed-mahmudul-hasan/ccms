# To run this code, type 'python dsl_converter.py book_stall.dsl' into the terminal.

import sys


functions = {'sold': lambda x, y: x + y,
             'returned': lambda x, y: x - y,
             }

variables = {}

if len(sys.argv) != 2:
    sys.exit(1)

with open(sys.argv[1]) as file: #open dsl file and read each line
    
    #starting sold items are 0
    item = {"books": 0,
               "diaries": 0,
               }

    for line in file:
        line = line.strip()

        # check the comment lines
        if not line or line[0] == '/':
            continue
        p = line.split()

        if p[0] == 'How':
            print("\n"+"There are " + str(item[p[2]]) + " " + p[2] + " sold in a week from the book stall"+"\n")
            
        else:
            x = item[p[1]]
            y = int(p[0])

            item[p[1]] = functions[p[3]](x, y)

# Display the number of sold books (deducting the returned books) in a week
# Display number of diaries sold in a week