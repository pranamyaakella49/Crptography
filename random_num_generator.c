#include <stdio.h>
#include <stdlib.h>
#define LEN 32
int main()
{
int i;
unsigned char *key = ( unsigned char *) malloc ( sizeof ( unsigned char )*LEN);
FILE* random = fopen( "/dev/urandom" , "r" );
fread(key, sizeof ( unsigned char )*LEN, 1 , random); 
for ( i = 0 ; i < LEN ; i ++)
{
printf ( "%.2x" , ( unsigned char ) key [ i ]);
}
fclose(random);
printf("\n");
return 0;
}






