#include <cstdio>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}
	
bool hasDifferentDigits(long long number)
{
	int decimals[10], index(0);
	for(int i = 0; i < 10; ++i)
		decimals[i] = 0;

	decimals[number % 10]++;
	while(number /= 10)
	{
		index = number % 10;		
		if (decimals[index] < 1)
			decimals[index]++;
		else
			return false;
	}
	return true;		
}

int main(int argc, char* argv[])
{
	long long N, a, b(98765), number;
	bool hasSolutions(false), notfirst(false);
	openFile();
	while(scanf("%lld\n", &N) && N)
	{
		hasSolutions = false;
		if (notfirst)
			printf("\n");
		else	
			notfirst = true;

		for(a = 1234; ((number = a*N) < b); ++a)
		{
			if (hasDifferentDigits(number*100000+a))
			{
				printf("%lld\n", number*100000+a);
				hasSolutions = true;
				if (a < 9999)
					printf("%lld / 0%lld = %lld\n", number, a, N);	
				else
					printf("%lld / %lld = %lld\n", number, a, N);	
			}
		}
		if (!hasSolutions)		
			printf("There are no solutions for %lld.\n", N);
	}
}
