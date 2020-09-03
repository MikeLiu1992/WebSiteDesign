wordList = []
triangleList = set()
infile = open("p042_words.txt", "r")
s = infile.read()
s = s.strip('"')
s = '"' + s + '"'
nameList = s.split(',')
infile.close
for name in nameList:  
    sum = 0
    for c in name:
        if ord(c) >= ord('A') and ord(c) <= ord('Z'):
            sum += ord(c) - ord('A') + 1
    wordList.append(sum)

for i in range(1, 201):
    triangleList.add((i + 1) * i / 2)
result = 0
for word in wordList:
    if word in triangleList:
        result += 1
print(result)