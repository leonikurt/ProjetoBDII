/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import model.Usuario;

/**
 *
 * @author Casa
 */
public class MainDepartamento extends javax.swing.JFrame {

    private Usuario user;
    public MainDepartamento() {
        initComponents();
    }

    public MainDepartamento(Usuario user) {
        initComponents();
        this.user = user;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jDpDepartamento = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMAddDisciplina = new javax.swing.JMenuItem();
        jMAlunoDisciplina = new javax.swing.JMenuItem();
        jMFormarTurma = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDpDepartamentoLayout = new javax.swing.GroupLayout(jDpDepartamento);
        jDpDepartamento.setLayout(jDpDepartamentoLayout);
        jDpDepartamentoLayout.setHorizontalGroup(
            jDpDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 762, Short.MAX_VALUE)
        );
        jDpDepartamentoLayout.setVerticalGroup(
            jDpDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );

        jMenu2.setText("Gerenciar");

        jMAddDisciplina.setText("Adicionar Disciplinas");
        jMenu2.add(jMAddDisciplina);

        jMAlunoDisciplina.setText("Adicionar Aluno a Disciplina");
        jMAlunoDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMAlunoDisciplinaActionPerformed(evt);
            }
        });
        jMenu2.add(jMAlunoDisciplina);

        jMFormarTurma.setText("Formar Turma");
        jMFormarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMFormarTurmaActionPerformed(evt);
            }
        });
        jMenu2.add(jMFormarTurma);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDpDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDpDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMFormarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMFormarTurmaActionPerformed
        final jifFormarTurma telaFormaTurma = new jifFormarTurma(this.user);
        jDpDepartamento.add(telaFormaTurma);
        telaFormaTurma.show();
        
    }//GEN-LAST:event_jMFormarTurmaActionPerformed

    private void jMAlunoDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMAlunoDisciplinaActionPerformed
        final jifCadastroAD telaCadastroAD = new jifCadastroAD(this.user);
        jDpDepartamento.add(telaCadastroAD);
        telaCadastroAD.show();
    }//GEN-LAST:event_jMAlunoDisciplinaActionPerformed
    
    private void jMAddDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:jMAddDisciplinaActionPerformed                                       
        final jifDisciplina telaDisciplina = new jifDisciplina(this.user);
        jDpDepartamento.add(telaDisciplina);
        telaDisciplina.show();
    }//GEN-LAST:event_jMAddDisciplinaActionPerformed   
    
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
            java.util.logging.Logger.getLogger(MainDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainDepartamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDpDepartamento;
    private javax.swing.JMenuItem jMAddDisciplina;
    private javax.swing.JMenuItem jMAlunoDisciplina;
    private javax.swing.JMenuItem jMFormarTurma;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
