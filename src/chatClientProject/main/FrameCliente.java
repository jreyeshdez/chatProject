package chatClientProject.main;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrameCliente extends javax.swing.JFrame {

    private ChatCliente cliente; 
    public FrameCliente() {
        initComponents();
        actualizarMiIP();
    }
    public void setTextoBoton(String texto) {
        botonConectarDesconectar.setText(texto);
    }
    public void setTextoChat (String texto) {
        textoChat.setText(texto);
    }
    private void actualizarMiIP(){   
        InetAddress mihost;
        try {
            mihost = InetAddress.getLocalHost(); //getLocalHost da un objeto de 
            //de tipo InetAddress, con direccionamientos locales.
            //la llamada se realiza así porque getLocalHost es un método estático
            //el cual es llamado desde otro método estático o no.
            String direccion=mihost.getHostAddress(); //getHostAddress da un String
            //con la dirección IP, la cual se obtiene del objeto mihost a través del
            //método getHostAddress()
            String texto=clienteIP.getText();//Los JLabel tienen métodos como el
            //getText() que nos guardan en una variable el texto dentro de dicho Label.
            texto=texto+direccion;
            clienteIP.setText(texto);//al igual que getText(), los JLabel también
            //tienen métodos como el setText() que nos permiten cambiar el texto
            //dentro de ese Label.
        } catch (UnknownHostException ex) {
            System.exit(0);
        }           
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        clienteIP = new javax.swing.JLabel();
        textoIP = new javax.swing.JTextField();
        servidorIP = new javax.swing.JLabel();
        textoPuerto = new javax.swing.JTextField();
        puerto = new javax.swing.JLabel();
        botonConectarDesconectar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoChat = new javax.swing.JTextArea();
        tituloTexto = new javax.swing.JLabel();
        botonLimpiar = new javax.swing.JButton();
        botonEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");

        clienteIP.setText("Dirección IP: ");

        textoIP.setColumns(10);

        servidorIP.setText("IP Servidor:");

        textoPuerto.setColumns(10);

        puerto.setText("Puerto:");

        botonConectarDesconectar.setText("Conectar");
        botonConectarDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConectarDesconectarActionPerformed(evt);
            }
        });

        textoChat.setColumns(20);
        textoChat.setLineWrap(true);
        textoChat.setRows(5);
        jScrollPane1.setViewportView(textoChat);

        tituloTexto.setText("Texto");

        botonLimpiar.setText("Limpiar");
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        botonEnviar.setText("Enviar");
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
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
                            .addComponent(servidorIP)
                            .addComponent(puerto))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(clienteIP)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonConectarDesconectar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botonEnviar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonLimpiar)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(275, Short.MAX_VALUE)
                .addComponent(tituloTexto)
                .addGap(107, 107, 107))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(tituloTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(clienteIP)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(servidorIP))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(puerto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonConectarDesconectar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonEnviar)
                            .addComponent(botonLimpiar))))
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

    private void botonConectarDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConectarDesconectarActionPerformed
        if (botonConectarDesconectar.getText().compareTo("Conectar")==0){
        //cogemos el puerto y lo convertimos a entero
            String puertoS=textoPuerto.getText();
            if (puertoS.length()!=0){
                try {
                    int puertoI=Integer.parseInt(puertoS);
                    //creamos el objeto InetAddress a partir del String IP de la caja textoIP
                    InetAddress obj=InetAddress.getByName(textoIP.getText()); 
                    //creamos el objeto cliente
                    cliente=new ChatCliente(obj, puertoI, this);
                    cliente.start(); //se llama así porque es un thread
                    setTextoBoton("Conectando..");
                    
                } catch (UnknownHostException ex) {
                    System.exit(0);
                    
                }catch(NumberFormatException nfe){
                    textoPuerto.setText("");
                }
            }
        }else {
            if (botonConectarDesconectar.getText().compareTo("Desconectar")==0){
                cliente.cerrar();
                //cliente.enviar("#CERRAR_CONEXION#");
            }              
        }
    }//GEN-LAST:event_botonConectarDesconectarActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        textoChat.setText("");
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
        cliente.enviar(textoChat.getText());
    }//GEN-LAST:event_botonEnviarActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrameCliente().setVisible(true);
            }
        });
   
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConectarDesconectar;
    private javax.swing.JButton botonEnviar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JLabel clienteIP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel puerto;
    private javax.swing.JLabel servidorIP;
    private javax.swing.JTextArea textoChat;
    private javax.swing.JTextField textoIP;
    private javax.swing.JTextField textoPuerto;
    private javax.swing.JLabel tituloTexto;
    // End of variables declaration//GEN-END:variables
}
