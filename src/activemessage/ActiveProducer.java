package activemessage;


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveProducer {

	static private String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	static private String subject = "JCG_QUEUE";
	static Connection connection;

public static void main(String qrgs[]) throws JMSException{

	ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

	try {
		connection = connectionFactory.createConnection();
		connection.start();
	} catch (JMSException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	Destination destination = session.createQueue(subject);
	MessageProducer messageProducer = session.createProducer(destination);	
	TextMessage message = session.createTextMessage("Hi there");
	messageProducer.send(message);
	System.out.println("Message has been sent");
}

}
