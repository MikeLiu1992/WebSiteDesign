#include <iostream>     // std::cout
#include <algorithm>    // std::next_permutation, std::sort
#include <cmath>
#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

int main()
{
    long result = 0;
    long x1 = 1, x2 = 2;
    while (x2 <= 4e6)
    {
        if (x2 % 2 == 0)
            result += x2;
        long tmp = x2;
        x2 += x1;
        x1 = tmp;
    }
    cout << result << endl;
}