#include <cstdio>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

	
int main(int argc, char* argv[])
{
	int n, f, size, animal_num, env_friend, sum;
	openFile();
	scanf("%d\n", &n);
	while(n--)
	{
		scanf("%d\n", &f);
		sum = 0;
		while(f--)
		{
			scanf("%d %d %d\n", &size, &animal_num, &env_friend);
			sum += size * env_friend;
		}
		printf("%d\n", sum);
	}
	return 0;
}
