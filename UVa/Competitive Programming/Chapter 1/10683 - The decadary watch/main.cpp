#include <cstdio>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

int main(int argc,char* argv[])
{
	int time, hh, mm, ss, cc;
	openFile();
	while(scanf("%d\n", &time) != EOF)
	{
		hh = time / 1000000;
		time %= 1000000;
		mm = time / 10000;
		time %= 10000;
		ss = time / 100;
		cc = time % 100;
		time = ((((hh*60)+mm)*60)+ss)*100+cc;
		time = (time*125)/108;	
		printf("%07d\n", time);		 
	}
	return 0;
}
