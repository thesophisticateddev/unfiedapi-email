package com.unifiedapi.core;

import com.azure.identity.DeviceCodeCredential;
import com.azure.identity.DeviceCodeCredentialBuilder;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.requests.GraphServiceClient;
import okhttp3.Request;

import java.util.Collections;
import java.util.List;

public class Microsoft {
    private final String clientId;
    private final String tenantId;

    private final List<String> scopes;

    private final DeviceCodeCredential credential;

    private final TokenCredentialAuthProvider authProvider;
    private final GraphServiceClient<Request> graphClient;

    private final MicrosoftEmailService microsoftEmailService;

    public Microsoft(builder b) {
        this.clientId = b.clientId;
        this.tenantId = b.tenantId;

        if (clientId == null) {
            throw new RuntimeException("Client Id must not be null");
        }
        if (this.tenantId == null) {
            throw new RuntimeException("Tenant Id must not be null");
        }

        this.scopes = Collections.singletonList("User.Read");
        this.credential = new DeviceCodeCredentialBuilder().clientId(this.clientId).tenantId(this.tenantId).challengeConsumer(challenge -> {
            // Display challenge to the user
            System.out.println(challenge.getMessage());
        }).build();

        if (credential == null) {
            throw new RuntimeException("Either scopes or credentials was null");
        }

        this.authProvider = new TokenCredentialAuthProvider(scopes, credential);

        this.graphClient = GraphServiceClient.builder().authenticationProvider(authProvider).buildClient();
        this.microsoftEmailService = new MicrosoftEmailService(this.graphClient);
    }


    public void logout(){

    }

    public void sendEmail(String subject, String message){

    }

    public void sendEmailToMultiple(String[] recepients){

    }
    public static class builder {
        private String clientId;
        private String tenantId;

        public builder() {

        }

        public String getClientId() {
            return clientId;
        }

        public String getTenantId() {
            return tenantId;
        }

        public builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public builder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public Microsoft build() {
            return new Microsoft(this);
        }
    }
}