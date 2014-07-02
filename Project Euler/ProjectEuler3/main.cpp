#include <iostream>
#include <math.h>
void main( int argc, char* argv[] )
{
	double dTemp;
	for( int i = 2; i < floor(sqrt(600851475143.0) + 0.5); i++)
	{
		dTemp = 600851475143.0/i;
		if (dTemp == floor(dTemp + 0.5))
			printf("%d\n", i);
	}
}