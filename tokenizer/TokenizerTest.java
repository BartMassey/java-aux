import tokenizer.*;

public class TokenizerTest {
    public static void main(String args[]) {
	FA wfa = new FAWord();
	FA ifa = new FAIdent();
	FA vfa = new FAVersNum();
	FA sfa = new FAQString();
	try {
	    Tokenizer t = new Tokenizer(" x? y_ 44.29 \"x\\\"y\" ", wfa);
	    String s[] = new String[4];
	    s[0] = t.nextToken();
	    t.newFA(ifa);
	    s[1] = t.nextToken();
	    t.newFA(vfa);
	    s[2] = t.nextToken();
	    t.newFA(sfa);
	    s[3] = t.nextToken();
	    String x = t.nextToken();
	    if (x != null)
		throw new Error("Oops");
	    for (int i = 0; i < s.length; i++)
		System.out.print("<" + s[i] + ">");
	    System.out.println();
	} catch (FAFailException e) {
	    System.err.println("Failed: " + e);
	    return;
	}
    }
}
