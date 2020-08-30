#include <iostream>     // std::cout
#include <algorithm>    // std::next_permutation, std::sort
#include <cmath>
#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

int main () 
{
    vector<vector<int>> value(11, vector<int>());
    for (int i = 2; i <= 10; i ++)
    {
        int tmp = i, cnt = 1;
        while (tmp <= 100)
        {
            value[i].push_back(cnt);
            cnt ++;
            tmp *= i;
        }
    }
    long result = 0;
    int calculatedValue = 0;
    vector<int> non_distinctSize(7, 0);
    unordered_set<int> usedList;
    for (int i = 1; i <= 6; i ++)
    {
        for (int k = 2 * i; k <= 100 * i; k += i)
        {
            if (usedList.find(k) == usedList.end())
                usedList.insert(k);
        }
        non_distinctSize[i] = usedList.size();
    }
    for (int i = 2; i <= 10; i ++)
    {
        if (i == 4 || i == 8 || i == 9) continue;
        calculatedValue += value[i].size();
        result += non_distinctSize[value[i].back()];
    }
    result += 99 * (99 - calculatedValue);
    cout << result << endl;
}