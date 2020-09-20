package com.pierre.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.pierre.cursomc.domain.Cliente;
import com.pierre.cursomc.domain.Pedido;

public interface EmailService {
  void sendOrderConfirmationEmail(Pedido pedido);
  void sendEmail(SimpleMailMessage msg);
  
  void sendOrderConfirmationHtmlEmail(Pedido obj);
  
  void sendHtmlEmail(MimeMessage msg);
  void sendNewPasswordEmail(Cliente cliente ,String newPass);
}
