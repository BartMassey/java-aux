/*
 * Copyright © 1996-2009 Bart Massey
 * ALL RIGHTS RESERVED
 * [This program is licensed under the "MIT License"]
 * Please see the file ../COPYING in the source
 * distribution of this software for license terms.
 */

package aux.tokenizer;

public class FAIdent extends FA {
    private static final int FA_NWHITE = 1;
    
    public boolean next(char c)
      throws FAFailException {
	if (boundary(c))
	    return true;
	if (Character.isLetter(c)) {
	    state = FA_NWHITE;
	    return false;
	}
	if (Character.isDigit(c) || c == '_') {
	    if (state == FA_START)
		throw new FAFailException("bad leading char in identifier");
	    state = FA_NWHITE;
	    return false;
	}
	throw new FAFailException("bad char in identifier");
    }
}
