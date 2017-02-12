package MainApp;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import camelroutes.MyTestRouteBuilder;

public class Starter {

	public static boolean stopp = false;

	public static void main(String[] args) {
		CamelContext ctx = new DefaultCamelContext();

		try {
			ctx.addRoutes(new MyTestRouteBuilder());
			ctx.start();

			System.out.println("Context started");

			while (!stopp) {
				Thread.sleep(2000);
			}

			ctx.stop();

			System.out.println("Context stopped");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
