package chatServerProject.main;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ChatServidor extends Thread {
        public final String cierreDeConexion="#CERRAR_CONEXION#";
        private ServerSocket server;
        private Socket socket;
        private int puerto;
        private BufferedReader in;
        private PrintWriter out;
        private boolean conectado;
        private FrameServidor frameServidor;
        
        public ChatServidor(int puerto, FrameServidor frameServidor) {
                this.puerto=puerto;
                this.frameServidor=frameServidor;
                conectado=false;
        }
        public void run() {
                iniciar();
                recibir();
        }
        private void iniciar() {
             try {
                server=new ServerSocket((int)puerto);
                if (server!=null)
                        socket=server.accept();
                        if (socket!=null) {
                                frameServidor.setTextoBoton("Desconectar");
                                conectado=true;
                                //recupero el objeto InetAddress correspondiente al cliente
                                InetAddress iaCliente=socket.getInetAddress();
                                //obtengo la dirección IP del cliente
                                String ipCliente=iaCliente.getHostAddress();
                                frameServidor.setIPCliente(ipCliente);
                                in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                out=new PrintWriter(socket.getOutputStream(),true);
                        } else
                                cerrar();
             } catch (IOException ioex) {
                     cerrar();
             } catch (IllegalArgumentException iae) {
                     cerrar();
             }
        }
        public void cerrar() {
             try {
                if (server!=null)
                        server.close();
                if (socket!=null)
                        socket.close();
                if (in!=null)
                        in.close();
                if (out!=null)
                        out.close();
                conectado=false;
                frameServidor.setTextoBoton("Conectar");
             } catch (IOException ioex) {}
        }
        public void enviar(String texto) {
            out.println(texto);
        }
        public void recibir() {
            int i;
            char caracter;
            StringBuffer texto= new StringBuffer("");
            String linea;
            try {
                while (conectado==true){
                    texto.delete(0, texto.length()); //eliminamos la cadena inmediatamente anterior
                                                    // justo después del retorno del carro para no repetir el texto
                    i=in.read();//leemos la entrada
                    //caracter=(char)i; //convertimos el entero a caracter (ASCII)
                    //texto.append(caracter); //lo vamos concatenando al texto, el cual es de tipo bufferstring                 
                    while (i!=13){ //comprobamos si el caracter es el retorno de carro (enter)
                        caracter=(char)i;//lo convertimos
                        texto.append(caracter); //lo concatenamos
                        i=in.read();//leemos el siguiente caracter      
                    }
                    i=in.read(); //leemos el 10 (salto de línea) pasa saber dónde termina
                                   //y comenzar la siguiente línea de texto
                    linea=texto.toString();
                    if (linea.equalsIgnoreCase(cierreDeConexion)){
                        cerrar();
                    }else{                        
                        frameServidor.setTextoChat(linea); 
                    }
                }
            }catch (IOException ex) {
                    cerrar();
            }
        }
}
