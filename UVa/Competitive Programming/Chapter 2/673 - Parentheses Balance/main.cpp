#include <cstdio>
#include <cstdlib>
#include <stack>
#include <cstring>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

int main(int argc, char* argv[])
{
	openFile();
	long long N;
	std::stack<char> par;
	char str[130];
	scanf("%lld\n", &N);
	int i, str_length;
	while(N-- && fgets(str, 130, stdin))
	{
		str_length = strlen(str);
		for(i = 0; i < str_length; ++i)
			if (str[i] == '(' || str[i] == '[')
				par.push(str[i]);
			else 
			{
				if (str[i] == ')' && par.size() && par.top() == '(')
					par.pop();
					else 
					{
						if (str[i] == ']' && par.size() && par.top() == '[')
							par.pop();
							else
							break;
					}
			}
		if (i+1 != str_length || par.size())
			printf("No\n");
		else
			printf("Yes\n");
					
		while(par.size())
			par.pop();
	}
	return 0;
}
