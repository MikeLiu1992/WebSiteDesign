Pent = set()
PentList = [1] * 1000000

Pent.add(1)
for i in range(1, 1000000):
    PentList[i] = PentList[i - 1]  + i * 3 + 1
    Pent.add(PentList[i])

valueFound = False
for di in range(1000000):
    for si in range(di + 1, 1000000):
        if (PentList[di] + PentList[si]) % 2 != 0:
            continue
        elif PentList[si] > 6 * PentList[di] + 2:
            break
        else:
            X1 = (PentList[si] + PentList[di]) // 2
            X2 = (PentList[si] - PentList[di]) // 2
            if X1 in Pent and X2 in Pent:
                print(str(X1) + "," + str(X2) + "," + str(PentList[si]) + "," + str(PentList[di]))
                valueFound = True
                break
    if valueFound:
        break

