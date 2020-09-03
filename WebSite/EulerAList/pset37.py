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

def isTruncatable(x):
    tmp = x
    divider = 10
    while tmp > divider:
        x1 = tmp % divider
        x2 = tmp // divider
        if not x1 in primeList or not x2 in primeList:
            return False
        divider *= 10
    return True

for i in range(8, int(1e6)):
    if isPrime(i):
        primeList.add(i)
        pm.append(i)
res = []
counter = 0
i = 6
while counter < 11:
    val = pm[i]
    t = pm[i]
    i += 1
    if isTruncatable(val):
        counter += 1
        res.append(val)
result = 0
for i in range(11):
    result += res[i]
print(result)
