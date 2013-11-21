package chatServerProject.main;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class FrameServer extends javax.swing.JFrame {
    private ChatServer servidor;
    public FrameServer() {
        initComponents();
        updateIP();
    }
    public void setIPClient(String text){
        clientIP.setText(clientIP.getText()+text);
    }
    public void setTextButton(String text) {
        buttonConnectDisconnect.setText(text);
    }
    public void setTextChat(String text) {
        textChat.setText(text);
    }
    private void updateIP(){
        InetAddress mihost;
        try {
            mihost = InetAddress.getLocalHost();
            String hostAddress=mihost.getHostAddress();
            String text= ServerIP.getText();
            text=text+hostAddress;
            ServerIP.setText(text);
        } catch (UnknownHostException ex) {
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ServerIP = new javax.swing.JLabel();
        textPort = new javax.swing.JTextField();
        Puerto = new javax.swing.JLabel();
        clientIP = new javax.swing.JLabel();
        buttonConnectDisconnect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textChat = new javax.swing.JTextArea();
        topText = new javax.swing.JLabel();
        buttonClean = new javax.swing.JButton();
        buttonSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");

        ServerIP.setText("IP address: ");

        textPort.setColumns(10);

        Puerto.setText("Port:");

        clientIP.setText("IP Client: ");

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(topText)
                        .addGap(117, 117, 117))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonConnectDisconnect)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonSend)
                                .addGap(19, 19, 19)
                                .addComponent(buttonClean))
                            .addComponent(ServerIP)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Puerto)
                                .addGap(18, 18, 18)
                                .addComponent(textPort, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(clientIP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topText)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(ServerIP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Puerto)
                            .addComponent(textPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(clientIP)
                        .addGap(60, 60, 60)
                        .addComponent(buttonConnectDisconnect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonClean)
                            .addComponent(buttonSend)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)))
                .addGap(44, 44, 44))
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
        //cogemos el puerto y lo convertimos a entero
            String puertoS= textPort.getText();
            if (puertoS.length()!=0){
                try {
                    int puertoI=Integer.parseInt(puertoS);
                    //creamos el objeto servidor
                    servidor=new ChatServer(puertoI, this);
                    servidor.start(); //se llama así porque es un thread
                    setTextButton("Connecting..");
                    
                }catch(NumberFormatException nfe){
                    textPort.setText("");
                }
            }
        }else {
            if (buttonConnectDisconnect.getText().compareTo("Disconnect")==0){
                servidor.close();
                //servidor.send("#CERRAR_CONEXION#");
            }              
        }
    }//GEN-LAST:event_botonConectarDesconectarActionPerformed

    private void buttonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        textChat.setText("");
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void buttonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
        servidor.send(textChat.getText());
    }//GEN-LAST:event_botonEnviarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrameServer().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Puerto;
    private javax.swing.JLabel ServerIP;
    private javax.swing.JButton buttonConnectDisconnect;
    private javax.swing.JButton buttonSend;
    private javax.swing.JButton buttonClean;
    private javax.swing.JLabel clientIP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textChat;
    private javax.swing.JTextField textPort;
    private javax.swing.JLabel topText;
    // End of variables declaration//GEN-END:variables
}
