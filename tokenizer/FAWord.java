/*
 * Copyright © 1996-2009 Bart Massey
 * ALL RIGHTS RESERVED
 * [This program is licensed under the "MIT License"]
 * Please see the file ../COPYING in the source
 * distribution of this software for license terms.
 */

package aux.tokenizer;

public class FAWord extends FA {
    private static final int FA_NWHITE = 1;
    
    public boolean next(char c)
      throws FAFailException {
	if (boundary(c))
	    return true;
	state = FA_NWHITE;
	return false;
    }
}
