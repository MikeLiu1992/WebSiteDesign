value = [[] for x in range(11)]
for i in range(2, 11):
    tmp = i
    cnt = 1
    while tmp <= 100:
        value[i].append(cnt)
        cnt += 1
        tmp *= i
result = 0
calculatedValue = 0
non_distinctSize = [0] * 7
usedList = set()
for i in range(1, 7):
    for k in range(2 * 1, 100 * i + 1, i):
        if not k in usedList:
            usedList.add(k)
    non_distinctSize[i] = len(usedList)
for i in range(2, 11):
    if i == 4 or i == 8 or i == 9: 
        continue
    calculatedValue += len(value[i])
    result += non_distinctSize[value[i][-1]]
result += 99 * (99 - calculatedValue)
print(result - 1)