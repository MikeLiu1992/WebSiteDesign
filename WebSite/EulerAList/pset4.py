def isParlindrom(x):
    s = str(x)
    k = s[::-1]
    return k == s

## Largest one has to be 9xx times 9xx
result = 0
for i in range(900, 1000, 1):
    for j in range(i, 1000, 1):
        tmp = i * j
        if isParlindrom(tmp):
            result = max(result, tmp)
print(result)