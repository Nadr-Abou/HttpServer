package org.example;

import com.google.gson.Gson;

import java.util.List;


public class ListAnswer extends Answer{


    String listPrint(List<Prodotto> lista){
        Gson gson = new Gson();
        String result = gson.toJson(lista);
        return result;
    }
}
