package ec.edu.ups.appdis.testejb.business;

import javax.ejb.Remote;

@Remote
public interface DemoEJBBeanRemote {
	
	public double convertCelciudToFaren(int c);
	public int suma(int a, int b);

}