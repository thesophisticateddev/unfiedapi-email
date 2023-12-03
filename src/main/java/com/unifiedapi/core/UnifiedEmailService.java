package com.unifiedapi.core;

public interface UnifiedEmailService {
    void sendEmail(String to, String subject, String body);
}
