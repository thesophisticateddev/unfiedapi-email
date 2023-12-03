package com.unifiedapi.core;

import com.microsoft.graph.models.*;
import com.microsoft.graph.requests.GraphServiceClient;
import com.microsoft.graph.requests.UserSendMailRequest;
import okhttp3.Request;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MicrosoftEmailService {
    private final GraphServiceClient<Request> graphServiceClient;

    public MicrosoftEmailService(GraphServiceClient<okhttp3.Request> graphServiceClient) {
        this.graphServiceClient = graphServiceClient;
    }

    public CompletableFuture<Void> sendEmail(String recipientEmailAddress, String subject, String emailMessage) {
        UserSendMailRequest sendMailRequest = new UserSendMailRequest("", this.graphServiceClient, null);
        Message message = new Message();
        message.subject = subject;

        ItemBody body = new ItemBody();
        body.contentType = BodyType.TEXT;
        body.content = emailMessage;
        message.body = body;

        Recipient recipient = new Recipient();
        EmailAddress receiverEmail = new EmailAddress();
        receiverEmail.address = recipientEmailAddress;
        recipient.emailAddress = receiverEmail;

        message.toRecipients = List.of(recipient);

        return this.graphServiceClient.me().sendMail(UserSendMailParameterSet.newBuilder()
                                                                      .withMessage(message)
                                                                      .withSaveToSentItems(false)
                                                                      .build()).buildRequest()
                               .postAsync();
    }
}
