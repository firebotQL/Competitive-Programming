#include <cstdio>
#include <cstring>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
		freopen("test.out", "w", stdout);
	#endif
}
const char* letters[] =
{
	"ABCDEFGHI",
	"JKLMNOPQR",
	"STUVWXYZ0",
	"123456789",
	".,?'!/()&",
	":;=+-_\"@"
};

char morse_codes[9][6][10] =
{
   { ".-",   ".---", "...",   ".----",  ".-.-.-", "---..." },
   { "-...", "-.-",  "-",     "..---",  "--..--", "-.-.-." },
   { "-.-.", ".-..", "..-",   "...--",  "..--..", "-...-"  },
   { "-..",  "--",   "...-",  "....-",  ".----.", ".-.-."  },
   { ".",    "-.",   ".--",   ".....",  "-.-.--", "-....-" },
   { "..-.", "---",  "-..-",  "-....",  "-..-.",  "..--.-" },
   { "--.",  ".--.", "-.--",  "--...",  "-.--.",  ".-..-." },
   { "....", "--.-", "--..",  "---..",  "-.--.-", ".--.-." },
   { "..",   ".-.",  "-----", "----.",  ".-...", ""        }
} ;

inline const char& find_letter(char* morse, int& i, int& j)
{
	for(i = 0; i < 9; ++i)
		for(j = 0; j < 6; ++j)
			if(!strcmp(morse_codes[i][j], morse))
				return letters[j][i];		
}

int main(int argv,char* argc[])
{
	int n, i, j, len, iCount(0);
	char line[2005];
	char* split;
	
	openFile();
	scanf("%d\n", &n);
	while(n--)
	{
		iCount++;
		scanf( " %[^\n]s", line );
		len = strlen(line);
		// Replace single space by 's'
		for(i = 1; i < len; ++i)
			if(line[i-1] == ' ')
			{
				line[i-1] = 's';
				if (line[i] == ' ')	
					i++;					
			}
		printf("Message #%d\n", iCount);
		split = strtok (line,"s");
		while (split != NULL)
		{
			if (split[0] == ' ')
			{
				split++;
				printf(" %c", find_letter(split, i, j));
			} else {
				printf("%c", find_letter(split, i, j));
			}			
			split = strtok (NULL, "s");
		}
		printf("\n");
		if(n)
			printf("\n");
	}
	return 0;
}
