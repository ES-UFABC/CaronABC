package com.caronabc.carona.service;

import com.caronabc.carona.util.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.function.Predicate;

@Slf4j
@Service
public class EmailService implements Predicate<String>, EmailUtil {

    private JavaMailSender mailSender;

    @Override
    public boolean test(String email) {
        String emailPattern = "[^\\t\\n\\f\\r]+@(aluno\\.)?ufabc\\.edu\\.br";
        return email.matches(emailPattern);
    }

    // TODO: refactor email sender
    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Confirm your email");
            helper.setFrom("email@app.com");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.info("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }
}
