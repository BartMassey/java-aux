package aux.tokenizer;

public abstract class FA {
    protected static final int FA_START = 0;
    protected int state = FA_START;

    protected boolean boundary(char c)
      throws FAFailException {
	if (c == ' ' || c == '\t') {
	    if (state == FA_START)
		throw new FAFailException("leading whitespace");
	    return true;
	}
	return false;
    }
    
    public void reset() {
	state = FA_START;
    }

    public abstract boolean next(char c) throws FAFailException;
}
