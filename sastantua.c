/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   sastantua.c                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: cdelicia <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/09/26 19:15:17 by cdelicia          #+#    #+#             */
/*   Updated: 2023/05/16 19:46:19 by cdelicia         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <unistd.h>
#include <string.h>
#include <ctype.h>

void ft_putchar(char c) {
	write(1, &c, 1);
}

int ft_atoi(char *str) {
    int result = 0;

    while (*str != '\0') {
		if (!isdigit(*str)) {
			write(1, "accepts digits only. From 1 to 10\n", 35);
			return 0;
		}
        result = result * 10 + (*str++ - '0');
	}
    return (result <= 10) ? result : 0;
}

int calc_base(int size) {
	int floor = 1;
	int width = 1;
	int floor_step = 4;

	while (floor <= size) {
		width += 2 * (2 + floor++);
		width += floor_step;
		if (floor % 2 && floor < size)
			floor_step += 2;
	}
	return width - floor_step;
}

void put_line(int space) {
	int pos = -1;

	while (++pos < space)
		ft_putchar(' ');
}

void put_blocks(int size, int floor, int width, int step) {
	int pos = -1;
	int door = 1 + 2 * ((floor - 1) / 2);
	
	while (++pos < width) {
		if (pos == 0)
			ft_putchar('/');
		else if (pos == width - 1)
			ft_putchar('\\');
		else {
			if (floor == size && pos >= (width - door) / 2
					&& pos < (width + door) / 2 && 2 + floor - step <= door)
				if (door >= 5 && step == 2 + floor - door / 2 - 1
						&& pos == (width + door) / 2 - 2)
					ft_putchar('$');
				else
					ft_putchar('|');
			else
				ft_putchar('*');
		}
	}
}

void sastantua(int size) {
	int	floor = 0;
	int	height;
	int	step;
	int	width = 1;

	if (size < 1) {
		write(1, "enter level of sastantua. From 1 to 10\n", 40);
		return ;
	}
	while (++floor <= size) {
		height = 2 + floor;
		step = -1;
		while (++step < height) {
			width += 2;
			put_line((calc_base(size) - width) / 2);
			put_blocks(size, floor, width, step);
			ft_putchar('\n');
		}
		width += 4 + 2 * ((floor - 2) / 2);
	}
}

int main(int argc, char **argv) {
    if (argc == 2 && strlen(argv[1]) <= 2) {
        sastantua(ft_atoi(argv[1]));
	} else
        write(1, "enter level of sastantua. From 1 to 10\n", 40);
    return 0;
}