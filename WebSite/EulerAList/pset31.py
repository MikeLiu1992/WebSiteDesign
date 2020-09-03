currrency = [1, 2, 5, 10, 20, 50, 100, 200]

def helper(currValue, currCoin):
    if currValue == 0:
        return 1
    if currCoin == 8 or currValue < 0:
        return 0
    ways = 0
    for i in range(currValue // currrency[currCoin] + 1):
        ways += helper(currValue - i * currrency[currCoin], currCoin + 1)
    return ways

print(helper(200, 0))
