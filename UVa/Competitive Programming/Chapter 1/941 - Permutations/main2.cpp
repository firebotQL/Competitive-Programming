#include <cstdio>
#include <iostream>
#include <cstring>
#include <iomanip>
#include <algorithm>
#include <vector>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
}

using namespace std;

inline void swap(char *str, int i, int j)
{
	str[i] ^= str[j];
	str[j] = str[i] ^ str[j];
	str[i] ^= str[j];
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

unsigned long long factorial(unsigned long long i)
{
	if(i == 1)
		return 1;
	return i * factorial(i-1);
}


vector<unsigned long long> get_nth(unsigned long long n, unsigned long long k) {
    if(n == 1)
        return vector<unsigned long long>(1, 0);
 
    int first_digit = k/factorial(n-1);
    vector<unsigned long long> ans(1, first_digit);
    vector<unsigned long long> rest = get_nth(n-1, k % factorial(n-1));
    for(unsigned long long i = 0; i < rest.size(); i++) {
        if(rest[i] >= first_digit)
            rest[i]++;
        ans.push_back(rest[i]);
    }
 
    return ans;
}

int main(int argc,char* argv[])
{
	unsigned long long N, nCases,I;
	int length,i;
	char str[20];
	openFile();
	fscanf(stdin, "%llu\n", &nCases);
	vector<unsigned long long> temp;
	while(nCases--)
	{
		fscanf(stdin, "%s\n", str);
		fscanf(stdin, "%llu\n", &N);

		length = strlen(str);
		sort(str, length);	

		temp = get_nth(length, N);

		for(i = 0; i < temp.size(); ++i)
			printf("%c", str[temp[i]]);
		printf("\n");
	}
	return 0;
}
