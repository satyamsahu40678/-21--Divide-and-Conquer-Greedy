// Q5. An interval is represented as a combination of start time and end time. Given a set of 
// intervals, check if any two intervals intersect. 
// Input1
// arr[] = {{1, 3}, {5, 7}, {2, 4}, {6, 8}}
// Output1
// Yes
// Explaination
// The intervals {1, 3} and {2, 4} overlap
// Input2
// arr[] = {{1, 3}, {7, 9}, {4, 6}, {10, 13}}
// Output2
// No

public class DNCQues5 {
    // An interval has start time and end time
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            super();
            this.start = start;
            this.end = end;
        }
    };

    static boolean isIntersect(Interval arr[], int n) {

        int maxelement = 0;

        // Find the overall maximum element
        for (int i = 0; i < n; i++) {
            if (maxelement < arr[i].end)
                maxelement = arr[i].end;
        }

        // Initialize an array of size maxelement
        int[] maxarr = new int[maxelement + 1];
        for (int i = 0; i < n; i++) {

            // starting point of the interval
            int x = arr[i].start;

            // end point of the interval
            int y = arr[i].end;
            maxarr[x]++;
            maxarr[y]--;
        }
        for (int i = 1; i <= maxelement; i++) {
            // Calculating the prefix Sum
            maxarr[i] += maxarr[i - 1];

            // Overlap
            if (maxarr[i] > 1)
                return true;
        }

        // If we reach here, then no Overlap
        return false;
    }

    public static void main(String[] args) {
        Interval arr1[] = { 
            new Interval(1, 3), 
            new Interval(7, 9), 
            new Interval(4, 6), 
            new Interval(10, 13) 
        };
        int n1 = arr1.length;
        if (isIntersect(arr1, n1))
            System.out.print("Yes\n");
        else
            System.out.print("No\n");
    }
}
