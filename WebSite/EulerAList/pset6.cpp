#include <iostream>     
#include <algorithm>    
#include <cmath>
#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

int main()
{
    long n = 100;
    long x1 = n * (n + 1) * (2 * n + 1) / 6;
    long x2 = (n * (n + 1) * n * (n  + 1)) / 4;
    cout << x2 - x1 << endl;
}