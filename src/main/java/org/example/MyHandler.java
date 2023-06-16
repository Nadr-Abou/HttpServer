package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URI;

public class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        InputStream is = exchange.getRequestBody();
        URI uri = exchange.getRequestURI();
        String method = exchange.getRequestMethod();
        String params = "";
        if(method.equals("POST")){

            params = read(is);
        }
        else if(method.equals("GET")){
            params = uri.getQuery();
            response(params,exchange);
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
        String response = "ciao";
        /*        "<!doctype html>\n" +
                        "<html lang=en>\n" +
                        "<head>\n" +
                        "<meta charset=utf-8>\n" +
                        "<title>MyJava Sample</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<h1>The content: </h1>" +
                        "<h3 style=\"color: red;text-decoration: underline dotted;\">" + checker(params) + "</h3>" +
                        "</body>\n" +
                        "</html>\n";*/
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
        //172.16.150.56
        //172.18.160.1
    }
    public String checker(String data){

        String[] splitted = data.split("&");
        if (splitted.length == 0)
            return "no data";
        String cmd = splitted[0].split("=")[0];
        String options = splitted[0].split("=")[1];
        String user = splitted[1].split("=")[1];

        if (cmd.equals("gimmeanswer") && options.equals("please"))
            return "Hello " + user + "\n";

        if (cmd.equals("gimmeanswer"))
            return "You are unpolite, " + user + "\n";

        return "bad request";
    }

    public void answerJson(){

    }
    public void answerHtml(){

    }
}
