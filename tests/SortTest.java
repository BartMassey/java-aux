/*
 * Copyright © 1996-2009 Bart Massey
 * ALL RIGHTS RESERVED
 * [This program is licensed under the "MIT License"]
 * Please see the file COPYING in the source
 * distribution of this software for license terms.
 */

import aux.*;
import DES.*;

class CompInt implements aux.Comparable {
    private int i;

    CompInt(int i) {
	this.i = i;
    }
    
    public boolean notLessThan(aux.Comparable j) {
	return i >= ((CompInt) j).i;
    }
    public boolean equals(aux.Comparable j) {
	return i == ((CompInt) j).i;
    }

    int intValue() {
	return i;
    }

}

public class SortTest {
    public static void main(String argv[]) {
	int nnumbers = (new Integer(argv[0])).intValue();
	CompInt numbers[] = new CompInt[nnumbers];
	if (false) {
	    DESRandom prng = new DESRandom((new Long(argv[1])).longValue());
	    for (int i = 0; i < numbers.length; i++)
		numbers[i] = new CompInt(prng.nextInt());
	} else {
	    for (int i = 0; i < numbers.length; i++)
		numbers[i] = new CompInt(numbers.length - i);
	}
	HeapSort.sort(numbers);
	if (false) {
	    for (int i = 0; i < numbers.length; i++)
		System.out.println(numbers[i].intValue());
	}
    }
}
