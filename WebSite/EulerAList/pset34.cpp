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
    vector<long> valueList(10000000, 0);
    valueList[0] = 1;
    valueList[1] = 1;
    for (int i = 2; i <= 9; i ++)
    {
        valueList[i] = valueList[i - 1] * i;
    }
    for (int i = 1; i < 7; i ++)
    {
        unsigned long long start = pow(10, i);
        unsigned long long end = pow(10, i + 1);
        for (unsigned long long j = start; j < end; j ++)
        {
            valueList[j] = valueList[j / start] + valueList[j % start] + i - to_string(j % start).size();
            if (valueList[j] == j)
            {
                cout << j << ";";
                result += j;
            }
        }
    }
    cout << endl << result << endl;
}
