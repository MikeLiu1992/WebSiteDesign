from math import sqrt, log10

pm = [2, 3, 5, 7]
primeList = set(pm)
evenList = "02468"
allList = [2]

def isPrime(s):
    for i in pm:
        if i > sqrt(s): 
            return True
        if s % i == 0:
            return False
    return True

def rotate(s):
    powTen = int(pow(10, int(log10(s))))
    rem = s % 10
    s = int(rem * powTen + s // 10)
    return s

for i in range(8, int(1e6)):
    if isPrime(i):
        primeList.add(i)
        pm.append(i)

for i in pm:
    num = str(i)
    num = sorted(num)
    isPossible = True
    for c in evenList:
        if c in num:
            isPossible = False
            break
    if not isPossible:
        continue
    isCircular = True
    value = i
    while True: 
        if not value in primeList:
            isCircular = False
            break
        value = rotate(value)
        if value == i:
            break   
    if isCircular or i == 2:
        allList.append(i)

for i in allList:
    print(i)
print(len(allList))