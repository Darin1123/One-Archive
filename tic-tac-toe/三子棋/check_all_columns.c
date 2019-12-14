//
//  check_all_columns.c
//  三子棋
//
//  Created by Darin Wang on 2017/11/17.
//  Copyright © 2017年 Darin Wang. All rights reserved.
//

#include <stdio.h>
int check_one_column(int n, int a[3], int b[3], int c[3]);
int check_all_columns(int a[3], int b[3], int c[3])
{
    int r1=check_one_column(0,a,b,c);
    int r2=check_one_column(1,a,b,c);
    int r3=check_one_column(2,a,b,c);
    if (r1==9|r2==9|r3==9)
    {
        return 9;
    }
    else
    {
        return 8;
    }
}
