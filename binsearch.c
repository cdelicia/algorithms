#include <stdio.h>
#include <stdlib.h>

#define INDEX 1000
#define MAX 2000
#define MAXLINE 12

int binsearch(int x, int v[], int n);
void getnumber(char s[], int lim);
void shellsort(int v[], int n);

int main() {
    int i, value, result;
    char s[MAXLINE];
    int v[INDEX];

    for (i = 0; i < INDEX; i++)
        v[i] = rand() % MAX;
    
    printf("write a number from 0 to %d\n", MAX);
    getnumber(s, MAXLINE);
    if (atof(s) > 2147483647 || atof(s) < -2147483648) {
        printf("The value is out of boundary! Range is from -2147483648 to 2147483647\n");
        return -1;
    } else {
        value = atof(s);
        shellsort(v, INDEX);
        result = binsearch(value, v, INDEX);
        if (result != -1)
            printf("YES! element #%d\n", result);
        else
            printf("NO..\n");
    }
    return 0;    
}

int binsearch(int x, int v[], int n) {
    int low, mid, high;
    low = 0;
    high = n - 1;

    while (low <= high) {
        mid = (low + high) / 2;
        if (x < v[mid])
            high = mid - 1;
        else if (x > v[mid])
            low = mid + 1;
        else
            return mid;
    }
    return -1;
}

void getnumber(char s[], int lim) {
    int c, i;

    for (i = 0; i < lim-1 && (c = getchar()) != EOF && c != '\n'; i++)
        s[i] = c;
    s[i] = '\0';
}

void shellsort(int v[], int n) {
    int i, j, gap, temp;

    for (gap = n/2; gap > 0; gap /= 2) {
        for (i = gap; i < n; i++) {
            for (j = i - gap; j >= 0 && v[j] > v[j+gap]; j -= gap) {
                temp = v[j];
                v[j] = v[j+gap];
                v[j+gap] = temp;
            }
        }
    }
}