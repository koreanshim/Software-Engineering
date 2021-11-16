package Lab6;
import java.awt.*;

import simView.*;

public class add_function extends ViewableDigraph
{

	public add_function()
	{
		super("add_function");
    	
		ViewableAtomic user = new user("user", 30);
		ViewableAtomic add = new add("add", 10);
		ViewableAtomic sub = new sub("sub", 10);
		ViewableAtomic multi = new multi("multi", 10);
		ViewableAtomic div = new div("div", 10);
    	
		add(user);
		add(add);
		add(sub);
		add(multi);
		add(div);
		
		addCoupling(user, "out1", add, "in");
		addCoupling(user, "out2", sub, "in");
		addCoupling(user, "out3", multi, "in");
		addCoupling(user, "out4", div, "in");
		
		addCoupling(add, "out", user, "in");
		addCoupling(sub, "out", user, "in");
		addCoupling(multi, "out", user, "in");
		addCoupling(div, "out", user, "in");
	}

    
    /**
     * Automatically generated by the SimView program.
     * Do not edit this manually, as such changes will get overwritten.
     */
    public void layoutForSimView()
    {
        preferredSize = new Dimension(908, 482);
        ((ViewableComponent)withName("div")).setPreferredLocation(new Point(192, 318));
        ((ViewableComponent)withName("user")).setPreferredLocation(new Point(426, 73));
        ((ViewableComponent)withName("add")).setPreferredLocation(new Point(670, 311));
        ((ViewableComponent)withName("multi")).setPreferredLocation(new Point(90, 142));
        ((ViewableComponent)withName("sub")).setPreferredLocation(new Point(401, 355));
    }
}
