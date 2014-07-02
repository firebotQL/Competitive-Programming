#include <cstdio>

#define SWAP(x,y) (x^=y, y^=x, x^=y)

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
}


int main(int argc, char* argv[])
{
	int n, a, b, c, iCount(1);
	openFile();
	scanf("%d\n", &n);
	for(;iCount <= n; ++iCount)
	{
		scanf("%d %d %d\n", &a, &b, &c);
		
		if (a > b)
			SWAP(a,b);
		if (a > c)
			SWAP(a,c);
		if (b > c)
			SWAP(b,c);

		printf("Case %d: %d\n", iCount, b);
	}
	return 0;
}