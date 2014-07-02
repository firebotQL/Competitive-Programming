#include <cstdio>
#include <iostream>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
}

inline void deduce_multiplier(int &a)
{
	a % 3 ? a = a / 3 + 1 : a = a / 3 ;
}

int main(int argc,char* argv[])
{
	openFile();
	int t,n,m;
	scanf("%d\n", &t);
	while(t--)
	{
		scanf("%d %d\n", &n, &m);
		n -= 2;
		m -= 2;
		deduce_multiplier(n);
		deduce_multiplier(m);
		printf("%d\n", n*m);		
	}
	return 0;
} 
