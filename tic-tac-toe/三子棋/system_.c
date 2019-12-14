//
//  system_.c
//  三子棋
//
//  Created by Darin Wang on 2017/11/17.
//  Copyright © 2017年 Darin Wang. All rights reserved.
//

#include <stdio.h>
#include <stdio.h>
void game(void);
int quit(void);

void system_(void)
{
    printf("********************************************************\n*        三                子                  棋       *\n********************************************************\n");
    int i;
    printf("欢迎！\n输入1进入游戏。\n输入2退出。\n");
    scanf("%d", &i);
    if (i==1)
    {
        game();
    }
    else if (i==2)
    {
        quit();
    }
    else
    {
        printf("输入1开始\n");
        system_();
    }
}
