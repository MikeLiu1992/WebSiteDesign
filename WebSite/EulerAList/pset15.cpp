#include <iostream>

using namespace std;

int main()
{
    long arr[21][21];
    for (int i = 0; i < 21; i ++)
    {
        arr[i][0] = 1;
        arr[0][i] = 1;
    }
    for (int i = 1; i < 21; i ++)
    {
        for (int j = 1; j < 21; j ++)
        {
            arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
        }
    }
    cout << arr[20][20] << endl;
}