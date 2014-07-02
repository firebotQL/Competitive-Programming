#include <cstdio>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

const char* message[] = { "No carry operation.\n",
			"%d carry operation%s\n"};
	
int main(int argc, char* argv[])
{
	unsigned int a,b;
	int sum, count, d1, d2;
	openFile();
	while(scanf("%u %u\n", &a, &b) && (a || b))
	{
		sum = 0;
		count = 0;
		while(a || b)
		{
			d1 = a % 10;
			d2 = b % 10;
			//printf("d1: %d d2: %d a: %d b: %d\n",d1,d2, a, b);
			a /= 10;
			b /= 10;
			sum = (sum + d1 + d2) / 10;
			if (sum)
				count++;
		}
		switch(count)
		{
			case 0:
				printf(message[0]);
				break;
			case 1:
				printf(message[1], count, ".");
				break;
			default:
				printf(message[1], count, "s.");
				break;	
		}			
	}
	return 0;
}
