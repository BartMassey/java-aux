# java-aux
Copyright © 1996 Bart Massey

This is a collection of very old library code I wrote in
Java. Much of it is now superseded by standardly-available
Java functionality, but I have Java code lying around that
relies on it, so I continue to maintain it.

With the introduction of `java.lang.Comparable` to core in
Oracle Java 1.8, it appears that this code no longer works
there. C'est la vie. It seems to compile fine under OpenJDK
1.7, which is what I am using anyway.

There are a million deprecation warnings in this code, mostly
because it is AWT-based and has never been converted to Swing.

To build this code, it is sufficient to say "javac *.java".
See the couple of subdirectories here for notes and
instructions on compiling them.

Javadoc is desperately needed here.

This program is licensed under the "MIT License". Please see
the file COPYING in this distribution for license terms.
