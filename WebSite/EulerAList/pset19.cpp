#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> monthValue = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

int main()
{
    int year = 1900, month = 1, day = 1, weekday = 1;
    int cnt = 0;
    while (year < 2001)
    {
        bool leapYear = false;
        if (year % 4 == 0) leapYear = true;
        if (year % 100 == 0) leapYear = false;
        if (year % 400 == 0) leapYear = true;
        if (leapYear) 
            monthValue[2] = 29;
        else
            monthValue[2] = 28;
        if (weekday == 7 && day == 1 && year >= 1901) cnt ++;
        if (weekday == 7) {
            weekday = 1;}
        else
            weekday ++;
        if (day == monthValue[month])
        {
            day = 1;
            month ++;
        }
        else
        {
            day ++;
        }
        if (month > 12)
        {
            year ++;
            month = 1;
        }
    }
    cout << cnt << endl;
}