from math import sqrt
pm = [2, 3, 5, 7]

def isPrime(s):
    for i in pm:
        if i > sqrt(s):
            return True
        if s % i == 0: 
            return False
    return True

i = 8
while len(pm) < 10001:
    if isPrime(i):
        pm.append(i)
    i += 1
print(i-1)