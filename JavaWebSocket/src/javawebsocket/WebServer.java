/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawebsocket;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tomás Abril
 * 
 * tomas@alunos...
 *
 * 1013343
 *
 * Engenharia da Computação
 *
 * UTFPR
 */
public final class WebServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        // Set the port number.
        int port = 6789;

        // Establish the listen socket.
        ServerSocket listenSocket = new ServerSocket(port);
        System.out.println("usando porta: " + port);

        // Process HTTP service requests in an infinite loop.
        while (true) {
            // Listen for a TCP connection request.
            Socket connectionSocket = listenSocket.accept();

            // Construct an object to process the HTTP request message
            HttpRequest request = new HttpRequest(connectionSocket);

            // Create a new thread to process the request.
            Thread thread = new Thread(request);

            // Start the thread.
            thread.start();
        }
    }
}
