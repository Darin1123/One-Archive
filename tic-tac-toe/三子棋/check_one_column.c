//
//  check_one_column.c
//  三子棋
//
//  Created by Darin Wang on 2017/11/17.
//  Copyright © 2017年 Darin Wang. All rights reserved.
//

#include <stdio.h>
void victory(int p);
int check_one_column(int n, int a[3], int b[3], int c[3])
{
    if ((a[n]!=0&b[n]!=0&c[n]!=0)&(a[n]==b[n]&b[n]==c[n]&a[n]==c[n]))
    {
        victory(a[0]);
        return 9;
    }
    else
    {
        return 8;
    }
    
}
