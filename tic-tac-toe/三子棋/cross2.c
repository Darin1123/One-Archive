//
//  cross2.c
//  三子棋
//
//  Created by Darin Wang on 2017/11/17.
//  Copyright © 2017年 Darin Wang. All rights reserved.
//

#include <stdio.h>
void victory(int p);
int cross2(int a[3], int b[3], int c[3])
{
    int A=a[2];
    int B=b[1];
    int C=c[0];
    if ((A!=0&B!=0&C!=0)&(A==B&A==C&B==C))
    {
        victory(a[2]);
        return 9;
    }
    else
    {
        return 8;
    }
}
