#include <cstdio>

inline bool check(unsigned long long& a, int num, int& count)
{
	if (!(a % num))
	{
		count++;
		printf("ugly %lld\n", a);
		return true;
	}
	return false;
}

int main(int argc, char* argv[])
{
	unsigned long long a(1);
	int count(1);
	while(count != 11)
	{
		a++;
		if (check(a,2,count))
			continue;
		if (check(a,3,count))
			continue;
		if (check(a,5,count))
			continue;
	} 
	printf("The 1500'th ugly number is %lld.\n", a);
	return 0;
}
