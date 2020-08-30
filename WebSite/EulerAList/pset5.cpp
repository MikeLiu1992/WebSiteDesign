#include <iostream>     
#include <algorithm>    
#include <cmath>
#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

int main()
{
    /// We only need to find all the prime factor and their maximum power to construct the value
    vector<int> primeList = {2,3,5,7,11,13,17,19};
    vector<int> powerList = {4,2,1,1,1, 1, 1, 1};
    int result = 1;
    for (int i = 0; i < 8 ; i++)
    {
        result *= pow(primeList[i], powerList[i]);
    }
    cout << result << endl;
}