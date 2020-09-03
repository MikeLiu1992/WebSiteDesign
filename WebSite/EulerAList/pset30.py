'''
Some Preliminary analysis:
since 7 * 9 ^ 5 = 413343 < 1000000 so value has to be lower than 1000000
since it is sum so has to be higher than 10
since 3^5 > 100 so if 2 digit it can only be 0, 1, 2 and 2^5 = 32 so 2 can't be included so it can't be two digit
'''
result = [0] * 1000000
for i in range(10):
    result[i] = pow(i, 5)
for i in range(10, 100):
    result[i] = result[i % 10] + result[i // 10]
for i in range(100, 1000):
    result[i] = result[i % 100] + result[i // 100]
for i in range(1000, 10000):
    result[i] = result[i % 1000] + result[i // 1000]
for i in range(10000, 100000):
    result[i] = result[i % 10000] + result[i // 10000]
for i in range(100000, 1000000):
    result[i] = result[i % 100000] + result[i // 100000]
res = 0
for i in range(2, 1000000):
    if result[i] == i:
        print(i)
        res += i
print(res)