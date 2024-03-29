/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationonlientickets;

import Models.Event;
import Models.Ticket;
import Services.EventService;
import Services.JdbcService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Teodora
 */
public class ListEventsByType extends javax.swing.JFrame {
    private EventService eventService = EventService.getInstance();
    private List<Event> eventsList;
    private Ticket clientsTicket;
    private List<? extends Event> events = new ArrayList<>();;
    /**
     * Creates new form ListEventsByType
     */
    public ListEventsByType() {
        initComponents();
    }
    public ListEventsByType(List<? extends Event> list,Ticket ticket) {
        events=list;
        clientsTicket = ticket;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        EventsList = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        VIPRadioButton = new javax.swing.JRadioButton();
        NoVIPRadioButton = new javax.swing.JRadioButton();
        SpinnerNumberModel value = new SpinnerNumberModel(1,1,5,1);
        NumberTicketsSpinner = new javax.swing.JSpinner(value);
        BuyButton = new javax.swing.JToggleButton();
        SelectatiLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PriceTextArea = new javax.swing.JTextArea();
        CheckPriceButton = new javax.swing.JButton();
        ReturnButton = new javax.swing.JToggleButton();
        NrTicketsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        eventsList = eventService.getEventsList();
        EventsList.setBackground(new java.awt.Color(255, 255, 0));
        EventsList.setBorder(new javax.swing.border.MatteBorder(null));
        EventsList.setFont(new java.awt.Font("Noto Sans Light", 1, 14)); // NOI18N
        EventsList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        EventsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        EventsList.setListData(events.toArray());
        jScrollPane2.setViewportView(EventsList);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Ce fel de bilete doriti ?");

        VIPRadioButton.setText("VIP");
        VIPRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIPRadioButtonActionPerformed(evt);
            }
        });

        NoVIPRadioButton.setText("Normal");
        NoVIPRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoVIPRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VIPRadioButton)
                            .addComponent(NoVIPRadioButton)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(NumberTicketsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VIPRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NoVIPRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(NumberTicketsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        BuyButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BuyButton.setText("Cumpara");
        BuyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuyButtonActionPerformed(evt);
            }
        });

        SelectatiLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SelectatiLabel.setText("Selectati un eveniment:");

        PriceTextArea.setColumns(20);
        PriceTextArea.setRows(5);
        jScrollPane1.setViewportView(PriceTextArea);

        CheckPriceButton.setText("Verifica pret");
        CheckPriceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckPriceButtonActionPerformed(evt);
            }
        });

        ReturnButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ReturnButton.setText("Renunta");
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        NrTicketsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NrTicketsLabel.setText("Nr. bilete:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(SelectatiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(NrTicketsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CheckPriceButton)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BuyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ReturnButton))
                    .addComponent(jLabel2))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SelectatiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NrTicketsLabel))
                        .addGap(18, 18, 18)
                        .addComponent(CheckPriceButton)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BuyButton)
                            .addComponent(ReturnButton))
                        .addGap(97, 97, 97))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VIPRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIPRadioButtonActionPerformed
        // TODO add your handling code here:
        if(VIPRadioButton.isSelected()){
            NoVIPRadioButton.setSelected(false);
        }
    }//GEN-LAST:event_VIPRadioButtonActionPerformed

    private void NoVIPRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoVIPRadioButtonActionPerformed
        // TODO add your handling code here:
        if(NoVIPRadioButton.isSelected()){
            VIPRadioButton.setSelected(false);
        }
    }//GEN-LAST:event_NoVIPRadioButtonActionPerformed
    private boolean validation(){
           if(!NoVIPRadioButton.isSelected() && !VIPRadioButton.isSelected())
                    return false;
           if(EventsList.isSelectionEmpty())
                    return false;
        return true;
    }
    
    private void BuyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuyButtonActionPerformed
        // TODO add your handling code here:
        if(!validation()){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(ListEventsByType.this, "Nu ati completat unul dintre campuri.",
                            "Ooops, ceva n-a mers bine!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }); 
        }
        else{
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(ListEventsByType.this, "Va dorim vizionare placuta!",
                            "Done.Ati achizitionat biletul",
                            JOptionPane.INFORMATION_MESSAGE);
                }
           });
        }
    }//GEN-LAST:event_BuyButtonActionPerformed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        // TODO add your handling code here:
        
            System.exit(0);
        
    }//GEN-LAST:event_ReturnButtonActionPerformed

    private void CheckPriceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckPriceButtonActionPerformed
        // TODO add your handling code here:
        if(!validation()){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
//                    new JFXPanel(); // this will prepare JavaFX toolkit and environment
//                    Platform.runLater(new Runnable() {
//                        @Override
//                        public void run() {
//                            Alert validationAlert = new Alert(Alert.AlertType.WARNING);
//                            validationAlert.setTitle("Ooops, ceva n-a mers bine!");
//                            validationAlert.setHeaderText(null);
//                            validationAlert.setContentText("Nu ati completat unul dintre campuri.");
//                            validationAlert.showAndWait();
//                        }
//                    });
                    JOptionPane.showMessageDialog(ListEventsByType.this, "Nu ati completat unul dintre campuri.",
                            "Ooops, ceva n-a mers bine!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }); 
            
        }
        else
        {
                if(NoVIPRadioButton.isSelected())
                clientsTicket.setVIP(false);
            else
                if(VIPRadioButton.isSelected())
                    clientsTicket.setVIP(true);

            int[] indici = EventsList.getSelectedIndices();
            for(int i=0; i < indici.length; i++){
                clientsTicket.setEvent(events.get(indici[i]));
                System.out.println(events.get(indici[i]));
            }
            System.out.println(clientsTicket);
        
        
        Integer numberOfTickets = (Integer) NumberTicketsSpinner.getValue();
        
        String sqlString;
        sqlString = "select * from events where event_id="+clientsTicket.getEvent().getId()+" ";
        System.out.println(clientsTicket.getEvent().getId());
        JdbcService jdbc = new JdbcService();
        Ticket idticket = jdbc.findClientsTicket(sqlString);
        String displayPrice = "Pret bilet normal: "+ idticket.getPrice() + "\n Pret bilet VIP: "
         + idticket.getPriceVIP() + "\n\n Pret total: ";
        if(clientsTicket.isVIP()==true)
            displayPrice+=numberOfTickets*idticket.getPriceVIP();
        else
            displayPrice+=numberOfTickets*idticket.getPrice();
        PriceTextArea.setText(displayPrice);
        }
    }//GEN-LAST:event_CheckPriceButtonActionPerformed

    public void sendOption(List<? extends Event> list){
        events=list;
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListEventsByType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListEventsByType().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BuyButton;
    private javax.swing.JButton CheckPriceButton;
    private javax.swing.JList EventsList;
    private javax.swing.JRadioButton NoVIPRadioButton;
    private javax.swing.JLabel NrTicketsLabel;
    private javax.swing.JSpinner NumberTicketsSpinner;
    private javax.swing.JTextArea PriceTextArea;
    private javax.swing.JToggleButton ReturnButton;
    private javax.swing.JLabel SelectatiLabel;
    private javax.swing.JRadioButton VIPRadioButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
