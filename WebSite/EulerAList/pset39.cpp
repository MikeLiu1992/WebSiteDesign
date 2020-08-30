#include <iostream>    
#include <algorithm>    
#include <cmath>
#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

vector<vector<int>> triangleList;
vector<int> counter(1001, 0);

int main()
{
    // We know that the max lengh of the triangle is 500 
    // Now we will assume a, b, c a is the max length. So a ^ 2 - b ^ 2 has to be a integer power.
    // We also know smallest list is 3, 4, 5 so a end with 5
    for (int a = 500; a >= 5; a --)
    {
        for (int b = a - 1; b >= 1; b --)
        {
            int c = (int)sqrt(a * a - b * b);
            if (c * c + b * b == a * a && b >= c && a + b + c <= 1000)
            {
                triangleList.push_back({a, b, c});
                counter[a + b + c] ++;
            }
        }
    }
    int maxval = 0;
    int res = 0;
    for (int i = 0; i < 1000; i ++)
    {
        if (counter[i] > maxval)
        {
            maxval = counter[i];
            res = i;
        } 
    }
    cout << res << endl;
}