#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <cmath>

#define SWAP(x,y) (x^=y, y^=x, x^=y)

#define PI 3.14159265
#define H_PI 1.57079
#define MAX_PREC 1000000000
#define EPS 0.00001

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
}

const char* shapes[] = 
{
	"Square",
	"Rectangle",
	"Rhombus",
	"Parallelogram",
	"Trapezium",
	"Ordinary Quadrilateral"
};

inline int find_min(int* x, int* y)
{
	int minIndex(0), j;
	for(j = 1; j < 4; ++j)
	{
		if (y[minIndex] > y[j])
			minIndex = j;
		else if (y[minIndex] == y[j])
			if (x[minIndex] > x[j])
				minIndex = j;
	}
	return minIndex;
}

inline int ccw(int x1, int x2, int x3, int y1, int y2, int y3)
{
    return (x2 - x1)*(y3 - y1) - (y2 - y1)*(x3 - x1);
}

inline void sort_ccw(int* x, int* y, int minIndex)
{
	bool bSort(true);
	int j, xa(x[minIndex]), ya(y[minIndex]);
	long long rad[4];
	rad[0] = 0;
	if (minIndex != 0)
	{
		SWAP(x[minIndex], x[0]);
		SWAP(y[minIndex], y[0]);
	}

	for(j = 1; j < 4; ++j)
	{
		rad[j] = MAX_PREC*atan2((long double)y[j]-ya, x[j]-xa);
	}

	// Simple bublesort
	while(bSort)
	{
		bSort = false;
		for(j = 1; j < 3; ++j)
		{
			if (rad[j] > rad[j+1])
			{
				bSort = true;
				SWAP(x[j], x[j+1]);
				SWAP(y[j], y[j+1]);
				SWAP(rad[j], rad[j+1]);
			}
		}
	}
}

inline int cross_product(int ax, int ay, int bx, int by)
{
	return ax*by-ay*bx;
}

inline int dot_product(int ax, int ay, int bx, int by)
{
	return ax*bx+ay*by;
}

inline int determine_by_angle(long long* angle, int a, int b)
{
	int j, iCount(0);
	for(j = 0; j < 3; ++j)
			if (angle[j] != angle[j+1])	// If equals 90 degrees
				iCount++;
	if (iCount == 0)
			return a;	
	if (iCount == 3)
			return b;	
	return 5;
}

inline int deduce_shape(int* x, int* y)
{
	int j, x_prod1, x_prod2, vec[4][2], edge[4], dot[4];
	long long angle[4];
	for(j = 0; j < 3; j++)
	{
		vec[j][0] = x[j+1]-x[j];
		vec[j][1] = y[j+1]-y[j];
		edge[j] = vec[j][0]*vec[j][0] + vec[j][1]*vec[j][1];
	}
	vec[3][0] = x[0]-x[3];
	vec[3][1] = y[0]-y[3];
	
	edge[3] = vec[3][0]*vec[3][0] + vec[3][1]*vec[3][1];
	// Finding all angles in rad 
	dot[0] = dot_product(vec[0][0], vec[0][1], vec[1][0], vec[1][1]);
	dot[1] = dot_product(vec[1][0], vec[1][1], vec[2][0], vec[2][1]);
	dot[2] = dot_product(vec[2][0], vec[2][1], vec[3][0], vec[3][1]);
	dot[3] = dot_product(vec[3][0], vec[3][1], vec[0][0], vec[0][1]);
	for(j = 0; j < 4; ++j)
		if (dot[j] < 0)
			dot[j]*=dot[j]*(-1);
	angle[0] = dot[0]*edge[2]*edge[3];
	angle[1] = dot[1]*edge[0]*edge[3];
	angle[2] = dot[2]*edge[0]*edge[1];
	angle[3] = dot[3]*edge[1]*edge[2];
//	printf("%lld %lld %lld %lld\n", angle[0], angle[1], angle[2], angle[3]);

	if (edge[0] == edge[1] &&
		edge[1] == edge[2] &&
		edge[2] == edge[3])
		return determine_by_angle(angle, 0, 2);	// Rombus |  Sqaure

	if (edge[0] == edge[2] && edge[1] == edge[3])
		return determine_by_angle(angle, 1, 3);	// Parallelogram |  Rectangle	

	// one of cross products AxB = ax*by-ay*by should be zero 
	x_prod1 = cross_product(vec[0][0], vec[0][1], vec[2][0], vec[2][1]);
	x_prod2 = cross_product(vec[3][0], vec[3][1], vec[1][0], vec[1][1]);
	if (!x_prod1 || !x_prod2)
		return 4;

	return 5;
}

int main(int argc,char* argv[])
{
	openFile();
	int n, i, j;
	int x[4], y[4];
	scanf("%d\n", &n);
	for(i = 1; i <= n; ++i)
	{
		for(j = 0; j < 4; ++j)
			scanf("%d %d\n", &x[j], &y[j]);
		sort_ccw(x, y, find_min(x,y));
		printf("Case %d: %s\n", i, shapes[deduce_shape(x,y)]);
			
	}
	return 0;
} 
