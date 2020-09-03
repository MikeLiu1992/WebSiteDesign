## We only need to find all the prime factor and their maximum power to construct the value
primeList = [2,3,5,7,11,13,17,19]
powerList = [4,2,1,1,1, 1, 1, 1]
result = 1
for i in range(8):
    result *= pow(primeList[i], powerList[i]);
print(result)