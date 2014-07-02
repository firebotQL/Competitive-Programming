/* 
 * File:   main.cpp
 * Author: viaduk
 *
 * Created on July 26, 2010, 8:34 PM
 */
#include <math.h>
#include <cmath>
#include <vector>
/*
 * 
 */
#define MAX_SIZE 1000000

using namespace std;

double round(double d)
{
  return floor(d + 0.5);
}

std::vector<bool> getArray()
{
    std::vector<bool> temp;
    for(int i = 0; i < MAX_SIZE; i++)
        temp.push_back(true);
    return temp;
}

std::vector<bool> getPrimes()
{
    std::vector<bool> bVector = getArray();
    int j;
    double dTemp = (double)MAX_SIZE;
    int q = round(sqrt(dTemp));
    for (int i = 2; i < q; i++)
    {
        if (bVector[i])
        {
            j = i*i;
            while(j <= MAX_SIZE)
            {
                bVector[j] = false;
                j = j + i;
            }
        }
    }
    
}
int lcm(int a, int b)
{
   // std::vector<bool> bVector = getPrimes();
  //  for(int i = 0; i < bVector.size())
}
int main(int argc, char** argv) {

    return 0;
}

