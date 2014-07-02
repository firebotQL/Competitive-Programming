#include <cstdio>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

unsigned int reverse(unsigned int number)
{
	unsigned int rnumber;
	rnumber = number % 10;
	while(number /= 10)
		rnumber = rnumber*10 + number % 10;
	return rnumber;
}
	
int main(int argc, char* argv[])
{
	int N;
	unsigned int count, number, rnumber;
	openFile();
	scanf("%d\n", &N);
	while(N--)
	{
		scanf("%u\n", &number);
		count = 0;
		while((rnumber = reverse(number)) != number)
		{
			count++;
			number += rnumber;	
		}
		printf("%u %u\n", count, number);
	}
	return 0;
}
