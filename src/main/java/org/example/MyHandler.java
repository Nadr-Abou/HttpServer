package org.example;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URI;

import static java.lang.Thread.sleep;

public class MyHandler implements HttpHandler {
    static final Users users = new Users();
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        InputStream is = exchange.getRequestBody();
        URI uri = exchange.getRequestURI();
        String method = exchange.getRequestMethod();
        String params = "";
        if(method.equals("POST")){
            params = read(is);
            response(params,exchange);
        }
        else if(method.equals("GET")){
            params = uri.getQuery();
        }
    }

    private String read(InputStream is) {
        BufferedReader br = new BufferedReader( new InputStreamReader(is) );
        System.out.println("\n");
        String received = "";
        while (true) {
            String s = "";
            try {
                if ((s = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(s);
            received += s;
        }
        return received;
    }

    public void response(String params,HttpExchange exchange) throws IOException {
        String response = checker(params);
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    public String checker(String data){

        Gson gson = new Gson();
        Command cmd;

        try { //è stato messo il try/catch perchè se l'utente inserisce un tocken Troppo lungo il Gson da errore...
            cmd = gson.fromJson(data, Command.class);
        }catch (Exception e)
        {
            if(data.contains("html")){
                return new ListAnswer().htmlMaker("TOKEN ERRATO");
            }
            else{
                return new Answer(false, "token errato").asJSON();
            }
        }

        if(cmd.cmd.equals("list")) {
            return commandList(cmd);
        }

        else if (cmd.cmd.equals("login")){
            return commandLogin(cmd);
        }

        if(cmd.mode != null &&cmd.mode.equals("html")){
            return new Answer().htmlMaker("Comando sconosciuto");
        }
        else{
            return new Answer(false,"comando sconosciuto").asJSON();
        }
    }

    String commandList(Command cmd){
        if (cmd.mode != null && cmd.mode.equals("json")) {
            if(users.tokenVerify(cmd.token))
                return new ListAnswer().listPrint(new Store().getProdotti());
            else
                return new Answer(false, "token errato").asJSON();
        } else if (cmd.mode != null && cmd.mode.equals("html")) {
            if(users.tokenVerify(cmd.token))
                return new Answer().htmlMaker(new ListAnswer().listPrint(new Store().getProdotti()));
            else
                return new ListAnswer().htmlMaker("TOKEN ERRATO");
        } else {
            return new Answer(false, "scegliere la MODE corretta").asJSON();
        }
    }


    String commandLogin(Command cmd){

        String result = users.verify(cmd.param1, cmd.param2);

        if(cmd.mode != null && cmd.mode.equals("json"))
        {
            if (result.length() > 0) {
                return new Answer(true, "Login effettuato token " + result).asJSON();
            }
            else {
                return new Answer(false, "Login fallito  utente non trovato").asJSON();
            }
        }

        else if(cmd.mode != null && cmd.mode.equals("html")){
            if (result.length() > 0)
            {
                return new Answer().htmlMaker("Login effettuato token " + result);
            }
            else
            {
                return new Answer().htmlMaker("Login fallito  utente non trovato");
            }

        }

        else
        {
            return new Answer(false, "scegliere la MODE corretta").asJSON();
        }

    }

}
