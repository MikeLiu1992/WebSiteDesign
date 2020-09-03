decConstructor = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
binConstructor = ["0", "1"]

def constructString(kernel, res, length, constructor):
    if len(kernel) > length - 1:
        return
    else:
        for s in constructor:
            if s != "0":
                res.append(s + kernel + s)
            constructString(s + kernel + s, res, length, constructor)

decPalind = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
binPalind = ["0", "1"]
decValue = set()
finalResult = set()
for s in decConstructor:
    constructString(s, decPalind, 5, decConstructor)
for s in decConstructor:
    constructString("", decPalind, 6, decConstructor)
for s in decPalind:
    decValue.add(int(s))
for s in binConstructor:
    constructString(s, binPalind, 19, binConstructor)
for s in binConstructor:
    constructString("", binPalind, 20, binConstructor)
result = 0
for s in binPalind: 
    val = int(s, 2)
    if val in decValue:
        finalResult.add(val)
for x in finalResult:
    result += x
print(result)