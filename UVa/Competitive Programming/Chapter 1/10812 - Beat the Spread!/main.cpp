#include <cstdio>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

int main(int argc,char* argv[])
{
	openFile();
	int n,s,d,a,b;
	scanf("%d\n", &n);
	while(n--)
	{
		scanf("%d %d\n", &s, &d);
		if (s < d || (s-d)%2 != 0 )
		{
			printf("impossible\n");
			continue;
		}
		b = (s-d)/2;
		a = d + b;
		if (a > b)
			printf("%d %d\n", a, b);
		else
			printf("%d %d\n", b, a);
	}
	return 0;
}
