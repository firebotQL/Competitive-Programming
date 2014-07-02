#include <iostream>

using namespace std;

int main()
{
	int i,j,jOrig;
	int iCount(0);
	while (cin >> i >> j)
	{
		jOrig = j;
		while (i <= j)
		{
			if (!(j % 2))
				j /= 2;
			else
				j = j * 3 + 1;
			iCount++;
		}
		printf("%i %i %i", i, jOrig, iCount);
		iCount = 0;
	}
	return 0;
}