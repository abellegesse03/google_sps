package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

class Greeting {
    String s;
    public Greeting(String s){
        this.s = s;
    }
}

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Greeting S1 = new Greeting("Hello World!");
    Greeting S2 = new Greeting("Ciao Mondo!");
    Greeting S3 = new Greeting("Hola Mundo!");
    ArrayList<Greeting> greetings = new ArrayList<>();
    
    greetings.add(S1);
    greetings.add(S2);
    greetings.add(S3);

    String json = convertToJsonUsingGson(greetings);

    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

  private String convertToJsonUsingGson(ArrayList<Greeting> g) {
    Gson gson = new Gson();
    String json = gson.toJson(g);
    return json;
  }
}
