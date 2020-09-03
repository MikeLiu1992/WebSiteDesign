res = set()

result = 0
valueList = [0] * 10000000
valueList[0] = 1
valueList[1] = 1
for i in range(2, 10):
    valueList[i] = valueList[i - 1] * i

for i in range(1, 7):
    start = pow(10, i)
    end = pow(10, i + 1)
    for j in range(start, end):
        valueList[j] = valueList[j // start] + valueList[j % start] + i - len(str(j % start))
        if valueList[j] == j:
            print(j)
            result += j

print(result)
