package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Users {
    private List<User> utenti = new ArrayList<User>();

    public Users() {
        utenti.add(new User("nadr","password"));
        utenti.add(new User("mohamed","password"));
    }


    public List<User> getUtenti() {
        return utenti;
    }

    public void setUtenti(List<User> utenti) {
        this.utenti = utenti;
    }

    public void addUser(User utente){
        utenti.add(utente);
    }

    public String verify(String nomeUtente, String password){
        for (User utente : utenti) {
            if(utente.getNomeUtente().equals(nomeUtente) && utente.getPassword().equals(password)){
                return utente.getToken().toString();
            }
        }
        return "";
    }

    public boolean tokenVerify(UUID token){
        for (User utente : utenti) {
            if(utente.getToken().equals(token)){
                return true;
            }
        }
        return false;
    }

}
