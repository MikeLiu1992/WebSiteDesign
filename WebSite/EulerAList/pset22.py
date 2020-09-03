nameList = []
infile = open("p022_names.txt", "r")
s = infile.read()
s = s.strip('"')
s = '"' + s + '"'
nameList = s.split(',')
infile.close
nameList = sorted(nameList)
result = 0
for i in range(1, len(nameList) + 1):
    name = nameList[i - 1]
    sum = 0
    for c in name:
        if ord(c) >= ord('A'):
            sum += ord(c) - ord('A') + 1  
    result += sum * i
print(result)
