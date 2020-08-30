#include <iostream>     // std::cout
#include <algorithm>    // std::next_permutation, std::sort
#include <cmath>
#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

int main()
{
    //We can try deducing the values, since we want the number to be as big as possible, we would start with 9.
    //If we start with 9, we will have 9... * 1 = 9... and 9... * 2 = 18... or 19... so it has to be 18..., 
    //Therefore the second number can not be higher than 3 so it is 93... and pure 93 is not working.
    //Gradually work down we find:
    int i = 9327;
    cout << i * 1 << endl;
    cout << i * 2 << endl;
}