package chatServerProject.main;
import java.net.*;
import java.io.*;

public class ChatServer extends Thread {
        public final String closeConnection ="#CLOSE_CONNECTION#";
        private ServerSocket server;
        private Socket socket;
        private int puerto;
        private BufferedReader in;
        private PrintWriter out;
        private boolean connected;
        private FrameServer frameServer;
        
        public ChatServer(int port, FrameServer frameServer) {
                this.puerto=port;
                this.frameServer = frameServer;
                connected =false;
        }
        public void run() {
                launch();
                receive();
        }
        private void launch() {
             try {
                server=new ServerSocket(puerto);
                if (server!=null)
                        socket=server.accept();
                        if (socket!=null) {
                                frameServer.setTextButton("Desconectar");
                                connected =true;
                                //recupero el objeto InetAddress correspondiente al cliente
                                InetAddress iaCliente=socket.getInetAddress();
                                //obtengo la dirección IP del cliente
                                String ipCliente=iaCliente.getHostAddress();
                                frameServer.setIPClient(ipCliente);
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
            char caracter;
            StringBuffer text= new StringBuffer("");
            String line;
            try {
                while (connected){
                    text.delete(0, text.length()); //eliminamos la cadena inmediatamente anterior
                                                    // justo después del retorno del carro para no repetir el text
                    i=in.read();//leemos la entrada
                    //caracter=(char)i; //convertimos el entero a caracter (ASCII)
                    //text.append(caracter); //lo vamos concatenando al text, el cual es de tipo bufferstring
                    while (i!=13){ //comprobamos si el caracter es el retorno de carro (enter)
                        caracter=(char)i;//lo convertimos
                        text.append(caracter); //lo concatenamos
                        i=in.read();//leemos el siguiente caracter      
                    }
                    i=in.read(); //leemos el 10 (salto de línea) pasa saber dónde termina
                                   //y comenzar la siguiente línea de text
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
