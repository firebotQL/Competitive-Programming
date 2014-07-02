#include <iostream>
#include <vector>
#include <string>

using namespace std;

double round(double dValue)
{
	return floor(dValue + 0.5);
}

double expendures(double* expens, double avg, int i)
{
	double posDiff(0), negDiff(0);

	if (expens[i] > avg) 
		posDiff += expens[i] - avg;
	else
		negDiff += avg - expens[i];

	if (negDiff > posDiff)
		return negDiff;
	else
		return posDiff;

}
int main()
{
	int n(-1);
	double* expens;
	double sum(0), avg(0), sumzor(0);
	int i;
	while (cin >> n && n != 0)
	{
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
			sumzor += expendures(expens, avg, i);
		}

		cout << sumzor << endl;

		delete expens;
	}
	return 0;
}
