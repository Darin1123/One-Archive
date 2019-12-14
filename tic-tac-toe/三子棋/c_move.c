//
//  c_move.c
//  三子棋
//
//  Created by Darin Wang on 2017/11/17.
//  Copyright © 2017年 Darin Wang. All rights reserved.
//

#include <stdio.h>
void print_field(int line_1[3], int line_2[3], int line_3[3]);
void move_(int a[3], int b[3], int c[3], int p[1], int state[1]);

void c_move(int a[3], int b[3], int c[3], int p[1], int state[1])
{
    move_(a,b,c,p, state);
    print_field(a, b, c);
}
