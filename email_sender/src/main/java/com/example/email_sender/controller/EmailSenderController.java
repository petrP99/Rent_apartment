package com.example.email_sender.controller;

import com.example.email_sender.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @GetMapping("/test")
    public void sendEmail() {
        String testSubject = "testSubject";
        String test = "text";
        String sendTo = "petr2@bk.ru";
        emailSenderService.sendEmail(testSubject, test, sendTo);
    }
}
