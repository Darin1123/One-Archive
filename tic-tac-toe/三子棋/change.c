//
//  change.c
//  三子棋
//
//  Created by Darin Wang on 2017/11/17.
//  Copyright © 2017年 Darin Wang. All rights reserved.
//

#include <stdio.h>
void change(int p[1])
{
    if (p[0]==1)
    {
        p[0]=2;
    }
    else
    {
        p[0]=1;
    }
}
