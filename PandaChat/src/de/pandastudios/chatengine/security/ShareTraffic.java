package de.pandastudios.chatengine.security;

import java.lang.management.ManagementFactory;


import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanServer;
import javax.management.ObjectName;

public class ShareTraffic implements Runnable{
	public static double getProcessCpuLoad() throws Exception {

	    MBeanServer mbs    = ManagementFactory.getPlatformMBeanServer();
	    ObjectName name    = ObjectName.getInstance("java.lang:type=OperatingSystem");
	    AttributeList list = mbs.getAttributes(name, new String[]{ "ProcessCpuLoad" });

	    if (list.isEmpty())     return Double.NaN;

	    Attribute att = (Attribute)list.get(0);
	    Double value  = (Double)att.getValue();


	    if (value == -1.0)      return Double.NaN;

	    return ((int)(value * 1000) / 10.0);
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				if(getProcessCpuLoad() > 80) {
					//ANFRAGE BEI NEUEM SERVER!
				}
				Thread.currentThread().sleep(30000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		
	}
}
