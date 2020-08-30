#include <iostream>     
#include <algorithm>    
#include <cmath>
#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

int main () 
{
    // Since a + b + c = 1000 and a^2 + b^2 = c^2 therefore:
    // (1000 - a)(c + a) = 500 * 1000
    // so the two number has to perfect divisor of 500 * 1000
    // 1000 > (c + a) > 500 and 500 < (1000 - a) < 1000
    vector<int> divisors;
    for (int i = 0; i <= 5; i ++)
    {
        for (int j = 0; j <= 6; j ++)
        {
            long x = pow(2, i) * pow(5,j);
            long y = 1000 * 500 / x;
            if (x > 500 && x < 1000 && y > 500 && y < 1000)
            {
                cout << (1000 - x) * (y + x - 1000) * (1000 - y)<< "\n";
            }
        }
    }

}