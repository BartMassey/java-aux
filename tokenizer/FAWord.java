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
