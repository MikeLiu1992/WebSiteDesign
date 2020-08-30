#include <iostream>     
#include <algorithm>    
#include <cmath>
#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

bool isParlindrom(long x)
{
    string s = to_string(x);
    string k = s;
    reverse(k.begin(), k.end());
    return k == s;
}

int main()
{
    // Largest one has to be 9xx times 9xx
    long result = 0;
    for (int i = 900; i < 1000; i ++)
    {
        for (int j = i; j < 1000; j ++)
        {
            long tmp = i * j;
            if (isParlindrom(tmp))
            {
                result = max(result, tmp);
            }
        }
    }
    cout << result << endl;
}