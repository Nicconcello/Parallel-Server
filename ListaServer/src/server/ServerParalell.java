package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket; 
import java.net.Socket; 
import java.util.Scanner; 
import javax.swing.JFrame;
import javax.swing.SwingUtilities; 

public class ServerParalell {


    public static void main(String[] args) throws IOException {
		

        boolean connesso = false;
        ServerParalellFrame finestra = new ServerParalellFrame();
        ServerSocket ss = new ServerSocket(2468);

        while (true) {
        	SwingUtilities.invokeLater(() -> finestra.testo.setText("Il Server sta attendendo la connessione....."));
            Socket s = ss.accept();
            
            WhileThread wt = new WhileThread(s, finestra, connesso);
            Thread t = new Thread(wt);
            
            t.start();
            }
        }
    }
