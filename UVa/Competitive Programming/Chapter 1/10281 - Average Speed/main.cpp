#include <cstdio>
#include <iostream>
#include <cstring>
#include <iomanip>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
}

inline unsigned long long getInSeconds(unsigned long long& hours, unsigned long long& minutes, unsigned long long& seconds)
{
	return hours*3600 + minutes*60 + seconds;
}
int main(int argc,char* argv[])
{
	unsigned long long speed(0), hours(0), minutes(0), seconds(0), start_hours(0), start_minutes(0), start_seconds(0), start_speed(0);
	char line[256];
	int success_num, iCount(0);
	double total_distance(0);
	openFile();
	while(fgets(line, 256, stdin))
	{
		success_num = sscanf(line, "%llu:%llu:%llu %llu\n", &hours, &minutes, &seconds, &speed);
		switch(success_num)
		{
		case 4:
			if(iCount)
				total_distance += start_speed * (getInSeconds(hours, minutes, seconds)-getInSeconds(start_hours, start_minutes, start_seconds))/3600.0;		
			start_speed = speed;
			start_hours = hours;
			start_minutes = minutes;
			start_seconds = seconds;
			iCount++;
			break;
		case 3:
			line[strlen(line)-1] = '\0';
			printf("%s %.2f km\n", line, total_distance + speed * (getInSeconds(hours, minutes, seconds)-getInSeconds(start_hours, start_minutes, start_seconds))/3600.0 );	
			break;
		}
	}
	return 0;
} 
