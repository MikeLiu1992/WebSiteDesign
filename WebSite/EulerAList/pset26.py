def fractionToDecimal(denr):
    res = ""
    mp = dict() 
    rem = 1 
    while (rem!=0) and not rem in mp.keys(): 
        mp[rem] = len(res) 
        rem *= 10
        res_part = rem // denr 
        res = res + str(res_part) 
        rem = rem % denr
    if rem == 0:
        return ""
    else:
        return res[mp[rem]:-1]

result = 0
maxLen = 0
for i in range(2, 1000):
    if len(fractionToDecimal(i)) > maxLen:
        maxLen = len(fractionToDecimal(i))
        result = i
print(result)