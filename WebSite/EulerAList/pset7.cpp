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

int main () 
{
    long i = 8;
    while (pm.size() < 10001)
    {
        if (isPrime(i))
        {
            primeList.insert(i);
            pm.push_back(i);
        }
        i ++;
    }
    cout << pm.back() << endl;
}