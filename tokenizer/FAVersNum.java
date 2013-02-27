/*
 * Copyright © 1996-2009 Bart Massey
 * ALL RIGHTS RESERVED
 * [This program is licensed under the "MIT License"]
 * Please see the file COPYING in the source
 * distribution of this software for license terms.
 */

package aux.tokenizer;

public class FAVersNum extends FA {
    private static final int FA_MAJOR = 1;
    private static final int FA_MINOR1 = 2;
    private static final int FA_MINOR2 = 3;
    
    public boolean next(char c)
      throws FAFailException {
	if (boundary(c)) {
	    if (state == FA_MINOR2)
		return true;
	    throw new FAFailException("incomplete version number");
	}
	switch (state) {
	case FA_START:
	    if (Character.isDigit(c)) {
		if (c == '0')
		    throw new
		      FAFailException("leading zero in version number");
		state = FA_MAJOR;
		return false;
	    }
	    break;
	case FA_MAJOR:
	    if (Character.isDigit(c))
		return false;
	    if (c == '.') {
		state = FA_MINOR1;
		return false;
	    }
	    break;
	case FA_MINOR1:
	    if (Character.isDigit(c)) {
		state = FA_MINOR2;
		return false;
	    }
	    break;
	case FA_MINOR2:
	    if (Character.isDigit(c))
		return false;
	    break;
	}
	if (c == '.')
	    throw new FAFailException("unexpected dot in version number");
	throw new FAFailException("bad char in version number");
    }
}
