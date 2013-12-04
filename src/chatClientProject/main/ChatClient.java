package chatClientProject.main;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ChatClient extends Thread {
        public final String closeConnection ="#CLOSE_CONNECTION#";
        private Socket socket; //socket, end-point of a two way communication link between two programs running on the network
        private int port;
        private InetAddress ipServer;
        private BufferedReader in;
        private PrintWriter out;
        private boolean connected; //to be used when it is connected
        FrameClient frameClient; //to be used for calling FrameClient's methods

        public ChatClient(InetAddress ipServer, int port, FrameClient frameClient) {
                this.port = port;
                this.ipServer = ipServer;
                this.frameClient = frameClient;
                connected = false;
        }
        public void run() {
                launch();
                receive();
        }
        private void launch() { //will start the communications with the socket
             try {
                socket=new Socket(ipServer, port); //Socket is created
                if (socket!=null) {
                      frameClient.setTextButton("Disconnect"); //button will change from Connect to Disconnect when the socket is created
                      connected =true;
                      in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                      out=new PrintWriter(socket.getOutputStream(), true);
                }else
                      close();
             } catch (IOException ioex) {
                     close();
             }
        }
        public void close() { //will close the connection
             try {
                if (socket!=null) //if the socket that was created is not null..
                        socket.close();
                if (in!=null)
                        in.close();
                if (out!=null)
                        out.close();
                connected = false;
                frameClient.setTextButton("Connect");
             } catch (IOException ioex) {}
        }
        public void send(String text) {
            out.println(text); //will send the text
        }
        public void receive() {
            int i;
            StringBuffer text=new StringBuffer("");
            char c;
            String line;
            while (connected){ //while connected is true, will get more stuff
                try {
                    text.delete(0, text.length()); //delete the string once it is sent the carriage return (ascii 13)
                    i=in.read(); //will read the ascii character
                    while (i!=13){ //while the character is different to carriage return (ascii 13)
                        c=(char)i; //convert to character
                        text.append(c); //will add the character
                        i=in.read();  //will read the next character
                    }
                    in.read(); //it means we got the carriage return, so straight away we´ll get "\n" (ascii 10)
                    line=text.toString(); //convert to String the text.
                    if (line.equalsIgnoreCase(closeConnection)){ //if it is "#CLOSE_CONNECTION#", will close the connection
                        close();
                    }else{                        
                        frameClient.setTextChat(line); //will write the text.
                    }
                }catch (IOException ex) 
                {
                    Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
}
