
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rodri
 */
public class Resultado extends javax.swing.JFrame {

    ArrayList<Entidad> Entidades = new ArrayList<Entidad>();
    
    /**
     * Creates new form Resultado
     */
    public Resultado() {
        //Se inicializan los elementos de la ventana
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaRes = new javax.swing.JTextArea();
        btnFinalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Resultado");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Conversion:"));

        txtaRes.setColumns(20);
        txtaRes.setRows(5);
        jScrollPane1.setViewportView(txtaRes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFinalizar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinalizar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void Relaciones(ArrayList<Entidad> EntsAnt){
        System.out.println(EntsAnt.size());
        Entidades = (ArrayList) EntsAnt.clone();
        escribirres();
    }
    
    //Funcion que escribe el resultado en el area de texto
    public void escribirres(){
    
        txtaRes.append("A):\n");
        for(int i=0; i<Entidades.size(); i++)
        {
            txtaRes.append(Entidades.get(i).Nombre+" = { ");
            for(int j=0; j<Entidades.get(i).Atribs.size(); j++)
            {
                if(Entidades.get(i).Atribs.get(j).Pri && Entidades.get(i).Atribs.get(j).For)
                    txtaRes.append("°PF°"+Entidades.get(i).Atribs.get(j).Nombre+", ");
                else if(Entidades.get(i).Atribs.get(j).Pri)
                    txtaRes.append("°P°"+Entidades.get(i).Atribs.get(j).Nombre+", ");
                else if(Entidades.get(i).Atribs.get(j).For)
                    txtaRes.append("°F°"+Entidades.get(i).Atribs.get(j).Nombre+", ");
                else
                    txtaRes.append(Entidades.get(i).Atribs.get(j).Nombre+", ");
            }
            txtaRes.append("}\n");
        }
        txtaRes.append("\n");
        
        boolean ExisTip=false;
        for(int i=0; i<Entidades.size(); i++)
        {
            if(Entidades.get(i).Esp=='T')
            {
                Atributo NewEnt = new Atributo(Entidades.get(i).Nombre, false, false);
                Entidades.get(Entidades.indexOf(Entidades.get(i).Padre)).Atribs.add(NewEnt);
                for(int j=0; j<Entidades.get(i).Atribs.size(); j++)
                {
                    if(!Entidades.get(i).Atribs.get(j).Pri)
                    {
                        Atributo NewAtri = new Atributo(Entidades.get(i).Atribs.get(j).Nombre, false, false);
                        Entidades.get(Entidades.indexOf(Entidades.get(i).Padre)).Atribs.add(NewAtri);
                    }
                }
                Entidades.remove(i);
                i--;
            }
            else if(Entidades.get(i).Esp=='D')
            {
                for(int j=0; j<Entidades.get(i).Padre.Atribs.size(); j++)
                {
                    if(Entidades.get(i).Padre.Atribs.get(j).Nombre == "Tipo")
                        ExisTip=true;
                }
                if(!ExisTip)
                {
                    Atributo NewTipo = new Atributo("Tipo", false, false);
                    Entidades.get(Entidades.indexOf(Entidades.get(i).Padre)).Atribs.add(NewTipo);
                }
                for(int k=0; k<Entidades.get(i).Atribs.size(); k++)
                {
                    if(!Entidades.get(i).Atribs.get(k).Pri)
                    {
                        Atributo NewAtri = new Atributo(Entidades.get(i).Atribs.get(k).Nombre, false, false);
                        Entidades.get(Entidades.indexOf(Entidades.get(i).Padre)).Atribs.add(NewAtri);
                    }
                }
                Entidades.remove(i);
                i--;
            }
        }
        
        txtaRes.append("B):\n");
        for(int i=0; i<Entidades.size(); i++)
        {
            txtaRes.append(Entidades.get(i).Nombre+" = { ");
            for(int j=0; j<Entidades.get(i).Atribs.size(); j++)
            {
                if(Entidades.get(i).Atribs.get(j).Pri && Entidades.get(i).Atribs.get(j).For)
                    txtaRes.append("°PF°"+Entidades.get(i).Atribs.get(j).Nombre+", ");
                else if(Entidades.get(i).Atribs.get(j).Pri)
                    txtaRes.append("°P°"+Entidades.get(i).Atribs.get(j).Nombre+", ");
                else if(Entidades.get(i).Atribs.get(j).For)
                    txtaRes.append("°F°"+Entidades.get(i).Atribs.get(j).Nombre+", ");
                else
                    txtaRes.append(Entidades.get(i).Atribs.get(j).Nombre+", ");
            }
            txtaRes.append("}\n");
        }
        txtaRes.append("\n");
    }
    
    //Accion al presionar el boton "Finalizar"
    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
       
        System.exit(0);
        
    }//GEN-LAST:event_btnFinalizarActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Resultado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtaRes;
    // End of variables declaration//GEN-END:variables
}
