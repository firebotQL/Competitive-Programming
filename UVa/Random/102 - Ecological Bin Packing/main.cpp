#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <string>
#include <map>
#include <algorithm>

using namespace std;

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}


map<string, int> permutations;
map<string, int>::iterator it;

/*
int fact(int n)
{
	return n ? fact(n-1) * n : 1;
}

void permutate(char* symbols)
{
	int i, symbols_size(strlen(symbols)), count(0);
	int z = fact(symbols_size)/(symbols_size-1);
	while(z--)
		for(i = 0; i < symbols_size-1; ++i)
		{
			symbols[i] ^= symbols[i+1];
			symbols[i+1] ^= symbols[i];
			symbols[i] ^= symbols[i+1];
			permutations[symbols];
		}
}
*/

void permutate(char* symbols)
{
	permutations[symbols];
	while(next_permutation(symbols, symbols+strlen(symbols)))
		permutations[symbols];
}
	
void reset()
{
	for(it = permutations.begin(); it != permutations.end(); ++it)
		it->second = 0;
}

int main(int argc, char* argv[])
{
	char symbols[] = "BCG";
	int i, b[3],g[3],c[3],index(0);
	permutate(symbols);
	openFile();
	
	while(scanf("%d %d %d\n", &b[index], &g[index], &c[index]) != EOF)
	{
		index++;
		if (index == 3)
		{
			reset();
			strcpy(symbols, "BCG");
			index = 0;
			for(it = permutations.begin(); it != permutations.end(); ++it)
			{
				for(i = 0; i < 3; ++i)
				{
					switch(it->first[i])
					{
						case 'B':
							it->second += g[i] + c[i];
							break;
						case 'C':
							it->second += b[i] + g[i];
							break;
						case 'G':
							it->second += b[i] + c[i];
							break;
					}
				}
				if (permutations[symbols] > it->second)
					strcpy(symbols, it->first.c_str());
			}
			printf("%s %d\n", symbols, permutations[symbols]);
		}
	}
	return 0;
}
