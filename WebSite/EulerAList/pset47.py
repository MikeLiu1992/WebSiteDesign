from math import sqrt

def primeCounter(number):
    i = 2
    a = set()
    while i < number**0.5 or number == 1:
        if number % i == 0:
            number /= i
            a.add(i)
            i -= 1
        i += 1
    return (len(a)+1)

j = 2*3*5*7

while True:
    if primeCounter(j) == 4:
        j += 1
        if primeCounter(j) == 4:
            j += 1
            if primeCounter(j) == 4:
                j += 1
                if primeCounter(j) == 4:
                    print(j-3)
                    break
    j += 1



