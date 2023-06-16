package org.example;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List <Prodotto> prodotti = new ArrayList<Prodotto>();


    public Store() {
        addProduct(new Prodotto("Iphone",1000.00,"Telefono"));
        addProduct(new Prodotto("Mac",10200.00,"Computer"));
    }


    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    public void addProduct(Prodotto prodotto){
        prodotti.add(prodotto);
    }



    //UUID uuid = UUID.randomUUID();
}
