//
//  turn.c
//  三子棋
//
//  Created by Darin Wang on 2017/11/17.
//  Copyright © 2017年 Darin Wang. All rights reserved.
//

#include <stdio.h>
void turn(int p[1])
{
    if (p[0]==1)
    {
        printf("玩家1的回合。o\n");
    }
    else
    {
        printf("玩家2的回合。x\n");
    }
}
