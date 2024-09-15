package com.example.email_sender.service;

public interface EmailSenderService {

    void sendEmail(String subject, String text, String sendTo);
}
