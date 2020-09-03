from math import sqrt

pm = [2, 3, 5, 7]

def isPrime(s):
    for i in pm:
        if i > sqrt(s): 
            return True
        if s % i == 0:
            return False
    return True

x = 600851475143
for i in range(8, int(1e6), 1):
    if isPrime(i):
        pm.append(i)
for i in reversed(pm):
    while x % i == 0:
        print(i)
        x /= i
print(x)