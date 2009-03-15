package aux;

public class StringSplitter {
    private char sep;

    public StringSplitter(char sep) {
	this.sep = sep;
    }

    public String[] split(String s) {
	int l = s.length();
	int n = 0;
	int i;
	for (i = 0; i < l; i++)
	    if (s.charAt(i) == sep)
		n++;
	String result[] = new String[n + 1];
	i = 0;
	int j = 0;
	int k = 0;
	while (true) {
	    while (j < l && s.charAt(j) != sep)
		j++;
	    result[k++] = s.substring(i, j);
	    if (j >= l)
		break;
	    j++;
	    i = j;
	}
	return result;
    }
}
