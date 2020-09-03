path = {}

def findPath(x):
    if x == 1:
        return 0
    if x in path.keys():
        return path[x]
    usedValue = []
    while not x in path.keys():
        usedValue.append(x)
        if x % 2:
            x = 3 * x + 1
        else:
            x /= 2
    terminalValue = path[x]
    for i in range(len(usedValue) - 1, 0, -1):
        terminalValue += 1
        path[usedValue[i]] = terminalValue 
    return terminalValue

result = 1
maxPath = 1
path[1] = 0
for i in range(2, 1000000, 1):
    x = findPath(i)
    if maxPath < x:
        maxPath = x
        result = i
print(result)
