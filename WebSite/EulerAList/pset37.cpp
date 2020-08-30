#include <iostream>     // std::cout
#include <algorithm>    // std::next_permutation, std::sort
#include <cmath>
#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

unordered_set<long> primeList{2, 3, 5, 7};
vector<long> pm{2, 3, 5, 7};

bool isPrime(long s)
{
    for (long i : pm)
    {
        if (i > sqrt(s)) return true;
        if (s % i == 0) return false;
    }
    return true;
}
bool isTruncatable(long x)
{
    long tmp = x;
    int divider = 10;
    while (tmp > divider)
    {
        long x1 = tmp % divider;
        long x2 = tmp / divider;
        if (primeList.find(x1) == primeList.end() || primeList.find(x2) == primeList.end())
        {
            return false;
        }
        divider *= 10;
    }
    return true;
}
int main () 
{
    for (long i = 8; i < 1e6; i ++)
    {
        if (isPrime(i))
        {
            primeList.insert(i);
            pm.push_back(i);
        }
    }
    vector<long> res;
    int counter = 0;
    long i = 6;
    while (counter < 11)
    {
        long val = pm[i];
        long t = pm[i];
        i ++;
        if (isTruncatable(val))
        {
            counter ++;
            res.push_back(val);
        }
    }
    long result = 0;
    for (int i = 0; i < 11; i ++)
    {
        cout << res[i] << ";";
        result += res[i];
    }
    cout << endl << result << endl;
}