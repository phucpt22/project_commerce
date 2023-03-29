package edu.poly.asm_java6.service;

import edu.poly.asm_java6.dto.MailerDTO;
import java.io.UnsupportedEncodingException;

import jakarta.mail.MessagingException;

public interface MailerService {

	void send(MailerDTO mail) throws MessagingException;

	void send(String to, String subject, String body) throws MessagingException;

	void sendEmail(String recipientEmail, String link) throws MessagingException, UnsupportedEncodingException;

}
