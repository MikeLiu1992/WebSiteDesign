from math import sqrt

pm = [2, 3, 5, 7]
primeList = set(pm)

def isPrime(s):
    for i in pm:
        if i > sqrt(s):
            return True
        if s % i == 0:
            return False
    return True

def quadLength(a, b):
    n = 0
    while int(n * n + a * n + b) in primeList:
        n += 1
    return n


for i in range(8, int(2e6)):
    if isPrime(i):
        primeList.add(i)
        pm.append(i)
result = 0
maxLen = 0
for b in pm:
    if b > 1000: 
        break
    for a in range(-999, 1000):
        l = quadLength(a, b)
        if maxLen < l:
            maxLen = l
            result = a * b
print(result)