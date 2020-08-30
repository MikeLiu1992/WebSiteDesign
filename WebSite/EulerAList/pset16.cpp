#include <iostream>
#include <string>

using namespace std;

int main()
{
    string value = "1";
    for (int i = 0; i < 1000; i ++)
    {
        int adder = 0;
        for (long j = value.size() - 1; j >= 0; j --)
        {
            int x = value[j] - '0';
            x = x * 2 + adder;
            value[j] = (char)(x % 10 + '0');
            adder = x / 10;
        }
        value = to_string(adder) + value;
    }
    int res = 0;
    for (char i : value)
    {
        res += i - '0';
    }
    cout << res << endl;
}