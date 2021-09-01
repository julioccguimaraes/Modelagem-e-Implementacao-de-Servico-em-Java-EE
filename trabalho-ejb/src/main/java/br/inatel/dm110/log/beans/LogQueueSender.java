package br.inatel.dm110.log.beans;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import br.inatel.dm110.api.log.LogTO;

@Stateless
public class LogQueueSender {

	@Resource(lookup = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(lookup = "java:/jms/queue/trabalhodm110queue")
	private Queue queue;

	private static Logger log = Logger.getLogger(LogQueueSender.class.getName());
	
	public void sendObjectMessage(LogTO logTO) {
		try {
			
			Connection conn = connectionFactory.createConnection();
			Session session = conn.createSession();
			MessageProducer msgProducer = session.createProducer(queue);
			ObjectMessage objMsg = session.createObjectMessage(logTO);
			msgProducer.send(objMsg);
			
			log.info("Enviou a mensagem: " + objMsg);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}

}
