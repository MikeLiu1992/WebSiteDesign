from math import sqrt, log

##using Fibonacci explicit form, first term dominant with big value therefore:
N1 = (1 + sqrt(5)) / 2
print("Upper Bound:")  
print((999 * log(10) + log(10 * sqrt(5))) / log(N1))

print("Lower Bound:") 
print((999 * log(10) + log(sqrt(5))) / log(N1))