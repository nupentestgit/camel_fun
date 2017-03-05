package MainApp;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import camelroutes.MyTestRouteBuilder;
import camelroutes.RabbitRouteBuilder;
import rabbitmq.tutorial.Recv;
import rabbitmq.tutorial.Send;

public class Starter {

	public static boolean stopp = false;

	public static void main(String[] args) {
		startCamelTest();
//		startRabbitTestSend();
//		startRabbitTestRecv();
	}

	private static void startCamelTest() {
		CamelContext ctx = new DefaultCamelContext();

		try {
			ctx.addRoutes(new RabbitRouteBuilder());
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
	
	private static void startRabbitTestSend() {
		new Send();
	}
	
	private static void startRabbitTestRecv() {
		new Recv();
	}
}
