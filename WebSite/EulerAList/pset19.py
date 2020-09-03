monthValue = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
year = 1900
month = 1
day = 1
weekday = 1
cnt = 0
while year < 2001:
    leapYear = False
    if year % 4 == 0:
        leapYear = True
    if year % 100 == 0:
        leapYear = False
    if year % 400 == 0: 
        leapYear = True
    if leapYear:
        monthValue[2] = 29
    else:
        monthValue[2] = 28
    if weekday == 7 and day == 1 and year >= 1901:
        cnt += 1
    if weekday == 7: 
        weekday = 1
    else:
        weekday += 1
    if day == monthValue[month]:
        day = 1
        month += 1
    else:
        day += 1
    if month > 12:
        year += 1
        month = 1
print(cnt)