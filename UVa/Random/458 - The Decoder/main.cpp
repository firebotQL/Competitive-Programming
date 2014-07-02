#include <cstdio>
#include <cstring>

using namespace std;

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}
	
int main(int argc, char* argv[])
{
	char line[10240];
	int len,i;
	openFile();
	while(fgets(line, 10245, stdin))
	{
		len = strlen(line);
		for(i = 0; i < len-1; ++i)
			line[i] -= 7;
		printf("%s", line);
	}
	return 0;
}
