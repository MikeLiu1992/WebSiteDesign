#include <iostream>
#include <unordered_map>
#include <string>
#include <vector>

using namespace std;

unordered_map<long, long> path;

long findPath(long x)
{
    if (x == 1)
        return 0;
    if (path.find(x) != path.end())
        return path[x];
    vector<long> usedValue;
    while (path.find(x) == path.end())
    {
        usedValue.push_back(x);
        if (x % 2)
        {
            x = 3 * x + 1;
        }
        else
        {
            x /= 2;
        }
    }
    long terminalValue = path[x];
    for (int i = usedValue.size() - 1; i >= 0; i --)
    {
        terminalValue ++;
        path[usedValue[i]] = terminalValue;
    }
    return terminalValue;
}

int main()
{
    long result = 1;
    long maxPath = 1;
    path[1] = 0;
    for (long i = 2; i < 1000000; i ++)
    {
        long x = findPath(i);
        if (maxPath < x)
        {
            maxPath = x;
            result = i;
        }
    }
    cout << result <<endl;
    return 0;
}