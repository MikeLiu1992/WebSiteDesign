#include <iostream>     // std::cout
#include <algorithm>    // std::next_permutation, std::sort
#include <cmath>

using namespace std;

int main () {
  //using Fibonacci explicit form, first term dominant with big value therefore:
  double N1 = (1 + sqrt(5)) / 2;
  cout << "Upper Bound" << (999 * log(10) + log(10 * sqrt(5))) / log(N1) << endl;
  cout << "Lower Bound" << (999 * log(10) + log(sqrt(5))) / log(N1) << endl;

  return 0;
}