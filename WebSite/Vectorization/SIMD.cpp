#include <immintrin.h>
#include <vector>
#include <stdlib.h>
#include <iostream>

int main() {

    /* Initialize the two argument vectors */
    __m256d evens = _mm256_set_pd(2.0, 4.0, 6.0, 8.0);
    __m256d odds = _mm256_set_pd(2.0, 4.0, 6.0, 8.0);

    /* Compute the difference between the two vectors */
    __m256d result = _mm256_add_pd(evens, odds);

    /* Display the elements of the result vector */
    double* f = (double*)&result;
    printf("%f %f %f %f\n", f[3], f[2], f[1], f[0]);

    double result1[4];
    double eveVal[4] = {2.0, 4.0, 6.0, 8.0};
    double oddVal[4] = {2.0, 4.0, 6.0, 8.0};
    result1[0] = eveVal[0] + oddVal[0];
    result1[1] = eveVal[1] + oddVal[1];
    result1[2] = eveVal[2] + oddVal[2];
    result1[3] = eveVal[3] + oddVal[3];
    printf("%f %f %f %f\n", result1[0], result1[1], result1[2], result1[3]);
    return 0;
}