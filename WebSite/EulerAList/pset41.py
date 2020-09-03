from math import sqrt
from itertools import permutations

pm = [2, 3, 5, 7]
primeList = set(pm)

def isPrime(s):
    for i in pm:
        if i > sqrt(s):
            return True
        if s % i == 0:
            return False
    return True

numList = "1234567"
result = 0
for i in range(8, int(1e5)):
    if isPrime(i):
        primeList.add(i)
        pm.append(i)
##Maximum is 7 digit
for i in range(7, 0, -1):
    val = numList[0:i]
    for j in permutations(val): 
        value = int(''.join(j))
        if value > result:
            if isPrime(value):
                result = value
            
    if result != 0:
        break
print(result)