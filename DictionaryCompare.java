package aux;

class StringIndex {
    char c;
    int i;

    StringIndex(char c, int i) {
	this.c = c;
	this.i = i;
    }
}

public class DictionaryCompare {
    
    private static final StringIndex next_char(String s, int i, int n) {
	char c = '?';
	while(i < n) {
	    c = s.charAt(i);
	    if (Character.isSpace(c)) {
		while (true) {
		    if (i >= n) {
			c = ' ';
			break;
		    }
		    c = s.charAt(i);
		    if (!Character.isSpace(c)) {
			--i;
			c = ' ';
			break;
		    }
		    i++;
		}
	    }
	    if (Character.isUpperCase(c))
		c = Character.toLowerCase(c);
	    if (!Character.isLowerCase(c) && c != ' ') {
		i++;
		continue;
	    }
	    break;
	}
	if (i >= n)
	    c = '?';
	return new StringIndex(c, i);
    }
		
    public static byte compare(String s1, String s2) {
	int s1s = s1.length();
	int s2s = s2.length();
	int i1 = 0;
	int i2 = 0;
	while (i1 < s1s && i2 < s2s) {
	    // set up c1
	    StringIndex si1 = next_char(s1, i1, s1s);
	    char c1 = si1.c;
	    i1 = si1.i;
	    // System.out.println("c1 = " + c1 + "  i1 = " + i1);
	    // set up c2
	    StringIndex si2 = next_char(s2, i2, s2s);
	    char c2 = si2.c;
	    i2 = si2.i;
	    // System.out.println("c2 = " + c2 + "  i2 = " + i2);
	    // check for wrap
	    if (c1 == '?') {
		if (c2 == '?')
		    return 0;
		else
		    return -1;
	    }
	    if (c2 == '?')
		return 1;
	    // compare chars
	    if (c1 == ' ' && c2 != ' ')
		return -1;
	    if (c2 == ' ' && c1 != ' ')
		return 1;
	    if (c1 < c2)
		return -1;
	    if (c1 > c2)
		return 1;
	    i1++;
	    i2++;
	}
    	if (i2 < s2s)
	    return -1;
	if (i1 < s1s)
	    return 1;
	return 0;
    }

    public static void main(String argv[]) {
	String sign[] = { " < ", " == ", " > " };
        System.out.println(argv[0] +
    		       sign[compare(argv[0], argv[1]) + 1]
    		       + argv[1]);
    }
}
