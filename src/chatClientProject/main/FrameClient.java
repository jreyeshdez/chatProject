package chatClientProject.main;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class FrameClient extends javax.swing.JFrame {

    private ChatClient client;
    public FrameClient() {
        initComponents();
        updateIP();
    }
    public void setTextButton(String texto) {
        buttonConnectDisconnect.setText(texto);
    }
    public void setTextChat(String texto) {
        textChat.setText(texto);
    }
    private void updateIP(){   
        InetAddress mihost;
        try {
            mihost = InetAddress.getLocalHost(); //getLocalHost da un objeto de 
            //de tipo InetAddress, con direccionamientos locales.
            //la llamada se realiza así porque getLocalHost es un método estático
            //el cual es llamado desde otro método estático o no.
            String hostAddress=mihost.getHostAddress(); //getHostAddress da un String
            //con la dirección IP, la cual se obtiene del objeto mihost a través del
            //método getHostAddress()
            String text= clientIP.getText();//Los JLabel tienen métodos como el
            //getText() que nos guardan en una variable el text dentro de dicho Label.
            text=text+hostAddress;
            clientIP.setText(text);//al igual que getText(), los JLabel también
            //tienen métodos como el setText() que nos permiten cambiar el text
            //dentro de ese Label.
        } catch (UnknownHostException ex) {
            System.exit(0);
        }           
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        clientIP = new javax.swing.JLabel();
        textIP = new javax.swing.JTextField();
        serverIP = new javax.swing.JLabel();
        textPort = new javax.swing.JTextField();
        port = new javax.swing.JLabel();
        buttonConnectDisconnect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textChat = new javax.swing.JTextArea();
        topText = new javax.swing.JLabel();
        buttonClean = new javax.swing.JButton();
        buttonSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");

        clientIP.setText("IP address: ");

        textIP.setColumns(10);

        serverIP.setText("Server IP:");

        textPort.setColumns(10);

        port.setText("Port:");

        buttonConnectDisconnect.setText("Connect");
        buttonConnectDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConnectDisconnectActionPerformed(evt);
            }
        });

        textChat.setColumns(20);
        textChat.setLineWrap(true);
        textChat.setRows(5);
        jScrollPane1.setViewportView(textChat);

        topText.setText("Text");

        buttonClean.setText("Clean up");
        buttonClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCleanActionPerformed(evt);
            }
        });

        buttonSend.setText("Send");
        buttonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(serverIP)
                            .addComponent(port))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(clientIP)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonConnectDisconnect)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonSend)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonClean)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(275, Short.MAX_VALUE)
                .addComponent(topText)
                .addGap(107, 107, 107))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(topText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(clientIP)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serverIP))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(port))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonConnectDisconnect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonSend)
                            .addComponent(buttonClean))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConnectDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConectarDesconectarActionPerformed
        if (buttonConnectDisconnect.getText().compareTo("Connect")==0){
        //cogemos el port y lo convertimos a entero
            String puertoS= textPort.getText();
            if (puertoS.length()!=0){
                try {
                    int puertoI=Integer.parseInt(puertoS);
                    //creamos el objeto InetAddress a partir del String IP de la caja textIP
                    InetAddress obj=InetAddress.getByName(textIP.getText());
                    //creamos el objeto client
                    client =new ChatClient(obj, puertoI, this);
                    client.start(); //se llama así porque es un thread
                    setTextButton("Connecting..");
                    
                } catch (UnknownHostException ex) {
                    System.exit(0);
                    
                }catch(NumberFormatException nfe){
                    textPort.setText("");
                }
            }
        }else {
            if (buttonConnectDisconnect.getText().compareTo("Disconnect")==0){
                client.close();
                //client.send("#CERRAR_CONEXION#");
            }              
        }
    }//GEN-LAST:event_botonConectarDesconectarActionPerformed

    private void buttonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        textChat.setText("");
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void buttonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
        client.send(textChat.getText());
    }//GEN-LAST:event_botonEnviarActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrameClient().setVisible(true);
            }
        });
   
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConnectDisconnect;
    private javax.swing.JButton buttonSend;
    private javax.swing.JButton buttonClean;
    private javax.swing.JLabel clientIP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel port;
    private javax.swing.JLabel serverIP;
    private javax.swing.JTextArea textChat;
    private javax.swing.JTextField textIP;
    private javax.swing.JTextField textPort;
    private javax.swing.JLabel topText;
    // End of variables declaration//GEN-END:variables
}
