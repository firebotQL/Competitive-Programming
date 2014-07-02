#include <cstdio>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
	#endif
}

int main(int argc,char* argv[])
{
	int n, i;
	unsigned long long p, j;
	int best_prop_nr;
	int cur_max_req;
	double cur_lowest_price;
	char** req_names;
	char** prop_names;
	char*** prop_met_req_names; 
	double* prop_price;
	int num_prop_met_req;
	openFile();
	while(scanf("%d %llu\n", &n, &p) != EOF && (n == 0 && p == 0))
	{
		 req_names = new char*[n];
		 for(i = 0; i < n; ++i)
		 {
			req_names[i] = new char[80];
			scanf("%s\n", req_names[i]);
		 }
		 prop_names = new char*[p];
		 prop_price = new double[p];
		 prop_met_req_names = new char**[p];
		 for(j = 0; j < p; ++j)
		 {
			prop_names[j] = new char[80];
			scanf("%s\n", prop_names[j]);
			scanf("%lf %d\n", &prop_price[j], &num_prop_met_req);
			prop_met_req_names[j] = new char*[num_prop_met_req];
			for(i = 0; i < num_prop_met_req; ++i)
			{
				prop_met_req_names[j][i] = new char[80];
				scanf("%s\n", prop_met_req_names[j][i]);
			}
			
			
		 }
			
	}
	return 0;
}
