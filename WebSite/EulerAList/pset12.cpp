#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>
#include <cmath>
using namespace std;

vector<long> primeList{2, 3, 5, 7, 11};

int findDivisor(long value)
{
    int result = 1;
    for (long i : primeList)
    {
        if (value < i || value <= 1) break;
        int cnt = 0;
        while (value % i == 0 && value > 1)
        {
            value /= i;
            cnt ++;
        }
        result *= cnt + 1;
    }
    if (value > 1)
    {
        primeList.push_back(value);
    }
    if (result == 1)
    {
        return 2;
    }
    else
    {
        return result;
    }
    
}

int main()
{   
    long result = 0;
    long N = 1;
    while (findDivisor(N * (N + 1) / 2) <= 500)
    {
        N ++;
    }
    cout << N * (N + 1) / 2 << endl;
    return 0;
}