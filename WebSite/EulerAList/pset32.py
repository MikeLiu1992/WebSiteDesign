from itertools import permutations

res = set()
result = 0
myints = [1,2,3,4,5,6,7,8,9]
for i in permutations(myints):
    currValue = 0
    for j in range(9):
        currValue += i[j] * pow(10, 8 - j)
    for first in range(5):
        x1 = currValue // int(pow(10, 8 - first))
        residual = currValue % int(pow(10, 8 - first))
        for second in range(first + 1, 6):
            x2 = residual // int(pow(10, 8 - second))
            y = residual % int(pow(10, 8 - second))
            if x1 * x2 == y:
                res.add(y)

for i in res:
    result += i
print(result)
