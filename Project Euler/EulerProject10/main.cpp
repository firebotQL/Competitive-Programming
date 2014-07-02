#include <limits.h>
#include <iostream>
#include <math.h>
#include <vector>

using namespace std;

long getPrime(long maxPrime)
{
	long pp = 2;
	vector<long> ps(1,pp);
	pp++;
	ps.push_back(pp);
	bool bTest(true);
	long sqrtPP;
	long count(2);
	long long sum(5);
	vector<long>::size_type index, length;
	while ((pp += 2) < maxPrime) 
	{
		bTest = true;
		sqrtPP = (long)sqrt((double)pp);
		length = ps.size();
		for(index = 0; index < length; ++index)
		{
			if (ps[index] > sqrtPP) break;
			if ((pp % ps[index]) == 0) bTest = false;
		}
		if (bTest) 
		{
			sum += pp;
			ps.push_back(pp);
		}
	}
	return sum;

}

int main()
{
	long sumPrimes = getPrime(2000000);
	cout << sumPrimes << endl;
	cin >> sumPrimes;
	return 0;
}