#include <iostream>
#include <map>

using namespace std;

int main()
{
	map<unsigned long, unsigned long> MemoizationMap;
	unsigned long i,j,xOrig, iOld, jOld;
	unsigned long iCount(1), maxCycl(0), iTemp;
	while (cin >> i >> j)
	{
		iOld = i;
		jOld = j;
		if (i > j)
		{
			iTemp = j;
			j = i;
			i = iTemp;
		}

		for(unsigned long x = i; x <= j; x++)
		{
			xOrig = x;
			while (xOrig != 1)
			{
				iCount++;
				if (!(xOrig % 2))
					xOrig /= 2;
				else
					xOrig = xOrig * 3 + 1;
			}
			if (iCount > maxCycl)
				maxCycl = iCount;
			iCount = 1;	
			cout << "Nr. " << << " " << maxCycl << endl;
		}

		cout << iOld << " " << jOld << " " << maxCycl << endl;

		maxCycl = 0;
	}
	return 0;
}