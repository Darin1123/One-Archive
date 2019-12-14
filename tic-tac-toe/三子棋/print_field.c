//
//  print_field.c
//  三子棋
//
//  Created by Darin Wang on 2017/11/17.
//  Copyright © 2017年 Darin Wang. All rights reserved.
//

#include <stdio.h>
void print_line(int line[3]);
void print_field(int line_1[3], int line_2[3], int line_3[3])
{
    print_line(line_1);
    print_line(line_2);
    print_line(line_3);
}
