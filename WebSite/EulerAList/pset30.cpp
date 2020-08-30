#include <iostream>   
#include <algorithm>    
#include <cmath>
#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

int main () 
{
    //Some Preliminary analysis:
    //since 7 * 9 ^ 5 = 413343 < 1000000 so value has to be lower than 1000000
    //since it is sum so has to be higher than 10
    //since 3^5 > 100 so if 2 digit it can only be 0, 1, 2 and 2^5 = 32 so 2 can't be included so it can't be two digit
    vector<long> result(1000000, 0);
    for (int i = 0; i < 10; i ++)
    {
        result[i] = pow(i, 5);
    }
    for (int i = 10; i < 100; i ++)
    {
        result[i] = result[i % 10] + result[i / 10];
    } 
    for (int i = 100; i < 1000; i ++)
    {
        result[i] = result[i % 100] + result[i / 100];
    }
    for (int i = 1000; i < 10000; i ++)
    {
        result[i] = result[i % 1000] + result[i / 1000];
    }
    for (int i = 10000; i < 100000; i ++)
    {
        result[i] = result[i % 10000] + result[i / 10000];
    }
    for (int i = 100000; i < 1000000; i ++)
    {
        result[i] = result[i % 100000] + result[i / 100000];
    }
    long res = 0;
    for (int i = 2; i < 1000000; i ++)
    {
        if (result[i] == i)
        {
            cout << i << ";";
            res += i;
        }
    }
    cout << endl << res << endl;

}