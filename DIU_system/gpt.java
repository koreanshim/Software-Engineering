package DIU_system;
import java.awt.*;
import simView.*;

public class gpt extends ViewableDigraph
{

	public gpt()
	{
		super("gpt");
    	
		ViewableAtomic g = new genr("genr", 40);
		ViewableAtomic d = new DIU("DIU", 20);
    	ViewableAtomic ac = new ami_company("ami_company", 10);
    	ViewableAtomic ah = new ami_house("ami_house", 10);
    	ViewableAtomic as = new ami_school("ami_school", 10);
    	ViewableAtomic ay1 = new ami_yonghyun1("ami_yonghyun1", 10);
    	ViewableAtomic ay2 = new ami_yonghyun2("ami_yonghyun2", 10);
    	ViewableAtomic ay3 = new ami_yonghyun3("ami_yonghyun3", 10);
    	
		add(g);
		add(d);
		add(ac);
		add(ah);
		add(as);
		add(ay1);
		add(ay2);
		add(ay3);
		
		addCoupling(g, "out", d, "in"); //GENR->DIU
		addCoupling(d, "re_request", g, "in"); //DIU->GENR REQUEST
		addCoupling(d, "out_ami_company", ac, "in"); //DIU->AMI
		addCoupling(d, "out_ami_house", ah, "in");
		addCoupling(d, "out_ami_school", as, "in");
		addCoupling(d, "out_ami_yonghyun1", ay1, "in");
		addCoupling(d, "out_ami_yonghyun2", ay2, "in");
		addCoupling(d, "out_ami_yonghyun3", ay3, "in");
	}

    
    /**
     * Automatically generated by the SimView program.
     * Do not edit this manually, as such changes will get overwritten.
     */
    public void layoutForSimView()
    {
        preferredSize = new Dimension(988, 646);
        ((ViewableComponent)withName("ami_yonghyun1")).setPreferredLocation(new Point(561, 329));
        ((ViewableComponent)withName("ami_yonghyun3")).setPreferredLocation(new Point(565, 445));
        ((ViewableComponent)withName("ami_yonghyun2")).setPreferredLocation(new Point(559, 386));
        ((ViewableComponent)withName("ami_company")).setPreferredLocation(new Point(569, 132));
        ((ViewableComponent)withName("ami_house")).setPreferredLocation(new Point(573, 204));
        ((ViewableComponent)withName("ami_school")).setPreferredLocation(new Point(562, 268));
        ((ViewableComponent)withName("DIU")).setPreferredLocation(new Point(192, 300));
        ((ViewableComponent)withName("genr")).setPreferredLocation(new Point(13, 318));
    }
}
