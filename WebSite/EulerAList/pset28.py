size = 1001
pm = [[0 for x in range(size)] for y in range(size)]

i = size // 2
j = size // 2
pm[i][j] = 1
dir = [[0, 1], [1, 0], [0, -1], [-1, 0]]
stepIndex = 0
priorStepIndex = 0
for step in range(size * size - 1):
    if pm[i + dir[stepIndex][0]][j + dir[stepIndex][1]] == 0:
        priorStepIndex = stepIndex
        pm[i + dir[stepIndex][0]][j + dir[stepIndex][1]] = pm[i][j] + 1
        i += dir[stepIndex][0]
        j += dir[stepIndex][1]
        stepIndex += 1
    else:
        stepIndex = priorStepIndex
        pm[i + dir[stepIndex][0]][j + dir[stepIndex][1]] = pm[i][j] + 1
        i += dir[stepIndex][0]
        j += dir[stepIndex][1]
        stepIndex += 1
    if stepIndex == 4:
        stepIndex = 0
result = 0
for i in range(size):
    result += pm[i][i]
for i in range(size):
    result += pm[i][size - i - 1]
result -= 1
print(result)