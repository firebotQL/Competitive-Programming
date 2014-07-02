#include <limits.h>
#include <iostream>
#include <math.h>
#include <vector>

using namespace std;

long getPrime(long primeCount)
{
	long pp = 2;
	vector<long> ps(1,pp);
	pp++;
	ps.push_back(pp);
	bool bTest(true);
	long sqrtPP;
	long count(2);
	vector<long>::size_type index, length;
	while (true) 
	{
		pp += 2;
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
			count++;
			ps.push_back(pp);
		}	
		if (count == primeCount)
			return pp;
	}

}

int main()
{
	long count = 10001;
	long prime = getPrime(count);
		
	cout <<  count << " " << prime;
	cin >> count;

	return 0;
}