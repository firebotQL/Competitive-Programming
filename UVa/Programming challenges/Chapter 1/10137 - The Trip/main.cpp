#include <iostream>

using namespace std;

int main()
{
	int n(-1);
	double* expens;
	double sum(0), avg(0), posDiff(0), negDiff(0), tDiff(0);
	int i;
	while (cin >> n && n != 0)
	{
		negDiff = 0;
		posDiff = 0;
		sum = 0;
		expens = new double[n];
		for(i = 0; i < n; i++) 
		{
			cin >> expens[i];
			sum += expens[i];
		}

		avg = sum / n;

		for(i = 0; i < n; i++) 
		{
			tDiff = (double)(long)((expens[i] - avg) * 100.0) / 100.0;
			if (tDiff > 0)
				posDiff += tDiff;
			else
				negDiff += tDiff;
		}

		if (-negDiff > posDiff)
			printf("$%.2f\n", -negDiff);
		else
			printf("$%.2f\n", posDiff);

		delete [] expens;
	}
	return 0;
}
