single_digits = ["zero", "one", "two", "three", "four","five", "six", "seven", "eight", "nine"]
two_digits = ["ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"]
tens_multiple = ["twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"]

def convert_to_words(num):
    if num == 1000:
        return "onethousand";
    if num < 10:
        return single_digits[num]
    if num < 20:
        return two_digits[num - 10]
    if num < 100:
        if num % 10 == 0:
            return tens_multiple[num // 10 - 2]
        else:
            return tens_multiple[num // 10 - 2] + convert_to_words(num % 10)
    if num % 100 == 0:
        return single_digits[num // 100] + "hundred"
    else:
        return single_digits[num // 100] + "hundredand" + convert_to_words(num % 100)
  
result = 0
for i in range(1, 1001):
    result += len(convert_to_words(i))
print(result)