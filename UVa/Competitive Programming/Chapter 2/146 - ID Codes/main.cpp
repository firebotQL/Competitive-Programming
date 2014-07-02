#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <algorithm>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
}

int main(int argc,char* argv[])
{
	openFile();
	char line[50];
	while(gets(line) && strcmp(line, "#"))
	{
		printf("%s\n", line);
		if (std::next_permutation(line, line + strlen(line)))
			printf("%s\n", line);
		else
			printf("No Successor\n");
	}
	return 0;
} 
