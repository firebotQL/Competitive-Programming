#include <math.h>
#include <vector>
#include <cstdio>

// Segment Tree Library
// The segment tree is stored like a heap array
#define RANGE_SUM 0
#define RANGE_MIN 1
#define RANGE_MAX 2

typedef std::vector<int> vi;

vi segment_tree;
// if original array size is N,
// the required segment_tree array 
// length is 2*2^(floor(log2(N))+1);
void init_segment_tree(int N) 
{
	int length = (int)(2 * pow(2.0, floor((log((double)N) / log(2.0)) + 1)));
	printf("length: %d\n", length);
	segment_tree.resize(length, 0);	// resize this vector and fill with 0
}

int main() 
{
	int A[] = {8, 7, 3, 9, 5, 1, 10};
	init_segment_tree(7); //build_segment_tree(RANGE_MIN, A, 1, 0, 6);
}
