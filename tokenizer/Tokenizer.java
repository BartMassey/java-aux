/*
 * Copyright © 1996-2009 Bart Massey
 * ALL RIGHTS RESERVED
 * [This program is licensed under the "MIT License"]
 * Please see the file ../COPYING in the source
 * distribution of this software for license terms.
 */

package aux.tokenizer;

public class Tokenizer {
    private char data[];
    private int ndata;
    private int start = 0;
    private FA fa;
	
    private void skip_white() {
	while ((start < ndata) &&
	       ((data[start] == ' ') || (data[start] == '\t')))
	    start++;
    }

    public Tokenizer(String s, FA a) {
	data = s.toCharArray();
	ndata = data.length;
	fa = a;
    }

    public Tokenizer(char d[], FA a) {
	data = d;
	ndata = data.length;
	fa = a;
    }

    public int countTokens()
      throws FAFailException {
	Tokenizer t = new Tokenizer(data, fa);
	int n = 0;
	while (t.nextToken() != null)
	    n++;
	return n;
    }
    
    public boolean hasMoreTokens() {
	skip_white();
	return start < ndata;
    }
    
    public String nextToken()
      throws FAFailException {
	skip_white();
	if (start >= ndata)
	    return null;
	fa.reset();  // XXX sometimes gratuitous
	int cur = start;
	while (true) {
	    boolean accept = fa.next(data[cur]);
	    if (accept) {
		int off = start;
		start = cur + 1;
		return new String(data, off, cur - off);
	    }
	    cur++;
	    if (cur >= ndata)
		throw new FAFailException("out of data");
	}
    }

    public void newFA(FA a) {
	fa = a;
    }
}
