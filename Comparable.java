/*
 * Copyright © 1996-2009 Bart Massey
 * ALL RIGHTS RESERVED
 * [This program is licensed under the "MIT License"]
 * Please see the file COPYING in the source
 * distribution of this software for license terms.
 */

package aux;

public interface Comparable {
    public boolean notLessThan(Comparable c);
    public boolean equals(Comparable c);
}
