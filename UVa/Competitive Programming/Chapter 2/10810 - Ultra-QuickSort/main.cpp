#include <cstdio>
#include <vector>
#include <string>
#include <algorithm>
#include <iostream>
#include <ctime>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
	//freopen("test.out", "w", stdout);
#endif
}

void merge(std::vector<int>& left, std::vector<int>& right, long long& count,  std::vector<int>& result)
{
	int i(0), j(0);
	while (left.size() != i && right.size() != j)
	{
			if (left[i] < right[j])
				result.push_back(left[i++]);
			else
			{
				result.push_back(right[j++]);
				count += left.size()-i;
			}
	}

	if (left.size() != i)
	{
		for(; i < left.size(); ++i)
			result.push_back(left[i]);
	}
		//result.insert(result.begin()+result.size(), left.begin()+i, left.end());
	
	if (right.size() != j)
	{
		for(; j < right.size(); ++j)
			result.push_back(right[j]);
	}
		//result.insert(result.begin()+result.size(), right.begin()+j, right.end());

	//return result;
}

std::vector<int> merge_sort(std::vector<int>& sequence, long long& count)
{
	if (sequence.size() <= 1)
		return sequence;
	std::vector<int> left, right, result;

	int middle = sequence.size() / 2;
	int i;

	for(i = 0; i < middle; ++i)
		left.push_back(sequence[i]);
	for(i = middle; i < sequence.size(); ++i)
		right.push_back(sequence[i]);

	left = merge_sort(left, count);
	right = merge_sort(right, count);
	merge(left, right, count, result);
	return result;
}

int main(int argv,char* argc[])
{
	openFile();
	int n,e,size;
	long long count;
	std::vector<int> sequence;
	while(scanf("%d", &n) && n > 0)
	{
		sequence.clear();
		count = 0;
		while(n--)
		{
			scanf("%d", &e);
			sequence.push_back(e);
		}
		
		merge_sort(sequence, count);
		printf("%lld\n", count);
	}
	return 0;
}
