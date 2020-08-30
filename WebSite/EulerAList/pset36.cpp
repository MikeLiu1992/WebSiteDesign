#include <iostream>     // std::cout
#include <algorithm>    // std::next_permutation, std::sort
#include <cmath>
#include <string>
#include <vector>
#include <unordered_set>
#include <iterator>

using namespace std;

vector<string> decConstructor{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
vector<string> binConstructor{"0", "1"};

void constructString(string kernel, vector<string>& res, int length, vector<string> constructor)
{
    if (kernel.size() > length - 1)
    {
        return;
    }
    else
    {
        for (string s: constructor)
        {
            if (s != "0")
                res.push_back(s + kernel + s);
            constructString(s + kernel + s, res, length, constructor);
        }
    }
}

int main () 
{
    vector<string> decPalind{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    vector<string> binPalind{"0", "1"};
    unordered_set<long> decValue, finalResult;
    for (string s: decConstructor)
    {
        constructString(s, decPalind, 5, decConstructor);
    }
    for (string s: decConstructor)
    {
        constructString("", decPalind, 6, decConstructor);
    }
    for (string s: decPalind)
    {
        decValue.insert(stol(s));
    }
    for (string s: binConstructor)
    {
        constructString(s, binPalind, 19, binConstructor);
    }
    for (string s: binConstructor)
    {
        constructString("", binPalind, 20, binConstructor);
    }
    long result = 0;
    for (string s: binPalind)
    {   
        long val = strtol(s.c_str(),NULL,2);
        if (decValue.find(val) != decValue.end())
        {
            finalResult.insert(val);
        }
    }
    for (long x : finalResult)
    {
        cout << x << ";";
        result += x;
    }
    cout << endl << result << endl;
}