#include <cstdio>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

int main(int argv, char* argc[])
{
	int sum, n, m, bkp;
	openFile();
	while(scanf("%d\n", &n) != EOF)
	{
		sum = 0;
		m = 0;
		bkp = n;
		if (n == 1)
		{
			printf("1\n");
			continue;
		}
		if ( n % 2 == 0)
			n++;
		do
		{
			n += m;
			m = n / 3;
			sum += m;
			n = n % 3;
		} while(n || m != 1);
		if (bkp % 2 == 0)
			printf("%d\n", sum*3);
		else
			printf("%d\n", sum*3+1);
	}
	return 0;
}
