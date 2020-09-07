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


for i in range(8, int(2e6)):
    if isPrime(i):
        primeList.add(i)
        pm.append(i)
    isConjecture = False
    if i % 2 == 1:
        for j in pm:
            if j == 2:
                continue
            residual = (i - j) // 2
            val = int(sqrt(residual))
            if val * val == residual:
                isConjecture = True
                break
    if not isConjecture and i % 2 == 1:
        print(i)
        break
