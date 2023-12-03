package com.unifiedapi.core;

public class UnifiedEmailFactory {

    public static UnifiedEmailService getUnifiedEmailService(String emailService){
        if(emailService.equalsIgnoreCase("gmail")){
            return new GmailService();
        }
        else if(emailService.equalsIgnoreCase("outlook")){
            return new OutlookService();
        }
        else{
            return null;
        }
    }
}
