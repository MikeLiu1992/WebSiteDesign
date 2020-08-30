#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>
#include <cmath>
#include <unordered_map>
using namespace std;

vector<int> primeList{2, 3, 5, 7, 11};
vector<long> d(10000, 0);

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
    for (int i = 2; i < 10000; i ++)
    {
        d[i] = findDivisorSum(i);
    }
    for (int a = 2; a < 10000; a ++)
    {
        if (d[d[a]] == a && d[a] != a)
        {
            cout << a << ";";
            result += a;
        }
    }
    cout << endl;
    cout << result << endl;
    return 0;
}