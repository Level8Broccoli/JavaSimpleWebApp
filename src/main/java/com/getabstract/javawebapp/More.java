package com.getabstract.javawebapp;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@WebServlet("/more")
public class More extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var pathToFile = "/WEB-INF/more.html";

        String text = null;
        try (var in = getServletContext().getResourceAsStream(pathToFile)) {
            if (in != null) {
                try (var scanner = new Scanner(in, StandardCharsets.UTF_8)) {
                    text = scanner.useDelimiter("\\A").next();
                }
            }
        }

        response.setContentType("text/html");
        var out = response.getWriter();
        if (text != null) {
            out.println(text);
        } else {
            out.println("Problem while loading the file " + pathToFile);
        }
    }
}
