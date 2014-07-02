#include <cstdio>
#include <iostream>
#include <cstring>
#include <iomanip>
#include <algorithm>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
}

char* keyboard[] = {
	"`1234567890-=",
	"QWERTYUIOP[]\\",
	"ASDFGHJKL;'",
	"ZXCVBNM,./",
};

int main(int argc,char* argv[])
{
	char map[128];
	int i, j;
	openFile();
	for(i = 0; i < 4; ++i)
		for(j = 1; j < strlen(keyboard[i]); ++j)
			map[keyboard[i][j]] = keyboard[i][j-1];
	map[' '] = ' ';
	map['\n'] = '\n';
	map['\r'] = '\r';
	map['\t'] = '\t';
	char c;
	while ((c = getc(stdin)) && c != EOF)
		printf("%c", map[c]);
	return 0;
} 
