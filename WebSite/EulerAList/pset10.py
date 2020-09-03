from math import sqrt

pm = [2, 3, 5, 7]

def isPrime(s):
    for i in pm:
        if i > sqrt(s):
            return True
        if s % i == 0: 
            return False
    return True

result = 0
for i in range(8, int(2e6)):
    if isPrime(i):
        result += i
        pm.append(i)
print(result + 2 + 3 + 5 + 7)