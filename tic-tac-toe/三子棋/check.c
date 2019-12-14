//
//  check.c
//  三子棋
//
//  Created by Darin Wang on 2017/11/17.
//  Copyright © 2017年 Darin Wang. All rights reserved.
//

#include <stdio.h>
int check_all_lines(int a[3], int b[3], int c[3]);
int check_all_columns(int a[3], int b[3], int c[3]);
int cross1(int a[3], int b[3], int c[3]);
int cross2(int a[3], int b[3], int c[3]);
int draw(int a[3], int b[3], int c[3]);

int check(int a[3], int b[3], int c[3])
{
    int o1=check_all_lines(a,b,c);
    int o2=check_all_columns(a,b,c);
    int o3=cross1(a,b,c);
    int o4=cross2(a,b,c);
    if (o1==9|o2==9|o3==9|o4==9)
    {
        return 9;
    }
    else
    {
        return 8;
    }
}
