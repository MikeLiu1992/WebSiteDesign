res = set()
'''
// There can only be 4 types:
// xa / xb  = a / b, ax / bx = a/ b, xa / bx = a/ b and ax / xb = a / b
// First and second type can deduce to: a = b which is wrong
// Third one gives: x = 9ab/(10a - b)
// Forth one gives: x = 9ab/(10b - a)
// Also since it is smaller than 1 we need a < b
'''
x = 0
for a in range(1, 10):
    for b in range(a + 1, 10):
        if (9 * a * b) % (10 * a - b) == 0:
            x = (9 * a * b) / (10 * a - b)
            x = int(x)
            if x >= 10: 
                continue
            print(str(a) + str(x) + "/" + str(x) + str(b))
        
        if (9 * a * b) % (10 * b - a) == 0:
            x = (9 * a * b) / (10 * a - b)
            x = int(x)
            if x >= 10: 
                continue
            print(str(x) + str(a) + "/" + str(b) + str(x))