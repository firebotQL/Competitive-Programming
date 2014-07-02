#include <iostream>
#include <string>
#include <sstream>


long reverse(long n)
{
	long reversed = 0;

	while(n > 0)
	{
		reversed = reversed*10 + n % 10;
		n = n/10;
	}

	return reversed;
}

int main()
{	
	long number;
	long biggestPalindrome(-1);
	for(long i = 999; i >= 100; --i)
		for(long j = 999; j >= 100; --j)
		{
			number = i*j;
			if (reverse(number) == number && number > biggestPalindrome)
				biggestPalindrome = number;
		}
	std::cout << biggestPalindrome << std::endl;
	std::cin >> biggestPalindrome;
	return 0;
}
