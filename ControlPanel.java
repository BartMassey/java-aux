/*
 * Copyright © 1996-2009 Bart Massey
 * ALL RIGHTS RESERVED
 * [This program is licensed under the "MIT License"]
 * Please see the file COPYING in the source
 * distribution of this software for license terms.
 */

package aux;

import java.awt.*;

public class ControlPanel extends Panel implements LayoutManager {
    private Label title;
    private Component contents;

    public ControlPanel(String name, Component contents) {
	this.title = new Label(name, Label.CENTER);
	this.contents = contents;
	setLayout(this);
	add(title);
	add(contents);
    }

    public void paint(Graphics g) {
	Dimension s = size();
	g.drawRect(2, 2, s.width - 4, s.height - 4);
	super.paint(g);
    }
    
    public Insets insets() {
	return new Insets(4,4,4,4);
    }

    private static final int max(int a, int b) {
	if (b > a)
	    return b;
	return a;
    }

    // LayoutManager methods
    public Dimension preferredLayoutSize(Container c) {
	Dimension ts = title.preferredSize();
	Dimension cs = contents.preferredSize();
	Dimension as = new Dimension(max(ts.width, cs.width),
			     ts.height + cs.height);
	Insets i = c.insets();
	as.width += i.left + i.right;
	as.height += i.top + i.bottom;
	return as;
    }
    
    public Dimension minimumLayoutSize(Container c) {
	Dimension ts = title.minimumSize();
	Dimension cs = contents.minimumSize();
	Dimension as = new Dimension(max(ts.width, cs.width),
			     ts.height + cs.height);
	Insets i = c.insets();
	as.width += i.left + i.right;
	as.height += i.top + i.bottom;
	return as;
    }

    public void layoutContainer(Container c) {
	Dimension s = c.size();
	Dimension as = preferredLayoutSize(c);
	Dimension ts, cs;
	if (as.width > s.width || as.height > s.height) {
	    ts = title.minimumSize();
	    cs = contents.minimumSize();
	} else {
	    ts = title.preferredSize();
	    cs = contents.preferredSize();
	}
	Insets i = c.insets();
	int tx = max(0, s.width - ts.width - i.left - i.right) / 2;
	int cx = max(0, s.width - cs.width - i.left - i.right) / 2;
	// the -10 is just an upward fudge
	int cy = max(0, s.height - ts.height - cs.height -
		     i.top - i.bottom - 10) / 2;
	title.reshape(i.left + tx, i.top,
		      ts.width, ts.height);
	contents.reshape(i.left + cx, i.top + ts.height + cy,
			 cs.width, cs.height);
    }

    public void addLayoutComponent(String s, Component c) {
    }
    
    public void removeLayoutComponent(Component c) {
    }
}
