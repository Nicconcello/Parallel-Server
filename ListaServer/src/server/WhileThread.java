package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.SwingUtilities;

public class WhileThread implements Runnable {
    private Socket s;
    private ServerParalellFrame finestra;
    private boolean connesso;

    public WhileThread(Socket s, ServerParalellFrame finestra, boolean connesso) {
        this.s = s;
        this.finestra = finestra;
        this.connesso = connesso;
    }

    @Override
    public void run() {
        try {
            Scanner sc = new Scanner(s.getInputStream());
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            connesso = true;

            SwingUtilities.invokeLater(() -> finestra.testo.setText("Utente connesso"));

            while (connesso) {
                if (!sc.hasNextLine()) {
                    connesso = false;
                    s.close();
                    break;
                }

                String cv = sc.nextLine().trim();

                if (cv.equals("startp")) {
                    ThreadP tp = new ThreadP(finestra.testo);
                    Thread t1 = new Thread(tp);
                    t1.start();
                } else if (cv.equals("startd")) {
                    ThreadD td = new ThreadD(finestra.testo);
                    Thread t2 = new Thread(td);
                    t2.start();
                }
            }

            sc.close();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
