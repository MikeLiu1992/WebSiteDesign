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
    long result = 0;
    int myints[] = {1,2,3,4,5,6,7,8,9};
    do 
    {
        long currValue = 0;
        for (int i = 0; i < 9; i ++)
        {
            currValue += myints[i] * pow(10, 8 - i);
        }
        for (int first = 0; first <= 4; first ++)
        {
            long x1 = currValue / (int)pow(10, 8 - first);
            long residual = currValue % (int)pow(10, 8 - first);
            for (int second = first + 1; second <= 5; second ++)
            {
                long x2 = residual / (int)pow(10, 8 - second);
                long y = residual % (int)pow(10, 8 - second);
                if (x1 * x2 == y)
                {
                    cout << x1 << "*" << x2 << "=" << y << endl;
                    res.insert(y);
                }
            }
        }


    } while (next_permutation(myints,myints+9));
    for (int i : res)
    {
        result += i;
    }
    cout << result << endl;
    return 0;
}
