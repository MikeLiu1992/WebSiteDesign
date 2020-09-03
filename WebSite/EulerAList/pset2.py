result = 0
x1 = 1
x2 = 2
while x2 <= 4e6:
    if x2 % 2 == 0:
        result += x2
    tmp = x2
    x2 += x1
    x1 = tmp
print(result)