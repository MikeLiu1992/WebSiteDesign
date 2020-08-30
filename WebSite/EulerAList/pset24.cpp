#include <iostream>     // std::cout
#include <algorithm>    // std::next_permutation, std::sort

using namespace std;

int main () {
  int myints[] = {0, 1, 2,3, 4, 5, 6, 7, 8, 9};
  long cnt = 0;
  do {
    cnt ++;
    if (cnt >= 1000000) break;
  } while ( std::next_permutation(myints,myints+10) );

  for (int i = 0; i < 10; i ++)
  {
      cout << myints[i];
  }
  cout << endl;

  return 0;
}