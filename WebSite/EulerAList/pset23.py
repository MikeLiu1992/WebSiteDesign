primeList = [2, 3, 5, 7, 11]
abundantNumberList = set()
d = [0] * 28123

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
N = 28123
for i in range(3, N + 1):
    if findDivisorSum(i) > i:
        abundantNumberList.add(i)
totalList = list(abundantNumberList)
totalList = sorted(totalList)
for i in range(2, N + 1):
    for j in totalList:
        if j > i // 2 + 1:
            break
        if i - j in abundantNumberList:
            result += i
            break
print((1 + N) * N / 2 - result)