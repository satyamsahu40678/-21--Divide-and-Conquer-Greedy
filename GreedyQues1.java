// Q1. Find the minimum sum of Products of two arrays of the same size, given that k modifications 
// are allowed on the first array. In each modification, one array element of the first array can either 
// be increased or decreased by 2.
// Input
// a[] = {1, 2, -3}
// b[]  = {-2, 3, -5}
// k = 5
// Output 
// -31

import java.math.*;

public class GreedyQues1 {
    static int minproduct(int a[], int b[], int n, int k) {
        int diff = 0, res = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            int pro = a[i] * b[i];
            res = res + pro;
            if (pro < 0 && b[i] < 0)
                temp = (a[i] + 2 * k) * b[i];

            else if (pro < 0 && a[i] < 0)
                temp = (a[i] - 2 * k) * b[i];
            else if (pro > 0 && a[i] < 0)
                temp = (a[i] + 2 * k) * b[i];
            else if (pro > 0 && a[i] > 0)
                temp = (a[i] - 2 * k) * b[i];

            int d = Math.abs(pro - temp);
            if (d > diff)
                diff = d;
        }

        return res - diff;
    }

    public static void main(String[] args) {
        int a[] = { 2, -3, 4, 6, 9 };
        int b[] = { 1, 4, -2, -3, 7 };
        int n = 5, k = 3;
        System.out.println(minproduct(a, b, n, k));
    }

}
