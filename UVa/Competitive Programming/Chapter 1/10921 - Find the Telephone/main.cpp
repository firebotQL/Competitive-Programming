#include <cstdio>
#include <cstring>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

char* table [] = 
{
	"ABC",
	"DEF",
	"GHI",
	"JKL",
	"MNO",
	"PQRS",
	"TUV",
	"WXYZ"	
};

int main(int argc,char* argv[])
{
	openFile();
	char t_binds[91];
	char input[33];
	int i,j;
	for(i = 0; i < 8; ++i)
		for(j = 0; j < strlen(table[i]); ++j)
			t_binds[table[i][j]] = (char)(i+2+48);
	t_binds['-'] = '-';
	t_binds['1'] = '1';
	t_binds['0'] = '0';
	while(gets(input))
	{
		j = strlen(input);
		for(i = 0; i < j; ++i)
		{
			printf("%d\n", t_binds[(i+2+48)]);
			input[i] = t_binds[input[i]];
		}
		printf("%s\n", input);
	}
}
