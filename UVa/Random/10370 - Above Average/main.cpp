#include <cstdio>
#include <vector>

using namespace std;

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

	
int main(int argc, char* argv[])
{
	int C, N, sum, grade, count;
	double avg;
	openFile();
	scanf("%d\n", &C);
	vector<int> marks;
	while(C--)
	{
		scanf("%d ", &N);
		marks.clear();
		count = 0;
		sum = 0;
		while(N--)
		{
			scanf("%d\n", &grade);
			sum += grade;
			marks.push_back(grade);
		}

		avg = (double)sum/marks.size();

		for(vector<int>::iterator it = marks.begin(); it != marks.end(); ++it)
			if (*it > avg)
				count++;

		printf("%.3f%%\n", 100.0*count/marks.size());
	}
	return 0;
}
