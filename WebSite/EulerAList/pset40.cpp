#include <iostream>    
#include <algorithm>    
#include <cmath>
#include <string>
#include <vector>
#include <unordered_set>

using namespace std;


int main()
{
    long d1 = 1, d10 = 1;
    vector<long> res{1, 10, 100, 1000, 10000, 100000, 1000000};
    vector<long> digitCounter(7, 0);
    digitCounter[0] = 1;
    digitCounter[1] = 9;
    for (int i = 2; i < 7; i ++)
    {
        digitCounter[i] = digitCounter[i - 1] + i * (res[i] - res[i - 1]);
    }
    for (int i = 1; i < 6; i ++)
    {
        double resid = (res[i + 1] - digitCounter[i]) * 1.0 / (i + 1) + res[i] - 1;
        cout << "d" << (int)pow(10, i + 1) << ": " << resid << endl;
    }
}