#include <iostream>     // std::cout
#include <algorithm>    // std::next_permutation, std::sort
#include <cmath>
#include <string>
#include <vector>
#include <unordered_set>

#define size 1001

using namespace std;

long pm[size][size];


int main () 
{
    int i = size / 2, j = size / 2;
    pm[i][j] = 1;
    int dir[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int stepIndex = 0, priorStepIndex = 0;
    for (int step = 0; step < size * size - 1; step ++)
    {
        if (pm[i + dir[stepIndex][0]][j + dir[stepIndex][1]] == 0)
        {
            priorStepIndex = stepIndex;
            pm[i + dir[stepIndex][0]][j + dir[stepIndex][1]] = pm[i][j] + 1;
            i += dir[stepIndex][0];
            j += dir[stepIndex][1];
            stepIndex ++;
        }
        else
        {
            stepIndex = priorStepIndex;
            pm[i + dir[stepIndex][0]][j + dir[stepIndex][1]] = pm[i][j] + 1;
            i += dir[stepIndex][0];
            j += dir[stepIndex][1];
            stepIndex ++;
        }
        if (stepIndex == 4)
        {
            stepIndex = 0;
        }
    }
    long result = 0;
    for (int i = 0; i < size; i ++)
    {
        result += pm[i][i];
    }
    for (int i = 0; i < size; i ++)
    {
        result += pm[i][size - i - 1];
    }
    result -= 1;
    cout << result << endl;
}