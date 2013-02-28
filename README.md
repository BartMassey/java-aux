# java-aux
Copyright © 1996 Bart Massey

This is a collection of very old library code I wrote in
Java--mostly circa 1996-1997. Much of it is now superseded
by standardly-available Java functionality, but I have Java
code lying around that relies on it, so I continue to
maintain it.

With the introduction of `java.lang.Comparable` to core in
Java, some changes were needed to keep using my ancient and
unfortunately-named `Comparable` class. C'est la
vie. Currently the code seems to compile fine under OpenJDK
1.7, which is what I am using anyway.

There are a million deprecation warnings in this code, mostly
because it is AWT-based and has never been converted to Swing.

To build this code in a way that is usable by others, you
will need to go up a level, make sure your code is in a
directory named `aux`, and say

        javac aux/*.java aux/tokenizer/*.java

You can then use

        jar -c aux/*.class aux/tokenizer/*.class >aux.jar

to make a jarfile.  See also the couple of subdirectories
here for notes and instructions on compiling them. Arguably,
the package names should be changed to conform to modern
conventions ala `com.bart-massey.aux` but (a) no one cares
and (b) ugh.

Javadoc is desperately needed here. For now, here's a description
of the files, at least:

  * `BoxLayout.java`: Box layout class for AWT.  Still nicer than the one that ships with Swing IMHO.
  * `Comparable.java`:  Completely outdated interface subsumed by `Ordered` and eventually by `java.lang.Comparable` in newer Java.
  * `ControlPanel.java`: Layout class for AWT.  Implements a single panel with a frame and title.
  * `DictionaryCompare.java`: Implementation of completely outdated `Comparable` interface for dictionary sort order.
  * `Digits.java`: Component class for AWT. Displays a multi-digit number.
  * `HeapSort.java`: Simple heap sort of arrays.  Depends on completely outdated `Comparable` interface---needs fixing.
  * `ImageCanvas.java`: Component class for AWT.  Displays an image.
  * `StringSplitter`.java: Splits a String into an array at occurences of a given separator character.
  * `Table.java`: Table layout class for AWT.  Layout is a LaTeX-style table with components in cells.
  * `tokenizer/*.java`: Directory contains a simple input tokenizer framework with various tokenizers.  See source for details.
  * `tests/SortTest.java`: Currently just a test of `HeapSort.java`.

This program is licensed under the "MIT License". Please see
the file COPYING in this distribution for license terms.
