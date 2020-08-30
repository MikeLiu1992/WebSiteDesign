#include <iostream>
#include <algorithm>
#include <sstream>
#include <vector>
#include <cmath>
#include <fstream>
#include <unordered_set>
#include <string>
using namespace std;

int main()
{
    vector<int> wordList;
    unordered_set<int> triangleList;
    ifstream infile( "p042_words.txt" );
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
            int sum = 0;
            for (char c : s)
            {
                sum += c - 'A' + 1;
            }
            wordList.push_back(sum);
        }
    }
    infile.close();
    for (int i = 1; i < 200; i ++)
    {
        triangleList.insert((i + 1) * i / 2);
    }
    int result = 0;
    for (int word : wordList)
    {
        if (triangleList.find(word) != triangleList.end())
        {
            result ++;
        }
    }
    cout << result << endl;
}