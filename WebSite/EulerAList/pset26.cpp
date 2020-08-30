#include <iostream>     // std::cout
#include <algorithm>    // std::next_permutation, std::sort
#include <cmath>
#include <string>
#include <vector>
#include <map>

using namespace std;

string fractionToDecimal(int denr) 
{ 
    string res;
    map <int, int> mp; 
    mp.clear(); 
    int rem = 1; 
    while ( (rem!=0) && (mp.find(rem) == mp.end()) ) 
    { 
        mp[rem] = res.length(); 
        rem = rem*10; 
        int res_part = rem / denr; 
        res += to_string(res_part); 
        rem = rem % denr; 
    }   
    return (rem == 0)? "" : res.substr(mp[rem]); 
} 

int main () 
{
    int result = 0;
    int maxLen = 0;
    for (int i = 2; i < 1000; i ++)
    {
        if (fractionToDecimal(i).size() > maxLen)
        {
            maxLen = fractionToDecimal(i).size();
            result = i;
        }
    }
    cout << result << endl;
}