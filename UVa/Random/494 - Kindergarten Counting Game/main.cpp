#include <iostream>
#include <cstdio>
#include <string>
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
	char str[10240];
	char* tok;
	int count, i, ch(32);
	char symbols[46];

	// Noobish preparation :))
	for(i = 0; i < 33; ++i)
		symbols[i] = ch++;
	ch = 91;
	for(i = 33; i < 39; ++i)
		symbols[i] = ch++;
	ch = 123;
	for(i = 39; i < 43; ++i)
		symbols[i] = ch++;
	symbols[43] = ' ';
	symbols[44] = '\n';
	symbols[45] = '\0';

	openFile();
	while(fgets(str, 10240, stdin))
	{
		count = 0;
		tok = strtok(str, symbols);
		while(tok != NULL)
		{
			count++;
			tok = strtok(NULL, symbols);
		}
		cout << count << endl;
	}
	
	return 0;
}
