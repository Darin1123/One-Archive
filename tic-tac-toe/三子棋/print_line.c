//
//  print_line.c
//  三子棋
//
//  Created by Darin Wang on 2017/11/17.
//  Copyright © 2017年 Darin Wang. All rights reserved.
//

#include <stdio.h>

void print_line(int line[3])
{
    for (int i=0; i<3; i++)
    {
        if (line[i]==0)
        {
            printf("*");
        }
        else if (line[i]==1)
        {
            printf("o");
        }
        else
        {
            printf("x");
        }
    }
    printf("\n");
}
