#include <cstdio>
#include <cstring>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

int main(int argc, char* argv[])
{
	int n, nAdded(0), i;
	char** countries;
	int* loved;
	char line[80], country[80];
	char* a;
	bool found = false;
	openFile();
	scanf("%d\n", &n);
	countries = new char*[n];
	loved = new int[n];
	for(i = 0; i < n; ++i)
		loved[i] = 0;
	while(gets(line))
	{
		found = false;
		sscanf(line, "%s %*100\n", country);
		for(i = 0; i < nAdded; ++i)
		{
			//printf("loved: %s %s\n", countries[i], country);
			if (!strcmp(countries[i], country))
			{
				loved[i]++;
				found = true;
				break;
			}
		}
		if (!found)
		{
			countries[nAdded] = new char[strlen(country)];
			strcpy(countries[nAdded], country);
			loved[nAdded]++;
			nAdded++;
		}
	}
	found = true;
	while(found)
	{
		found = false;
		for(i = 1; i < nAdded; ++i)
		{
			if (strcmp(countries[i-1], countries[i]) > 0)
			{
				char* a = countries[i-1];
				countries[i-1] = countries[i];
				countries[i] = a;
				
				loved[i] ^= loved[i-1];
				loved[i-1] = loved[i] ^ loved[i-1];
				loved[i] ^= loved[i-1];
				found = true;
			}
		}
	}
	for(i = 0; i < nAdded; ++i)
	{
		printf("%s %d\n", countries[i], loved[i]);
		delete [] countries[i];
	}
	
	delete [] countries;
	delete [] loved;
	return 0;
}
