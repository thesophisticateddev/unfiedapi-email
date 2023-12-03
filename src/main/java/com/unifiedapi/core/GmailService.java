package com.unifiedapi.core;

public class GmailService implements UnifiedEmailService {
    @Override
    public void sendEmail(String to, String subject, String body) {

    }

    @Override
    public void sendEmailToMultiple(String[] recepients, String subject, String body) {

    }

    @Override
    public void sendEmailWithAttachment(String to, String subject, String body,
                                        String attachmentPath) {

    }

    @Override
    public void sendEmailWithAttachmentToMultiple(String[] recepients, String subject, String body,
                                                  String attachmentPath) {

    }
}
