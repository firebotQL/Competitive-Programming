#include <cstdio>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
}

inline long long myabs(long long number)
{
	return( number >= 0 ? number : -number );
}

int main(int argc, char* argv[])
{
	long long a,b;
	openFile();
	while(fscanf(stdin, "%llu %llu\n", &a, &b) != EOF)
		printf("%llu\n", myabs(a-b));
	return 0;
} 
