from math import sqrt
triangleList = []
counter = [0] * 1001

'''
// We know that the max lengh of the triangle is 500 
// Now we will assume a, b, c a is the max length. So a ^ 2 - b ^ 2 has to be a integer power.
// We also know smallest list is 3, 4, 5 so a end with 5
'''
for a in range(500, 4, -1):
    for b in range(a - 1, 0, -1):
        c = int(sqrt(a * a - b * b))
        if c * c + b * b == a * a and b >= c and a + b + c <= 1000:
            triangleList.append([a, b, c])
            counter[a + b + c] += 1
maxval = 0
res = 0
for i in range(1001):
    if counter[i] > maxval:
        maxval = counter[i]
        res = i
print(res)
