#include <cstdio>
#include <cstdlib>
#include <stack>
#include <vector>

// Types
#define LEFT_PARANTHESIS 1
#define RIGHT_PARANTHESIS 2
#define OPERATOR 3
#define OPERAND 4

// Priorities
#define RANK1 1
#define RANK2 2
#define RANK3 3
#define NONE -5

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
	freopen("test.out", "w", stdout);
#endif
}

int getprecedence(char sym)
{
	switch(sym)
	{
	case '(':
		return RANK1;
	case '+':
	case '-':
		return RANK2;
	case '*':
	case '/':
		return RANK3;
	default:
		return NONE;
	}
}

int gettype(char sym)
{
	switch(sym)
	{
	case '(':
		return LEFT_PARANTHESIS;
	case ')':
		return RIGHT_PARANTHESIS;
	case '+':
	case '-':
	case '*':
	case '/':
		return OPERATOR;
	default:
		return OPERAND;
	}
}

int main(int argc, char* argv[])
{
	int N, type, precedence;
	char line[3], next, symbol;
	std::stack<char> stk;
	std::vector<char> postfix;
	openFile();
	scanf("%d\n\n", &N);
	while (N--)
	{
		while(fgets(line, 3, stdin) && line[0] != '\n')
		{
			symbol = line[0];
			type = gettype(symbol);
			switch(type)
			{
			case LEFT_PARANTHESIS:
				stk.push(symbol);
				break;
			case RIGHT_PARANTHESIS:
				while((next = stk.top()) != '(')
				{
					stk.pop();
					postfix.push_back(next);
				}
				stk.pop();
				break;
			case OPERAND:
				postfix.push_back(symbol);
				break;
			case OPERATOR:
				precedence = getprecedence(symbol);
				while(stk.size() && precedence <= getprecedence(stk.top()))
				{
					postfix.push_back(stk.top());
					stk.pop();
				}
				stk.push(symbol);

			}	
		}

		while(stk.size())
		{
			postfix.push_back(stk.top());
			stk.pop();
		}
		for(std::vector<char>::size_type i = 0; i < postfix.size(); ++i)
			printf("%c", postfix[i]);
		printf("\n");
		postfix.clear();

		if (N > 0)
			printf("\n");
	}
	return 0;
}
