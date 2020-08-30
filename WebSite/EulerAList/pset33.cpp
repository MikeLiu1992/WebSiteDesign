#include <iostream>   
#include <algorithm>    
#include <cmath>
#include <string>
#include <vector>
#include <unordered_set>

using namespace std;
unordered_set<int> res;

int main () 
{
    // There can only be 4 types:
    // xa / xb  = a / b, ax / bx = a/ b, xa / bx = a/ b and ax / xb = a / b
    // First and second type can deduce to: a = b which is wrong
    // Third one gives: x = 9ab/(10a - b)
    // Forth one gives: x = 9ab/(10b - a)
    // Also since it is smaller than 1 we need a < b
    int x;
    for (int a = 1; a < 9; a ++)
    {
        for (int b = a + 1; b <= 9; b ++)
        {
            if ((9 * a * b) % (10 * a - b) == 0)
            {
                x = (9 * a * b) / (10 * a - b);
                if (x >= 10) continue;
                cout << a << x << "/" << x << b << endl;
            }
            
            if ((9 * a * b) % (10 * b - a) == 0)
            {
                x = (9 * a * b) / (10 * a - b);
                if (x >= 10) continue;
                cout << x << a << "/" << b << x << endl;
            }
        }
    }
}
