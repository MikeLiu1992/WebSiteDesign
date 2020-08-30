#include <iostream>     // std::cout
#include <algorithm>    // std::next_permutation, std::sort
#include <cmath>
#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

unordered_set<long> primeList{2, 3, 5, 7};
vector<long> pm{2, 3, 5, 7};
string evenList = "02468";
vector<long> allList{2};

bool isPrime(long s)
{
    for (long i : pm)
    {
        if (i > sqrt(s)) return true;
        if (s % i == 0) return false;
    }
    return true;
}

long rotate(long s)
{
    long powTen = pow(10, (int)log10(s));
    int rem = s % 10;
    s = rem * powTen + s / 10;
    return s;
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
    for (long i : pm)
    {
        string num = to_string(i);
        sort(num.begin(), num.end());
        bool isPossible = true;
        for (char c : evenList)
        {
            if (num.find(c) != string::npos)
            {
                isPossible = false;
                break;
            }
        }
        if (isPossible == false) continue;
        bool isCircular = true;
        long value = i;
        do 
        {
            value = rotate(value);
            if (primeList.find(value) == primeList.end())
            {
                isCircular = false;
                break;
            }

        } while (value != i);   
        if (isCircular || i == 2)
        {
            allList.push_back(i);
        }
    }
    for (int i : allList)
    {
        cout << i << ";";
    }
    cout << endl << allList.size() << endl;
}