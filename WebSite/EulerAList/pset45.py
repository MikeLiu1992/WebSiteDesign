Tri = set()
TriList = [1] * 1000000
Pent = set()
PentList = [1] * 1000000
Hex = set()
HexList = [1] * 1000000

Tri.add(1)
Pent.add(1)
Hex.add(1)
for i in range(1, 1000000):
    TriList[i] = TriList[i - 1] + i + 1
    PentList[i] = PentList[i - 1]  + i * 3 + 1
    HexList[i] = HexList[i - 1] + i * 4 + 1
    Tri.add(TriList[i])
    Pent.add(PentList[i])
    Hex.add(HexList[i])

for i in range(144, 1000000):
    if HexList[i] in Pent and HexList[i] in Tri:
        print(HexList[i])
        break 


