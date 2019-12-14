//
//  check_one_line.c
//  三子棋
//
//  Created by Darin Wang on 2017/11/17.
//  Copyright © 2017年 Darin Wang. All rights reserved.
//

#include <stdio.h>
void victory(int p);
int check_one_line(int a[3])
{
    if ((a[0]!=0&a[1]!=0&a[2]!=0)&(a[0]==a[1]&a[1]==a[2]&a[0]==a[2]))
    {
        victory(a[0]);
        return 9; //9 -> game over.
    }
    else
    {
        return 8; //8 -> game goes on.
    }
}
