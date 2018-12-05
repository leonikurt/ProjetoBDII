/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Connector.HibernateUtil;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import model.Departamento;
import model.Usuario;
import org.hibernate.Query;

/**
 *
 * @author Casa
 */
public class jifDepartamento extends javax.swing.JInternalFrame {

    public Departamento[] dt = new Departamento[100];

    private Usuario user;
    
    public jifDepartamento() {
        initComponents();
        allDepartamentos();
    }
    
    public jifDepartamento(Usuario user) {
        initComponents();
        this.user = user;
        CheckUser();
        allDepartamentos();
    }
    
    public void CheckUser(){
        String tipo = this.user.getTipo();
        if(tipo.compareTo("comum") == 0){
            jBtCadastrar.setEnabled(false);
            jBtRemover.setEnabled(false);
        }
        
    }

    public boolean checkFields() {
        boolean resp = false;

        if (jTfNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite o nome!");
        } else if (jCbDepartamento.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Selecione um departamento!");
        } else {
            resp = true;
        }

        return resp;
    }

    public String createSQLSelect() {
        String sql = "Select d from Departamento d ";
        String where = " where ";
        String join = " ";
        boolean whereFlag = false;
        if (!jTfNome.getText().isEmpty()) {
            where = where + " d.nome = '" + jTfNome.getText() + "'";
            whereFlag = true;
        }

        if (whereFlag) {
            sql = sql + where;
        }
//        JOptionPane.showMessageDialog(null,sql);
        return sql;
    }

    public void allDepartamentos() {
        String sql = "from Departamento d";

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery(sql);
        List<Departamento> results = (List<Departamento>) query.list();
        int index = 0;
        for (Departamento d : results) {
            this.dt[index] = d;
            jCbDepartamento.addItem(d);
        }

        session.close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTfNome = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListDepartamentos = new javax.swing.JList<>();
        jBtCadastrar = new javax.swing.JButton();
        jCbDepartamento = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jBtSelecionar = new javax.swing.JButton();
        jBtRemover = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Departamento");

        jLabel1.setText("Nome :");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jScrollPane1.setViewportView(jListDepartamentos);

        jBtCadastrar.setText("Cadastrar");
        jBtCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCadastrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Departamentos :");

        jBtSelecionar.setText("Selecionar");
        jBtSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSelecionarActionPerformed(evt);
            }
        });

        jBtRemover.setText("Remover");
        jBtRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRemoverActionPerformed(evt);
            }
        });

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtSelecionar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBtCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jBtRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtCadastrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtSelecionar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)))
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCadastrarActionPerformed
//        JOptionPane.showMessageDialog(null, "Digite o nome!");
        if (checkFields()) {

            SessionFactory af = HibernateUtil.getSessionFactory();
            Session session = af.openSession();
            try {

                Departamento d = new Departamento();

                d.setNome(jTfNome.getText());

                Transaction tx = session.beginTransaction();

                session.saveOrUpdate(d);

                tx.commit();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } finally {
                session.flush();

                session.close();
            }
        }
    }//GEN-LAST:event_jBtCadastrarActionPerformed

    private void jBtRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRemoverActionPerformed
        Departamento d = (Departamento) jCbDepartamento.getSelectedItem();
        if (d != null) {
            SessionFactory af = HibernateUtil.getSessionFactory();
            Session session = af.openSession();
            try {

                String hql = "DELETE FROM Departamento "
                        + "WHERE codigo = :codigo";

                Query query = session.createQuery(hql);
                query.setInteger("codigo", d.getCodigo());

                Transaction tx = session.beginTransaction();

                int result = query.executeUpdate();

                tx.commit();

                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Departamento removido");
                } else {
                    throw new Exception("Houve um problema na remoção");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } finally {
                session.flush();

                session.close();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Departamento");
        }
    }//GEN-LAST:event_jBtRemoverActionPerformed

    private void jBtSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionarActionPerformed
        Departamento a = (Departamento) jCbDepartamento.getSelectedItem();
//        JOptionPane.showMessageDialog(null, a.getNome());
        jTfNome.setText(a.getNome());
//        jTfCEP.setText(a.getCEP());
//        jTfCPF.setText(a.getCPF());
//        jTfNumero.setText(Integer.toString(a.getNumero()));
//        jTfRua.setText(a.getRua());      
    }//GEN-LAST:event_jBtSelecionarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultListModel lista = new DefaultListModel();
        String sql = createSQLSelect();
        if (sql.isEmpty()) {
            sql = "from Departamento d";
        }
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery(sql);

        List<Departamento> results = (List<Departamento>) query.list();
        for (Departamento d : results) {
            lista.addElement(d.getNome());
        }

        jListDepartamentos.setModel(lista);

        session.close();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtCadastrar;
    private javax.swing.JButton jBtRemover;
    private javax.swing.JButton jBtSelecionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<Object> jCbDepartamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<Object> jListDepartamentos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTfNome;
    // End of variables declaration//GEN-END:variables
}
