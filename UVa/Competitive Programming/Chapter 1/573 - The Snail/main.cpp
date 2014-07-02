#include <cstdio>
#include <iostream>
#include <cstring>
#include <vector>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

double climbUp(int& day, double& fatigue, double& power, double& currentHeight)
{
	if (day == 1)
		return currentHeight + power;
	else
	{
		if((1-(day-1)*fatigue/100.0) >= 0)
			return currentHeight + power*(1-(day-1)*fatigue/100.0);
		else
			return currentHeight;
	}
}

double slideDown(double& slide_offset, double& currentHeight)
{
	return currentHeight-slide_offset;
}

int main(int argc,char* argv[])
{
	double H,U,D,F,climbed;
	int iDay(1);
	openFile();
	while(std::cin >> H >> U >> D >> F)
	{
		if (H == 0)
			break;
		iDay = 1;
		climbed = 0;
		while(true)
		{
			climbed = climbUp(iDay, F, U, climbed);
			if (climbed > H)
				break;
			climbed = slideDown(D, climbed);
			if (climbed < 0)
				break;
			iDay++;
		}
		if (climbed > H)
			std::cout << "success on day " << iDay << std::endl;
		else
			std::cout << "failure on day " << iDay << std::endl;
	}
}