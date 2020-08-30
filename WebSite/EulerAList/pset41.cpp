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
    string numList = "1234567";
    long result = 0;
    for (long i = 8; i < 1e5; i ++)
    {
        if (isPrime(i))
        {
            primeList.insert(i);
            pm.push_back(i);
        }
    }
    //Maximum is 7 digit
    for (int i = 7; i >= 1; i --)
    {
        string val = numList.substr(0, i);
        do 
        {
            long value = stol(val);
            if (value > result)
            {
                if (isPrime(value))
                {
                    result = value;
                }
            }
        } while ( next_permutation(val.begin(),val.end()));
        if (result != 0) break;
    }
    cout << result << endl;
}