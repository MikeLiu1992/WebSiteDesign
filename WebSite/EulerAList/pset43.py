firsttwoList = [1400000000, 4100000000]
restList = [30952867, 60357289, 6357289]

result = 0

for i in firsttwoList:
    for j in restList:
        result += i + j

print(result)
