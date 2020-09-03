primeList = [2, 3, 5, 7, 11]
d = [0] * 10000

def findDivisorSum(value):
    tmp = value
    result = 1
    for i in primeList:
        if value < i or value <= 1: 
            break
        cnt = 0
        while value % i == 0 and value > 1:
            value /= i
            cnt += 1
        result *= int(pow(i,cnt + 1) - 1) // (i - 1)
    if value > 1:
        primeList.append(value)
        result *= value + 1
    result -= tmp
    return result

result = 0
for i in range(2, 10000):
    d[i] = findDivisorSum(i)
for a in range(2, 10000):
    if d[a] < 10000 and d[d[a]] == a and d[a] != a:
        result += a
print(result)