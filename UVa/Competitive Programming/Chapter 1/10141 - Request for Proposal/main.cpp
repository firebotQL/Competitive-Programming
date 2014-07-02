#include <cstdio>
#include <cstring>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
	#endif
}

int main(int argc,char* argv[])
{
	int n, i;
	unsigned long long p, j, iCount = 1;
	int cur_max_req, num_prop_met_req;
	char prop_name[100], best_prop_name[100], dummy[100];
	double prop_price, cur_lowest_price;
	openFile();
	while(scanf("%d %llu\n", &n, &p) != EOF && (n != 0 && p != 0))
	{
		 if(iCount > 1)
			printf("\n");
		 cur_max_req = -1;
		 cur_lowest_price = -1;
		 for(i = 0; i < n; ++i)
			gets(dummy);
		 for(j = 0; j < p; ++j)
		 {
			gets(prop_name);
			scanf("%lf %d\n", &prop_price, &num_prop_met_req);
			if(num_prop_met_req > cur_max_req)
			{
				strcpy(best_prop_name, prop_name);
				cur_lowest_price = prop_price;
				cur_max_req = num_prop_met_req;
			} 
			else if (num_prop_met_req == cur_max_req && 
				cur_lowest_price > prop_price)
				{
					strcpy(best_prop_name, prop_name);
					cur_lowest_price = prop_price;			
				}		
			for(i = 0; i < num_prop_met_req; ++i)
				gets(dummy);
		 }
		printf("RFP #%llu\n%s\n", iCount++, best_prop_name);			
	}
	return 0;
}
