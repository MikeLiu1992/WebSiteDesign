primeList = [2, 3, 5, 7, 11]

def findDivisor(value):
    result = 1
    for i in primeList:
        if value < i or value <= 1: 
            break
        cnt = 0
        while value % i == 0 and value > 1:
            value /= i
            cnt += 1
        result *= cnt + 1
    if value > 1:
        primeList.append(value)
    if result == 1:
        return 2
    else:
        return result
   
result = 0
N = 1
while findDivisor(N * (N + 1) / 2) <= 500:
    N += 1
print(N * (N + 1) / 2)
