package com.unifiedapi.core;

public class UnifiedEmailBuilder {
    private UnifiedEmailService unifiedEmailService;
    private String emailService;
    public static UnifiedEmailService getUnifiedEmailService(String emailService, Object client){
        if(emailService.equalsIgnoreCase("gmail")){
            return new GmailService();
        }
        else if(emailService.equalsIgnoreCase("outlook")){
            if(client instanceof Microsoft){
                return new OutlookService((Microsoft)client);
            }
            else{
                throw new RuntimeException("Client must be of type Microsoft");
            }
        }
        else{
            return null;
        }
    }


}
