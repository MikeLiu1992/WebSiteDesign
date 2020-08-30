#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>
#include <cmath>
#include <set>
using namespace std;

vector<int> primeList{2, 3, 5, 7, 11};
set<int> abundantNumberList;
vector<long> d(28123 , 0);

long findDivisorSum(int value)
{
    int tmp = value;
    long result = 1;
    for (int i : primeList)
    {
        if (value < i || value <= 1) break;
        int cnt = 0;
        while (value % i == 0 && value > 1)
        {
            value /= i;
            cnt ++;
        }
        result *= (long)(pow(i,cnt + 1) - 1) / (i - 1);
    }
    if (value > 1)
    {
        primeList.push_back(value);
        result *= value + 1;
    }
    result -= tmp;
    return result;
}

int main()
{   
    long result = 0;
    int N = 28123;
    for (int i = 3; i <= N; i ++)
    {
        if (findDivisorSum(i) > i)
        {
            abundantNumberList.insert(i);
        }
    }
    for (int i = 2; i <= N; i ++)
    {
        for (int j : abundantNumberList)
        {
            if (j > i / 2 + 1)
            {
                break;
            }
            if (abundantNumberList.find(i - j) != abundantNumberList.end())
            {
                result += i;
                break;
            }
        }
    }
    cout << (1 + N) * N / 2 - result << endl;
    return 0;
}