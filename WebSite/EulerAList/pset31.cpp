#include <iostream>   
#include <algorithm>    
#include <cmath>
#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

vector<int> currrency{1, 2, 5, 10, 20, 50, 100, 200};

int helper(int currValue, int currCoin)
{
    if (currValue == 0)
    {
        return 1;
    }
    if (currCoin == 8 || currValue < 0)
    {
        return 0;
    }
    int ways = 0;
    for (int i = 0; i <= currValue / currrency[currCoin]; i ++)
    {
        ways += helper(currValue - i * currrency[currCoin], currCoin + 1);
    }
    return ways;
}

int main () 
{
    cout << helper(200, 0) << endl;
}