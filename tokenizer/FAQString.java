/*
 * Copyright © 1996-2009 Bart Massey
 * ALL RIGHTS RESERVED
 * [This program is licensed under the "MIT License"]
 * Please see the file ../COPYING in the source
 * distribution of this software for license terms.
 */

package aux.tokenizer;

public class FAQString extends FA {
    private static final int FA_INSTRING = 1;
    private static final int FA_BACKSLASH = 2;
    private static final int FA_ATEND = 3;
    
    public boolean next(char c)
      throws FAFailException {
	if (boundary(c)) {
	    if (state == FA_ATEND)
		return true;
	    throw new FAFailException("incomplete string");
	}
	switch (state) {
	case FA_START:
	    if (c != '"')
		throw new FAFailException("not a quoted string");
	    state = FA_INSTRING;
	    return false;
	case FA_INSTRING:
	    switch(c) {
	    case '\\':
		state = FA_BACKSLASH;
		return false;
	    case '"':
		state = FA_ATEND;
		return false;
	    }
	    return false;
	case FA_BACKSLASH:
	    switch(c) {
	    case '"':
		state = FA_INSTRING;
		return false;
	    }
	    throw new FAFailException("unknown backslash escape in string");
	case FA_ATEND:
	    throw new FAFailException("trailing garbage in string");
	}
	throw new FAFailException("internal string parse error");
    }
}
