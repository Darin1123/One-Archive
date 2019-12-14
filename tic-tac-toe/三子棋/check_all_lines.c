//
//  check_all_lines.c
//  三子棋
//
//  Created by Darin Wang on 2017/11/17.
//  Copyright © 2017年 Darin Wang. All rights reserved.
//

#include <stdio.h>
int check_one_line(int a[3]);
int check_all_lines(int a[3], int b[3], int c[3])
{
    int r1=check_one_line(a);
    int r2=check_one_line(b);
    int r3=check_one_line(c);
    if (r1==9|r2==9|r3==9)
    {
        return 9;
    }
    else
    {
        return 8;
    }
}
