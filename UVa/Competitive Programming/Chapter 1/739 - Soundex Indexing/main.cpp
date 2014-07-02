#include <cstdio>
#include <iostream>
#include <cstring>
#include <cstdlib>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
		freopen("test.out", "w", stdout);
	#endif
}

const char* neverEnc = "AEIOUYWH";
const char* EncodedKeys[] = {
	"BPFV",
	"CSKGJQXZ",
	"DT",
	"L",
	"MN",
	"R"
};

int main(int argc, char *argv[])
{
	openFile();
	char name[20], code[5], last, test[20];
	int codeGuide[26];
	int iCount(1), i, j;
	for(i = 0; i < 8; ++i)
		codeGuide[neverEnc[i]] = 0;
	for(i = 0; i < 6; ++i)
		for(j = 0; j < strlen(EncodedKeys[i]); ++j)
			codeGuide[EncodedKeys[i][j]] = i+1;
	printf("%13s%33s\n", "NAME", "SOUNDEX CODE");		
	while(std::cin >> name)
	{
		iCount = 1;
		code[0] = name[0];
		code[1] = '0';
		code[2] = '0';
		code[3] = '0';
		code[4] = '\0';
		last = '0' + codeGuide[name[0]];
		for(i = 1; i < strlen(name) && iCount != 4; ++i)
			if (last != ('0' + codeGuide[name[i]]))
			{
				if (codeGuide[name[i]])
				{
					code[iCount++] = '0' + codeGuide[name[i]];
					last = '0' + codeGuide[name[i]];
				} else {
					last = '\0';	
				}
			}
		printf("%*s%*s\n", (9+strlen(name)), name, 29-strlen(name), code);	
	}
	printf("%32s\n","END OF OUTPUT");
	return 0;
}
