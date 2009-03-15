/*
 * Copyright © 1996-2009 Bart Massey
 * ALL RIGHTS RESERVED
 * [This program is licensed under the "MIT License"]
 * Please see the file COPYING in the source
 * distribution of this software for license terms.
 */

package aux;

// Heapsort
// ala Sedgewick 1984, p. 136

public class HeapSort {
    private static Comparable elem[];
    private static int n;

    private final static void downheap(int k) {
	Comparable v = elem[k];
	while (k < n / 2) {
	    int j = k + k + 1;
	    if (j < n - 1 && elem[j + 1].notLessThan(elem[j]))
		j++;
	    if (v.notLessThan(elem[j]))
		break;
	    elem[k] = elem[j];
	    k = j;
	}
    	elem[k] = v;
    }
    
    public static void sort(Comparable d[]) {
	elem = d;
	n = elem.length;
	for (int k = elem.length / 2 - 1; k >= 0; --k)
	    downheap(k);
	n = elem.length;
	while (n > 1) {
	    Comparable tmp = elem[0];
	    elem[0] = elem[n - 1];
	    elem[n - 1] = tmp;
	    --n;
	    downheap(0);
	}
    }
}
