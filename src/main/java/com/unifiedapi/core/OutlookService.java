package com.unifiedapi.core;

public class OutlookService implements UnifiedEmailService {
    private Microsoft microsoft;
    public OutlookService(String clientId, String tenantId) {
        this.microsoft =new Microsoft.builder().clientId(clientId).tenantId(tenantId).build();
    }

    public OutlookService(Microsoft microsoft) {
        this.microsoft = microsoft;
    }
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
