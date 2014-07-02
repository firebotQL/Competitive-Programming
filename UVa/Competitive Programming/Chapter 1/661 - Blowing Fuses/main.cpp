#include <cstdio>
#include <iostream>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in","r",stdin);
#endif
}

const char* answers[] = {
	"Sequence %i\n",
	"Fuse was %sblown.\n",
	"Maximal power consumption was %i amperes.\n",
};
int main(int argc, char *argv[])
{
	int n,m,c,c_fresh,i,j, *dev_consumptions, operation, iCase(0), iMax;
	openFile();
	while(std::cin >> n >> m >> c)
	{
		if (n == m && m == c && c == 0)
			return 0;
		iCase++;
		c_fresh = c;
		iMax = 9999;
		dev_consumptions = new int[n];
		for(i = 0; i < n; ++i)
			std::cin >> dev_consumptions[i];
		
		for(j = 0; j < m; ++j)
		{
			std::cin >> operation;
			c -= dev_consumptions[operation-1];
			dev_consumptions[operation-1] *= -1;
			if (c < iMax && c >= 0)
				iMax = c;
			if (c < 0)
			{
				printf(answers[0], iCase);
				printf(answers[1], "");
				std::cin.ignore((m-(j+1))*2);
				break;
			}
		}

		if (c >= 0)
		{
			printf(answers[0], iCase);
			printf(answers[1], "not ");
			printf(answers[2], c_fresh-iMax);	
		}
		
		std::cout << std::endl;
		
		delete [] dev_consumptions;
	} 
	return 0;
}
