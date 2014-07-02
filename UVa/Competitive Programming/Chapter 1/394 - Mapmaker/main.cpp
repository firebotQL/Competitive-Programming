#include <cstdio>
#include <iostream>
#include <cstring>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
}

int main(int argc,char* argv[])
{
	int na, nar, i, j, z, CD_temp, Czero, result;
	char** array_name;
	char** ref_name;
	int* B, **CD, *D, **ii;
	int*** pair;
	openFile();
	std::cin >> na >> nar;
	array_name = new char*[na];
	ref_name = new char*[nar];
	B = new int[na];
	CD = new int*[na];
	D = new int[na];
	ii = new int*[nar];
	pair = new int**[na];
	for(i = 0; i < na; i++)
	{
		array_name[i] = new char[10];
		std::cin >> array_name[i] >> B[i] >> CD_temp >> D[i];
		CD[i] = new int[D[i]+1];
		CD[i][D[i]] = CD_temp; // Last element Cd in the Cn in every array line
		pair[i] = new int*[D[i]];
		for(j = 0; j < D[i]; j++)
		{
			pair[i][j] = new int[2];
			std::cin >> pair[i][j][0] >> pair[i][j][1];
		}
	}
	for(i = 0; i < nar; i++)
	{
		ref_name[i] = new char[10];
		std::cin >> ref_name[i];
		for(j = 0; j < na; j++)
			if (std::strcmp(ref_name[i], array_name[j]) == 0)
			{
				ii[i] = new int[D[j]];
				for (z = 0; z < D[j]; z++)
					std::cin >> ii[i][z];
				break;
			}
	}

	for(i = 0; i < nar; ++i)
	{
		result = 0;
		for(j = 0; j < na; ++j)
		{
			if (std::strcmp(ref_name[i], array_name[j]) == 0)
			{
				Czero = B[j] - CD[j][D[j]] * (pair[j][D[j]-1][0]);	// Removing last element Cd
				for(z = D[j]-1; z > 0; --z)
				{
					CD[j][z] = CD[j][z+1] * (pair[j][z][1] - pair[j][z][0] + 1);	// Calculating every Cn
					Czero -= (CD[j][z])*pair[j][z-1][0];	// Calculating Czero
					result += CD[j][z]*ii[i][z-1];
				}
				result += Czero + CD[j][D[j]]*ii[i][D[j]-1]; // Add last Cd*ii[last]
				std::cout << ref_name[i] << '[';
				for(z = 0; z <= D[j]-2; z++)
					std::cout << ii[i][z] << ", ";
				std::cout << (ii[i][D[j]-1]) << "] = " << result << std::endl;		
				break;
			}
		}
	}

	// Collecting garbage
	for(i = 0; i < na; i++)
	{
		delete [] array_name[i];
		delete [] CD[i];
		for(j = 0; j < D[i]; j++)
			delete [] pair[i][j];
		delete [] pair[i];

	}

	delete [] array_name;
	delete [] B;
	delete [] CD;
	delete [] D;
	delete [] pair;

	for(i = 0; i < nar; i++)
	{
		delete [] ref_name[i];
		delete [] ii[i];
	}
	delete [] ref_name;
	delete [] ii; 

	return 0;
} 
