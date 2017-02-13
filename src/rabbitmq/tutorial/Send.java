package rabbitmq.tutorial;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

	private static final String QUEUE_NAME = "hello";

	public Send() {
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			Connection con = factory.newConnection();
			Channel chan = con.createChannel();
			
			chan.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = "Hello World!";
			chan.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println(" [x] Sent '" + message + "'");
			chan.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
