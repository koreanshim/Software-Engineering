package DIU_system;
import genDevs.modeling.*;
import GenCol.*;
import simView.*;

public class DIU extends ViewableAtomic
{
  
	protected job job_ex;
	protected double processing_time;

	public DIU()
	{
		this("DIU", 20);
	}

	public DIU(String name, double Processing_time)
	{
		super(name);
    
		addInport("in");
		addOutport("re_request");
		addOutport("out_ami_company");
		addOutport("out_ami_house");
		addOutport("out_ami_school");
		addOutport("out_ami_yonghyun1");
		addOutport("out_ami_yonghyun2");
		addOutport("out_ami_yonghyun3");
		
		processing_time = Processing_time;
	}
  
	public void initialize()
	{
		job_ex = new job("none", 0, 0, 0, "none", "none", "none", "none", 0);
		
		holdIn("sending", INFINITY);
	}

	public void deltext(double e, message x)
	{
		Continue(e);
		if (phaseIs("sending"))
		{
			for (int i = 0; i < x.getLength(); i++)
			{
				if (messageOnPort(x, "in", i))
				{
					job_ex = (job)x.getValOnPort("in", i);
					
					holdIn("classifying", processing_time / 2);
				}
			}
		}
	}
  
	public void deltint()
	{
		if (phaseIs("classifying"))
		{
			job_ex = new job("none", 0, 0, 0, "none", "none", "none", "none", 0);
			
			holdIn("sending", INFINITY);
		}
	}

	public message out()
	{
		message m = new message();
		if (phaseIs("classifying"))
		{
			if(job_ex._diu_id % 3 != 0) { //SEND TO AMIs
				
				if(job_ex._ami_id == 1) {
					m.add(makeContent("out_ami_company", new job("id: " + job_ex._msg_id, 
							job_ex._ami_id, job_ex._msg_id, job_ex._diu_id, job_ex._facility, job_ex._address, job_ex._region, job_ex._date, job_ex._power)));
					m.add(makeContent("out_ami_yonghyun1", new job("id: " + job_ex._msg_id, 
							job_ex._ami_id, job_ex._msg_id, job_ex._diu_id, job_ex._facility, job_ex._address, job_ex._region, job_ex._date, job_ex._power)));
				}
				else if(job_ex._ami_id == 2) {
					m.add(makeContent("out_ami_company", new job("id: " + job_ex._msg_id, job_ex._ami_id, job_ex._msg_id, 
							job_ex._diu_id, job_ex._facility, job_ex._address, job_ex._region, job_ex._date, job_ex._power)));
					m.add(makeContent("out_ami_yonghyun2", new job("id: " + job_ex._msg_id, 
							job_ex._ami_id, job_ex._msg_id, job_ex._diu_id, job_ex._facility, job_ex._address, job_ex._region, job_ex._date, job_ex._power)));
				}
				else if(job_ex._ami_id == 3) {
					m.add(makeContent("out_ami_company", new job("id: " + job_ex._msg_id, 
							job_ex._ami_id, job_ex._msg_id, job_ex._diu_id, job_ex._facility, job_ex._address, job_ex._region, job_ex._date, job_ex._power)));
					m.add(makeContent("out_ami_yonghyun3", new job("id: " + job_ex._msg_id, 
							job_ex._ami_id, job_ex._msg_id, job_ex._diu_id, job_ex._facility, job_ex._address, job_ex._region, job_ex._date, job_ex._power)));
				}
				else if(job_ex._ami_id == 4) {
					m.add(makeContent("out_ami_house", new job("id: " + job_ex._msg_id, 
							job_ex._ami_id, job_ex._msg_id, job_ex._diu_id, job_ex._facility, job_ex._address, job_ex._region, job_ex._date, job_ex._power)));
					m.add(makeContent("out_ami_yonghyun1", new job("id: " + job_ex._msg_id, 
							job_ex._ami_id, job_ex._msg_id, job_ex._diu_id, job_ex._facility, job_ex._address, job_ex._region, job_ex._date, job_ex._power)));
				}
				else if(job_ex._ami_id == 5) {
					m.add(makeContent("out_ami_house", new job("id: " + job_ex._msg_id, 
							job_ex._ami_id, job_ex._msg_id, job_ex._diu_id, job_ex._facility, job_ex._address, job_ex._region, job_ex._date, job_ex._power)));
					m.add(makeContent("out_ami_yonghyun2", new job("id: " + job_ex._msg_id, 
							job_ex._ami_id, job_ex._msg_id, job_ex._diu_id, job_ex._facility, job_ex._address, job_ex._region, job_ex._date, job_ex._power)));
				}
				else if(job_ex._ami_id == 6) {
					m.add(makeContent("out_ami_house", new job("id: " + job_ex._msg_id, 
							job_ex._ami_id, job_ex._msg_id, job_ex._diu_id, job_ex._facility, job_ex._address, job_ex._region, job_ex._date, job_ex._power)));
					m.add(makeContent("out_ami_yonghyun3", new job("id: " + job_ex._msg_id, 
							job_ex._ami_id, job_ex._msg_id, job_ex._diu_id, job_ex._facility, job_ex._address, job_ex._region, job_ex._date, job_ex._power)));
				}
				else if(job_ex._ami_id == 7) {
					m.add(makeContent("out_ami_school", new job("id: " + job_ex._msg_id, 
							job_ex._ami_id, job_ex._msg_id, job_ex._diu_id, job_ex._facility, job_ex._address, job_ex._region, job_ex._date, job_ex._power)));
					m.add(makeContent("out_ami_yonghyun1", new job("id: " + job_ex._msg_id, 
							job_ex._ami_id, job_ex._msg_id, job_ex._diu_id, job_ex._facility, job_ex._address, job_ex._region, job_ex._date, job_ex._power)));
				}
				else if(job_ex._ami_id == 8) {
					m.add(makeContent("out_ami_school", new job("id: " + job_ex._msg_id,
							job_ex._ami_id, job_ex._msg_id, job_ex._diu_id, job_ex._facility, job_ex._address, job_ex._region, job_ex._date, job_ex._power)));
					m.add(makeContent("out_ami_yonghyun2", new job("id: " + job_ex._msg_id, 
							job_ex._ami_id, job_ex._msg_id, job_ex._diu_id, job_ex._facility, job_ex._address, job_ex._region, job_ex._date, job_ex._power)));
				}
				else if(job_ex._ami_id == 9) {
					m.add(makeContent("out_ami_school", new job("id: " + job_ex._msg_id, 
							job_ex._ami_id, job_ex._msg_id, job_ex._diu_id, job_ex._facility, job_ex._address, job_ex._region, job_ex._date, job_ex._power)));
					m.add(makeContent("out_ami_yonghyun3", new job("id: " + job_ex._msg_id, 
							job_ex._ami_id, job_ex._msg_id, job_ex._diu_id, job_ex._facility, job_ex._address, job_ex._region, job_ex._date, job_ex._power)));
				}
				
				System.out.println("\n========DIU=========");
				System.out.println("AMI_ID: " + job_ex._ami_id);
				System.out.println("MSG_ID: " + job_ex._msg_id);
				System.out.println("DIU_ID: " + job_ex._diu_id);
				System.out.println("FACILITY: " + job_ex._facility);
				System.out.println("ADDRESS: " + job_ex._address);
				System.out.println("REGION: " + job_ex._region);
				System.out.println("DATE: " + job_ex._date);
				System.out.println("POWER(KW): " + job_ex._power);
				System.out.println("=====================");
			}
			
			else { //RE-REQUEST
				job_ex._facility = "RE_REQUEST";
				job_ex._address = "NONE";
				job_ex._region = "NONE";
				job_ex._date = "NONE";
				job_ex._power = 0;
				m.add(makeContent("re_request", new job("id: " + job_ex._msg_id, 
						job_ex._ami_id, job_ex._msg_id, job_ex._diu_id, job_ex._facility, job_ex._address, job_ex._region, job_ex._date, job_ex._power)));
				
				System.out.println("\n====RE_REQUEST====");
				System.out.println("AMI_ID: " + job_ex._ami_id);
				System.out.println("MSG_ID: " + job_ex._msg_id);
				System.out.println("DIU_ID: " + job_ex._diu_id);
				System.out.println("RE_REQUEST: " + job_ex._facility);
				System.out.println("ADDRESS: " + job_ex._address);
				System.out.println("REGION: " + job_ex._region);
				System.out.println("DATE: " + job_ex._date);
				System.out.println("POWER(KW): " + job_ex._power);
				System.out.println("=====================");
			}
		}
		
		
		return m;
	}

	public String getTooltipText()
	{
		return
		super.getTooltipText()
		+ "\n" + "job: " + job_ex.getName();
	}

}

