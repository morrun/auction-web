package com.mercury.finalProject.jms;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.mercury.bean.EmailInfo;

@Component
public class EmailInfoProducer {
	@Autowired
	private JmsTemplate jmsQueueTemplate;
	
	public void sendEmailForEmail(String to, String subject, String text) {
		EmailInfo ei = new EmailInfo(to, subject, text);
		
		jmsQueueTemplate.send("EmailQueue", new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage((Serializable)ei);
			}
		});
		
	}
}
