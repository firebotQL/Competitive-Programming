#include <cstdio>

inline int sum(int a, int b)
{
	int summ(0);
	for(int i = a; i <= b; ++i)
		summ += i;
	return summ;
}

int main()
{
	int N;
	scanf("%d", &N);
	if (N > 0)
		printf("%d\n", sum(1, N));
	else	
		printf("%d\n", sum(N, 1));
	return 0;
}
