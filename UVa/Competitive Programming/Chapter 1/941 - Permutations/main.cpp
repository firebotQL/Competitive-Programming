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

inline void swap(char *str, int i, int j)
{
	str[i] ^= str[j];
	str[j] = str[i] ^ str[j];
	str[i] ^= str[j];
}

inline void reverse(char *start, char* end)
{
	for(; start < end; ++start, --end)
	{
		*start ^= *end;
		*end = *start ^ *end;
		*start ^= *end;
	}		
}


bool next_permutation(char *str, int length)
{
	int i(length-1);
	while((i >= 0) && (str[i] >= str[i+1])) --i;	// Finding first i smaller than i+1

	if (i == -1)
		return false;
	
	int j = length-1;
	while((j >= 0) && str[j] <= str[i]) --j;	// Finding first j bigger than i
	// swapping j with i
	swap(str, j, i);
	// reversing
	reverse(str+i+1, str + (length-1));
	return true;
}

// simple bubble
void sort(char *str, int length)
{
	int i = 0;
	bool swapped(true);
	while(swapped)
	{
		swapped = false;
		for(i = 0; i < length-1; ++i)
			if (str[i] > str[i+1])
			{
				swap(str, i, i + 1);
				swapped = true;
			}
	}
}

int main(int argc,char* argv[])
{
	unsigned long long N, nCases;
	int length;
	char str[20],t[20];
	openFile();
	fscanf(stdin, "%llu\n", &nCases);
	while(nCases--)
	{
		fscanf(stdin, "%s\n", str);
		fscanf(stdin, "%llu\n", &N);
		length = strlen(str);
		sort(str, length);
		while(N && N--)
			std::next_permutation(str, str + length);	
		printf("%s\n", str);
	}
	return 0;
} 
