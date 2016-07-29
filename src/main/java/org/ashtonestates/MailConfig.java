/*
 *
 */
package org.ashtonestates;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

	@Bean(name = "mailSender")
	public JavaMailSenderImpl mailSender() {
		final JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("smtp.comcast.net");
		sender.setUsername("bill.hunt");
		sender.setPassword("CatOrangeMonkey1");
		sender.setPort(587);
		final Properties properties = new Properties();
		properties.setProperty("mail.smtp.auth", "true");
		sender.setJavaMailProperties(properties);
		return sender;
	}

	@Bean(name = "templateMessage")
	public SimpleMailMessage templateMessage() {
		final SimpleMailMessage template = new SimpleMailMessage();
		template.setFrom("bill.hunt@comcast.net");
		return template;
	}

}