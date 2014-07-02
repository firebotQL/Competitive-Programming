#include <cstdio>
#include <cstdlib>
#include <cstring>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
	freopen("test.out", "w", stdout);
#endif
}
char* letter = { "IVXLCDM" };
int value[] = { 1, 5, 10, 50, 100, 500, 1000 };
char* ones[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", ""};
char* tens[] = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", ""};
char* hundr[] = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", ""};
char* thous[] = {"M", "MM", "MMM", "MMMM"};

int main(int argc,char* argv[])
{
	//openFile();
	char number[20];
	int val[127];
	int answer;
	int i, n(1), iCount(1), len, o, t, h, th;
	char *M, *C, *X, *I;
	for(i = 0; i < 7; ++i)
		val[letter[i]] = value[i];

	while(scanf("%s\n", number) != EOF)
	{
		i = atoi(number);
		if (i)
		{
			o = i/1000; i %= 1000;
			t = i/100;  i %= 100;
			h = i/10;  i %= 10;
			th = i;
			o-1 >= 0 ? M = thous[o-1] : M = "";
			t-1 >= 0 ? C = hundr[t-1] : C = "";
			h-1 >= 0 ? X = tens[h-1] : X = "";
			th-1 >= 0 ? I = ones[th-1] : I = "";

			printf("%s%s%s%s\n", M, C, X, I);
		} 
		else 
		{
			answer = 0;
			len = strlen(number);
			for(i = 0; i < len; ++i)
			{
				if (i+1 != len)
				{
					if (val[number[i]] < val[number[i+1]])
					{
						answer += val[number[i+1]] - val[number[i]];
						++i;
					} 
					else
					{
						answer += val[number[i]];
					}
				}				
				else 
				{
					answer += val[number[i]];
				}
			}
			printf("%d\n", answer);
		}
	}
	return 0;
} 
