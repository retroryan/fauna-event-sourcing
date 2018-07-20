package com.example.appengine.demos.springboot;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("fauna")
public class FaunaConfig {

    private String secret;

    private String endpoint;

    private String ledgerdb_name;

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setLedgerdb_name(String ledgerdb_name) {
        this.ledgerdb_name = ledgerdb_name;
    }

    public String getSecret() {
        return secret;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getLedgerdb_name() {
        return ledgerdb_name;
    }

    @Override
    public String toString() {
        return "FaunaConfig{" +
            "endpoint='" + endpoint + '\'' +
            ", ledgerdb_name='" + ledgerdb_name + '\'' +
            '}';
    }
}
