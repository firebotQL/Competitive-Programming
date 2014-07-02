/* 
* File:   main.cpp
* Author: viaduk
*
* Created on July 26, 2010, 8:34 PM
*/

#include <stdio.h>
#include <cmath>
#include <vector>
#include <iostream>
#include <algorithm>
#include <set>

using namespace std;

class FirstCompare {
	int i;
public:
	FirstCompare(int j) : i(j) { }
	bool operator()(std::pair<int, int> p)
	{
		return i==p.first;
	}
};

vector<pair<long, int> > factorize(long n)
{
	long i = 2;
	vector<pair<long, int> > iPrimeFactors;
	vector<pair<long, int> >::iterator it;
	if (n < 2) return iPrimeFactors;

	while(i <= n)
	{
		if (n % i == 0)
		{
			if ((it = find_if(iPrimeFactors.begin(), iPrimeFactors.end(), FirstCompare(i))) != iPrimeFactors.end())
				(*it).second++;
			else
				iPrimeFactors.push_back(make_pair(i, 1));
			n /= i;
		}
		else 
		{
			if (i==2) i=3;
			else i += 2;
		}
	}	
	return iPrimeFactors;
}

long lcm(long a, long b)
{
	vector<pair<long, int> > iPrimeFactorsA = factorize(a);
	vector<pair<long, int> > iPrimeFactorsB = factorize(b);
	vector<pair<long, int> >::iterator it;
	long answer(1);
	for(long i = 0; i < iPrimeFactorsA.size(); i++)
	{
		if ((it = find_if(iPrimeFactorsB.begin(), iPrimeFactorsB.end(), FirstCompare(iPrimeFactorsA[i].first))) != iPrimeFactorsB.end())
		{
			if ((*it).second < iPrimeFactorsA[i].second)
				(*it) = iPrimeFactorsA[i];
		} else	{
			iPrimeFactorsB.push_back(iPrimeFactorsA[i]);
		}
	} 
	for(long i = 0; i < iPrimeFactorsB.size(); i++)
		answer *= (long)pow(iPrimeFactorsB[i].first, (double)iPrimeFactorsB[i].second);
	return answer; 
}

int main(int argc, char** argv) {

	long answer(2);
	for(long i = 3; i < 21; i++)
		answer = lcm(answer, i);
	cout << answer;
	cin >> answer;
	return (EXIT_SUCCESS);
}

