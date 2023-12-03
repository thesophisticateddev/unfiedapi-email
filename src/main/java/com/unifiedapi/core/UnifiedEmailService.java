package com.unifiedapi.core;

public interface UnifiedEmailService {
    void sendEmail(String to, String subject, String body);
    void sendEmailToMultiple(String[] recepients, String subject, String body);

    void sendEmailWithAttachment(String to, String subject, String body, String attachmentPath);
    void sendEmailWithAttachmentToMultiple(String[] recepients, String subject, String body, String attachmentPath);
}
