package org.example;

import java.util.UUID;

public class User{
    private String nomeUtente;
    private String password;

    private UUID token;

    private boolean logged;
    public User(String nomeUtente, String password) {
        this.nomeUtente = nomeUtente;
        this.password = password;
        this.token = UUID.randomUUID();
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public UUID getToken() {
        return token;
    }
}
