#include <iostream>
#include <math.h>
#include <algorithm>

using namespace std;
double sqrpow(int val)
{
	return val*val;
}
int main()
{
int a(1),b(2),c(3);
int sum = a + b + c;
float cfloat;
long product;
	for (a = 1; a < 1000; ++a)
		for (b = 1; b < 1000; ++b )
		{
			cfloat = sqrt(sqrpow(a)+sqrpow(b));
			if (fmod(cfloat, 1.0f) == 0)
				sum = a + b + cfloat;
			if (sum == 1000)
			{
				product = a * b * cfloat;
				cout << product << endl;
				cin >> product;
				return 0;
			}
		}	
}