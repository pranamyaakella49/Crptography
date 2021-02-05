#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define KEYSIZE 16
int main ()
{
int i,n,j;
char key [ KEYSIZE ];
FILE * fptr;
char str[100];
char fname[20];
char string[100];
printf(" Input the file name to be opened : ");
scanf("%s",fname);
fptr = fopen(fname, "a"); 
for(j=1524013729; j<=1524020929; j++)
{
srand (j);
for ( i = 0 ; i < KEYSIZE ; i ++) 
{
key [ i ] = rand () % 256 ;
fprintf ( fptr,"%.2x" , ( unsigned char ) key [ i ]);
if (i==KEYSIZE-1)
fprintf ( fptr, "\n");
}
}
return 0;
}
