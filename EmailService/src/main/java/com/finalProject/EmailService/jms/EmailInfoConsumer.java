package com.finalProject.EmailService.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.finalProject.EmailService.service.EmailService;
import com.mercury.bean.EmailInfo;
@Component
public class EmailInfoConsumer {
	@Autowired
	private EmailService es;
	
	@JmsListener(destination = "EmailQueue", containerFactory = "emailInfoListener")
	public void receive(Message msg) throws JMSException {
		System.out.println(msg);
		ObjectMessage objectMessage = (ObjectMessage) msg;
		EmailInfo emailInfo = (EmailInfo) objectMessage.getObject();
		//System.out.println(EmailInfo);
		es.sendSimpleMessage(emailInfo.getTo(),emailInfo.getSubject(),emailInfo.getText());
	}
}
