#include <cstdio>
#include <iostream>
#include <vector>
#include <string>

std::vector<int> gRam;
std::vector<int> gRegister;
inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
}
int executeCase();

void calculate()
{
	int n,iCount;
	std::string integer;
	std::getline( std::cin, integer );
	n = atoi(integer.c_str());
	std::getline( std::cin, integer );
	for(int i = 0; i < n; i++)
	{
		iCount = 0;
		gRam.assign(1000, 0);
		gRegister.assign(10, 0);
		while(std::getline( std::cin, integer ) && !integer.empty())
			gRam[iCount++] = atoi(integer.c_str());
		if (i+1 != n)
			std::cout << executeCase() << std::endl << std::endl;
		else
			std::cout << executeCase() << std::endl;
	}
	
}

int executeCase()
{
	int nInstr(0),twoNum,x,y;
	for(std::vector<int>::size_type i = 0; i < gRam.size(); i++)
	{
		twoNum = gRam[i] % 100;
		x = twoNum / 10;
		y = twoNum % 10;
		nInstr++;
		switch(gRam[i] / 100)
		{
		case 0:
			if (gRegister[y] != 0)
				i = gRegister[x]-1;
			break;
		case 1:
			return nInstr;
			break;
		case 2:
			gRegister[x] = y;
			break;
		case 3:
			gRegister[x] += y;
			gRegister[x] %= 1000;
			break;
		case 4:
			gRegister[x] *= y;
			gRegister[x] %= 1000;
			break;
		case 5:
			gRegister[x] = gRegister[y];
			break;
		case 6:
			gRegister[x] += gRegister[y];
			gRegister[x] %= 1000;
			break;
		case 7:
			gRegister[x] *= gRegister[y];
			gRegister[x] %= 1000;
			break;
		case 8:
			if (gRam[gRegister[y]] == -1)
				gRegister[x] = 0;
			else
				gRegister[x] = gRam[gRegister[y]];
			break;
		case 9:
			gRam[gRegister[y]] = gRegister[x];
			break;
		}
	}
	return nInstr;
}

int main()
{
	openFile();
	calculate();
	return 0;
}