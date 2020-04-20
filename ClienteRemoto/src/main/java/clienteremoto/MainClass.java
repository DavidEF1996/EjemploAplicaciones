package clienteremoto;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import ec.edu.ups.appdis.testejb.business.DemoEJBBeanRemote;

public class MainClass {
	

	public DemoEJBBeanRemote demoEJB;
	
	public void intanciarEJBRemoto() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "ejb01");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "ejb01");  
              
            final Context context = new InitialContext(jndiProperties);  
              
            final String lookupName = "ejb:/testejb/DemoEJBBean!ec.edu.ups.appdis.testejb.business.DemoEJBBeanRemote";  
              
            this.demoEJB = (DemoEJBBeanRemote) context.lookup(lookupName);  
              
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}

	public static void main (String args[]) {
		
		MainClass mc = new MainClass();
		try {
			mc.intanciarEJBRemoto();
			double f = mc.demoEJB.convertCelciudToFaren(64);
			System.out.println(f);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
