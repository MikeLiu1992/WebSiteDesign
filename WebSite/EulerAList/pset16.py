value = "1"
for i in range(1000):
    adder = 0
    tmp = ""
    for j in range(len(value) - 1, -1, -1):
        x = int(value[j])
        x = x * 2 + adder
        tmp = str(x % 10) + tmp
        adder = x // 10
    value = tmp
    value = str(adder) + value
res = 0
for i in value:
    res += int(i)
print(res)