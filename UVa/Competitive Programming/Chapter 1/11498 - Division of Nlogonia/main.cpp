#include <cstdio>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

const char* message[] = 
{
	"divisa",
	"NO",
	"NE",
	"SE",
	"SO"
};

void y_axis_print(const char** message, int& Y, int& M, int i, int j)
{
	if (Y < M)
		printf("%s\n", message[i]);	 
	else
		printf("%s\n", message[j]);
}

int main(int argv, char* argc[])
{
	int K, N, M, X, Y;
	openFile();
	while (scanf("%d\n", &K) != EOF && K != 0)
	{
		scanf("%d %d\n", &N, &M);
		while(K--)
		{
			scanf("%d %d\n", &X, &Y);
			if (N == X || M == Y)
			{
				printf("%s\n", message[0]);
				continue;
			} 
			if (X > N)
				y_axis_print(message, Y, M, 3, 2);	
			else
				y_axis_print(message, Y, M, 4, 1);			
		}
	}
	return 0;
}
