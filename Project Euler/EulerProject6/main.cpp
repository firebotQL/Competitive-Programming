#include <algorithm>
#include <math.h>
#include <iostream>

using namespace std;
int main()
{
	long long sum(1), sum2(1);
	for(int i = 2; i <= 100; i++) {
		sum += (long long)pow(i, 2.0);
		sum2 += i;
	}
	sum2 = (long long)pow(sum2, 2.0);
	cout << sum2 - sum;
	cin >> sum;
	return 0;
}