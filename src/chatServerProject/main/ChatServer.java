package chatServerProject.main;
import java.net.*;
import java.io.*;

public class ChatServer extends Thread {
        public final String closeConnection ="#CLOSE_CONNECTION#";
        private ServerSocket server;
        private Socket socket;
        private int port;
        private BufferedReader in;
        private PrintWriter out;
        private boolean connected;
        private FrameServer frameServer;
        
        public ChatServer(int port, FrameServer frameServer) {
                this.port = port;
                this.frameServer = frameServer;
                connected = false;
        }
        public void run() {
                launch();
                receive();
        }
        private void launch() {
             try {
                server=new ServerSocket(port);
                if (server!=null)
                        socket=server.accept();
                        if (socket!=null) {
                                frameServer.setTextButton("Disconnect");
                                connected =true;
                                InetAddress iaClient=socket.getInetAddress(); //will get the InetAddress object from the client
                                String hostAddress=iaClient.getHostAddress(); //will get the IP address
                                frameServer.setIPClient(hostAddress);
                                in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                out=new PrintWriter(socket.getOutputStream(),true);
                        } else
                                close();
             } catch (IOException ioex) {
                     close();
             } catch (IllegalArgumentException iae) {
                     close();
             }
        }
        public void close() {
             try {
                if (server!=null)
                        server.close();
                if (socket!=null)
                        socket.close();
                if (in!=null)
                        in.close();
                if (out!=null)
                        out.close();
                connected =false;
                frameServer.setTextButton("Connect");
             } catch (IOException ioex) {}
        }
        public void send(String text) {
            out.println(text);
        }
        public void receive() {
            int i;
            char c;
            StringBuffer text= new StringBuffer("");
            String line;
            try {
                while (connected){
                    text.delete(0, text.length());
                    i=in.read();
                    while (i!=13){
                        c=(char)i;
                        text.append(c);
                        i=in.read();
                    }
                    in.read();
                    line=text.toString();
                    if (line.equalsIgnoreCase(closeConnection)){
                        close();
                    }else{                        
                        frameServer.setTextChat(line);
                    }
                }
            }catch (IOException ex) {
                    close();
            }
        }
}
