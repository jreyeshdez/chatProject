package chatClientProject.main;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ChatCliente extends Thread {
        public final String cierreDeConexion="#CERRAR_CONEXION#"; //variable pública de tipo string constante y con el valor dado.
                                                                    //se usa para comparar el texto recibido con el mensaje enviado y desconectar la conexión.
        private Socket socket; //variable privada de tipo Socket. 
                                //Sirve para abrir el canal de comunicación a través del cual un proceso puede enviar y recibir información.
        private int puerto; //variable tipo int. Para identificar el puerto.
        private InetAddress ipServidor; //variable privada de tipo InetAddress que contiene los direccionamientos locales de la máquina.
        private BufferedReader in; //variable privada de tipo BufferedReader. Se usa para leer un dato desde una entrada. (Paquete java.io)
        private PrintWriter out; //variable privada de tipo PrintWriter. Se usapara escribir un dato en una salida. (Paquete java.io)
        private boolean conectado; //variable privada de tipo lógica. Se usará para saber cuando esta el socket conectado.
        FrameCliente frameCliente; //variable de tipo FrameCliente. Se usará para poder llamar a los métodos específicos de dicha clase.

        public ChatCliente(InetAddress ipServidor,int puerto, FrameCliente frameCliente) { //método constructor, se llamará para crear el objeto con las variables que se pasan por parámetros.
                this.puerto=puerto;
                this.ipServidor=ipServidor;
                this.frameCliente=frameCliente;
                conectado=false;
        }
        public void run() { //método que es llamado cuando se inicia el Thread (hilo): cliente.start();
                iniciar();
                recibir();
        }
        private void iniciar() { //método que iniciará la comunicación: creación del socket.
             try {
                socket=new Socket(ipServidor,puerto); //se crea el socket y se le pasa por parámetros el objeto InetAddress (ipServidor) y el puerto.
                if (socket!=null) { //si el socket es null (se ha producido un error al crear el mismo) no se podrá establecer la comunicación.
                                    //si es distinto de null, querrá decir que se podido crear el mismo.
                      frameCliente.setTextoBoton("Desconectar"); //al crearse el socket, se cambiará el nombre del botón de "Conectar" a "Desconectar" de la ventana FrameCliente
                      conectado=true; //se pondrá la variable conectado a true para saber que se está conectado 
                                    //(usada en el método recibir para mientras se está conectado se reciban caractéres).
                      in=new BufferedReader(new InputStreamReader(socket.getInputStream())); //se crea el canal de entrada "in" de la clase BufferedReader que 
                                                                                            //representará el flujo de entrada de bytes a través del socket (objeto InputStream)
                      out=new PrintWriter(socket.getOutputStream(),true); //se crea el canal de salida "out" de la clase PrintWriter que 
                                                                         //representará el flujo de salida de bytes a través del socket (objeto OutputStream)
                                                                         //también se envia la palabra true (lógica) para limpiar el buffer de salida.
                }else
                      cerrar(); //si no se ha podido crear el socket se cierra el mismo (socket=null). Se cierra la conexión.
             } catch (IOException ioex) {
                     cerrar();
             }
        }
        public void cerrar() { //método para cerrar la conexión. Cerrar el socket.
             try {
                if (socket!=null) //si el socket creado en el método anterior es distinto de null
                        socket.close(); //se cierra el mismo a través del método close() del objeto socket. (Class Socket)
                if (in!=null) //si el canal de entrada creado en el método anterior es distinto de null
                        in.close();//se cierra el mismo a través del método close() del objeto in. (Class BufferedReader)
                if (out!=null)//si el canal de salida creado en el método anterior es distinto de null
                        out.close(); //se cierra el mismo a través del método close() del objeto out. (Class PrintWriter)
                conectado=false; //cambiamos la variable conectado a false, para dejar de recibir (se usa en el método recibir)
                frameCliente.setTextoBoton("Conectar"); //cambiamos el texto del botón de "Desconectar" a "Conectar" de la ventana FrameCliente
             } catch (IOException ioex) {}
        }
        public void enviar(String texto) {
            out.println(texto); //enviamos el texto que llega por parámetro 
                                //(se ha obtenido en el FrameCliente por medio del getText de la variable textoChat) a través del canal de salida out.
        }
        public void recibir() {
            int i;
            StringBuffer texto=new StringBuffer(""); 
            char caracter;
            String linea;
            while (conectado==true){ //mientras la variable conectado sea igual a true (se ha creado el socket)
                try {
                    texto.delete(0, texto.length()); //eliminamos la cadena obtenida una vez se haya enviado un retorno de carro.
                    i=in.read(); //leemos el caracter (ASCII) que llega por el canal de entrada.
                    while (i!=13){ //mientras el caracter que entra sea distinto al retorno de carro (13)
                        caracter=(char)i; //convertimos a caracter el ASCII que se recibie por el canal de entrada
                        texto.append(caracter); //añadimos a la variable de tipo StringBuffer el caracter, a través del método append.
                        i=in.read();  //volvemos a leer el canal de entrada y se comprobará en el while si se trata del retorno de carro.
                    }
                    i=in.read(); //al llegar a este punto, quiere decir que ha entrado el retorno de carro (ascii 13)
                                //por lo que volvemos a leer el canal de entrada, ya que siempre que se envía el 13 a continuación
                                //llega el 10.
                    linea=texto.toString(); //convertimos a String el texto que se ha ido concatenando en el bucle while.
                    if (linea.equalsIgnoreCase(cierreDeConexion)){ //si el texto que se forma es igual a la variable, entonces se cierra la comunicación.
                        cerrar();
                    }else{                        
                        frameCliente.setTextoChat(linea); //si no es así, se escribe dicho texto en el área de texto.
                                                            //más concretamente en textoChat de la ventana FrameCliente.
                    }
                }catch (IOException ex) 
                {
                    Logger.getLogger(ChatCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
}
