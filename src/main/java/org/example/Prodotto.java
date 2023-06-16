package org.example;

public class Prodotto {
    private String nome;
    private Double costo;
    private String descrizione;

    public Prodotto(String nome, Double costo, String descrizione) {
        this.nome = nome;
        this.costo = costo;
        this.descrizione = descrizione;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "nome='" + nome + '\'' +
                ", costo=" + costo +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
