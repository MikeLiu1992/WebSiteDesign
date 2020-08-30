#include <iostream>     // std::cout
#include <algorithm>    // std::next_permutation, std::sort
#include <cmath>
#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

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

int main () 
{
    long long x = 600851475143;
    for (long i = 8; i < 1e6; i ++)
    {
        if (isPrime(i))
        {
            pm.push_back(i);
        }
    }
    for (auto it = pm.rbegin(); it != pm.rend(); it ++)
    {
        while (x % (*it) == 0)
        {
            cout << *it << endl;
            x /= *it;
        }
    }
    cout << x << endl;
}