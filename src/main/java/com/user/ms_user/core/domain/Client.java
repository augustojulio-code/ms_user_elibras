package com.user.ms_user.core.domain;

import java.util.UUID;

public class Client {

    private UUID clientId;
    private String clientName;
    private String clientEmail;

    public Client() {

    }

    public Client(UUID clientId, String clientName, String clientEmail) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

}
