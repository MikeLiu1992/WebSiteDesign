d1 = 1
d10 = 1
res = [1, 10, 100, 1000, 10000, 100000, 1000000]
digitCounter = [0] * 7
digitCounter[0] = 1
digitCounter[1] = 9
for i in range(2, 7):
    digitCounter[i] = digitCounter[i - 1] + i * (res[i] - res[i - 1])
for i in range(1, 6):
    resid = (res[i + 1] - digitCounter[i]) * 1.0 / (i + 1) + res[i] - 1
    print("d" + str(int(pow(10, i + 1))) + ": " + str(resid))