package br.inatel.dm110.log.beans;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import br.inatel.dm110.api.log.LogTO;
import br.inatel.dm110.interfaces.log.LogLocal;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/trabalhodm110queue") })
public class LogQueueMDB implements MessageListener {

	private static Logger log = Logger.getLogger(LogQueueMDB.class.getName());
	
    @EJB
    private LogLocal logBean;

	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof ObjectMessage) {
				log.info("---- Mensagem recebida da fila: " + message);
				
				ObjectMessage objMsg = (ObjectMessage) message;
				Object object = objMsg.getObject();
				
				if(object instanceof LogTO) {
					LogTO logTO = (LogTO) object;
					logBean.saveLog(logTO);
				}
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
