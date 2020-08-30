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

int quadLength(int a, int b)
{
    int n = 0;
    while (primeList.find(n * n + a * n + b) != primeList.end())
    {
        n ++;
    }
    return n;
}

int main () 
{
    for (long i = 8; i < 2e6; i ++)
    {
        if (isPrime(i))
        {
            primeList.insert(i);
            pm.push_back(i);
        }
    }
    int result = 0;
    int maxLen = 0;
    for (int b : pm)
    {
        if (b > 1000) break;
        for (int a = -999; a < 1000; a ++)
        {
            int l = quadLength(a, b);
            if (maxLen < l)
            {
                maxLen = l;
                result = a * b;
            }
        }
    }
    cout << result << endl;
}