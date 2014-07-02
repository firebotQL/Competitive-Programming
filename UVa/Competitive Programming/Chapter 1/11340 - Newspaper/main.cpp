#include <cstdio>
#include <cstring>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
		freopen("test.out", "w", stdout);
	#endif
}

inline void reset(long* ch)
{
	for(int i = 0; i < 256; ++i)
		ch[i] = 0;
}

int main(int argc, char* argv[])
{
	int N,K,M,i;
	long payed_chars[256], B, sum;
	unsigned char c, A;
	openFile();
	scanf("%d\n", &N);
	size_t len;
	while(N--)
	{
		sum = 0;
		scanf("%d\n", &K);
		reset(payed_chars);
		while(K--)
		{
			scanf("%c %ld\n", &A, &B);
			payed_chars[A] = B;
		}
		scanf("%d\n", &M);
		while(M--)
		{
			do
			{
				c = getchar();
				sum += payed_chars[c];
			} while (c != '\n');
		}
		printf("%0.2Lf$\n", (long double)sum/100);
	}
	return 0;
}
