package org.example;

import com.google.gson.Gson;

import java.util.function.DoubleUnaryOperator;

public class Answer {
    Boolean result;
    String message;

    public Answer(Boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    public Answer() {
    }


    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    String asJSON(){
        Gson g = new Gson();
        String toJson = g.toJson(this);
        return toJson;
    }

    String htmlMaker(String output){
        return "<!doctype html>\n" +
                "<html lang=en>\n" +
                "<head>\n" +
                "<meta charset=utf-8>\n" +
                "<title>MyJava Sample</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>The content: </h1>" +
                "<h3 style=\"color: red;text-decoration: underline dotted;\">" +
                output +
                "</h3>" +
                "</body>\n" +
                "</html>\n";
    }
}
