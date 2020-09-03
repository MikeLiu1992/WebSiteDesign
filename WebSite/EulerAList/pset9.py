## Since a + b + c = 1000 and a^2 + b^2 = c^2 therefore:
## (1000 - a)(c + a) = 500 * 1000
## so the two number has to perfect divisor of 500 * 1000
## 1000 > (c + a) > 500 and 500 < (1000 - a) < 1000
divisors = []
for i in range(6):
    for j in range(7):
        x = pow(2, i) * pow(5,j)
        y = 1000 * 500 / x
        if x > 500 and x < 1000 and y > 500 and y < 1000:
            print((1000 - x) * (y + x - 1000) * (1000 - y))