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

int partition(double* arr, int left, int right, int pivotIndex)
{
	double pivotValue = arr[pivotIndex];
	double temp = arr[pivotIndex];
	arr[pivotIndex] = arr[right-1];
	arr[right-1] = temp;
	int storeIndex = left;
	for(int i = left; i < right-1; ++i)
	{
		if (arr[i] <= pivotValue)
		{
			temp = arr[i];
			arr[i] = arr[storeIndex];
			arr[storeIndex] = temp;
			storeIndex++; 
		}
	}
	temp = arr[storeIndex];
	arr[storeIndex] = arr[right-1];
	arr[right-1] = temp;
	return storeIndex;
}

void qsort(double* arr, int left, int right)
{
	if (right > left)
	{
		int pivotIndex = left + (right-left)/2;
		int pivotNewIndex = partition(arr, left, right, pivotIndex);
		qsort(arr, left, pivotNewIndex-1);
		qsort(arr, pivotNewIndex+1, right);
	}
}

int main(int argc,char* argv[])
{
	int num_cases, NL, i, j, iCases;
	double** segment;
	double dummy;
	double* x_dots;
	openFile();
	std::cin >> num_cases;
	while(num_cases--)
	{
		std::cin >> NL;
		segment = new double*[NL];
		x_dots = new double[NL*2];
		for(i = 0; i < NL; i++)
		{
			segment[i] = new double[3];
			std::cin >> segment[i][0] >> dummy >> segment[i][1] >> dummy >> segment[i][2];
			if (segment[i][0] > segment[i][1])
			{
				dummy = segment[i][0];
				segment[i][0] = segment[i][1];
				segment[i][1] = dummy;
			}
			x_dots[2*i] = segment[i][0];
			x_dots[2*i+1] = segment[i][1];
		}
		//qsort(x_dots, 0, NL*2);
		bool swapped = true;
		while(swapped)
		{
			swapped = false;
			for(i = 1; i < NL*2; i++)
				if (x_dots[i] < x_dots[i-1])
				{
					dummy = x_dots[i];
					x_dots[i] = x_dots[i-1];
					x_dots[i-1] = dummy;
					swapped = true;
				}
		}
		iCases = 0;
		for(i = 1; i < NL*2; i++)
		{
			if (x_dots[i-1] != x_dots[i])
				iCases++;
		}
		double multiplication;
		printf("%d\n", iCases+2);
		printf("%s %.3f %.3f\n", "-inf", x_dots[0], 1.0);
		for(i = 1; i < NL*2; i++)
		{
			multiplication = 1;
			if (x_dots[i-1] != x_dots[i])
			{
				for(j = 0; j < NL; j++)
				{
					if (x_dots[i-1] >= segment[j][0] && 
						x_dots[i-1] <= segment[j][1] &&
						x_dots[i] <= segment[j][1] &&
						x_dots[i] >= segment[j][0])
					{
						multiplication *= segment[j][2];
					}
				}
			printf("%.3f %.3f %.3f\n", x_dots[i-1], x_dots[i], multiplication);
			}
		}
		printf("%.3f %s %.3f\n", x_dots[NL*2-1], "+inf", 1.0);
		if(num_cases)
			std::cout << std::endl;
		for(i = 0; i < NL; i++)
			delete [] segment[i];
		delete [] segment;
		delete [] x_dots;
	}
	return 0;
} 
