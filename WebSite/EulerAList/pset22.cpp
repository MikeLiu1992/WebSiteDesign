#include <iostream>
#include <algorithm>
#include <sstream>
#include <vector>
#include <cmath>
#include <fstream>
#include <string>
using namespace std;

int main()
{
    vector<string> nameList;
    ifstream infile( "p022_names.txt" );
    while (infile)
    {
        string s;
        if (!getline(infile, s)) break;
        istringstream ss( s );
        while (ss)
        {
            string s;
            if (!getline( ss, s, ',' )) break;
            s.erase(remove(s.begin(), s.end(), '"'), s.end());
            nameList.push_back( s );
        }
    }
    infile.close();
    sort(nameList.begin(), nameList.end());
    long result = 0;
    for (int i = 1; i <= nameList.size(); i ++)
    {
        string s = nameList[i - 1];
        int sum = 0;
        for (char c : s)
        {
            sum += c - 'A' + 1;
        }
        result += sum * i;
    }
    cout << result << endl;
}