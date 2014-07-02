#include <cstdio>
#include <cstdlib>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

int main(int argc, char* argv[])
{
	int t, n;
	openFile();
	scanf("%d\n", &t);
	while(t-- && scanf("%d\n", &n))
		printf("%d\n", abs((n*315 + 36962) % 100) / 10);
	return 0;
}
