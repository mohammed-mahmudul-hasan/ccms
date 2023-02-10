#Example 1
def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n-1)

print(factorial(6))
"""
Functional programming:
Output of the code is 720.
In this code, factorial is a pure function. It takes an integer n as an argument and returns its factorial.\\
The function uses recursion to calculate the factorial. This code demonstrates several key aspects of functional\\
programming, including the use of a pure function, recursion, and immutability (the input value n is not \\
modified within the function. It won't ever interfere with another function.This makes it a side-effect-free function).

"""
#Example 2
def square(x):
    return x*x

def sum_of_squares(n):
    return sum(map(square, range(1, n+1)))

print(sum_of_squares(6))
"""
Functional programming:
Output of the code is 91
The square function takes a number x and returns its square. The sum_of_squares function takes an integer n as an\\ argument and returns the sum of the squares of the first n positive numbers.
As functional programming, I've used higher-order functions (map and sum) here in this code.
"""
#Example 3
def task(func, x, y):
    return func(x, y)

def add(x, y):
    return x + y

result = task(add, 7, 9)
print(result) 
"""
Functional programming:
Output of the code is 16
In this code, a function that takes another function as a parameter and returns a value.
"""
#Example 4
def multiply(p):
    def inner_function(q):
        return p * q
    return inner_function

double = multiply(2)
triple = multiply(3)

result1 = double(7)
result2 = triple(8)
print(result1) 
print(result2)  
"""
Functional programming:
Output of the code is 14 & 24
In this code, the function named multiply takes a number (p) as a parameter and returns a closure, the\\ inner_function, which takes another number (q) as a parameter and returns the product of p and q. This code\\ demonstrates the use of closures in functional programming.
"""
#Example 5
from typing import List

def add_two(numbers: List[int]) -> List[int]:
    return list(map(lambda x: x + 2, numbers))

def even_num(numbers: List[int]) -> List[int]:
    return list(filter(lambda x: x % 2 == 0, numbers))

numbers = [3, 4, 5, 6, 7, 8, 9]
r = even_num(add_two(numbers))
print(r)
"""
Functional programming:
Output of the code is [6, 8, 10]
Firstly the even numbers are detected from the numbers list and final result is got adding 2 with each even \\ number. Using only final data structures and functional programming techniques, It can be determined that the\\ functions have no side effects and can be easily composed and reused in different combinations.
"""
