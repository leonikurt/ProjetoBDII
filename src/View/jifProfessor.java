/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Connector.HibernateUtil;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.GenericJDBCException;

public class jifProfessor extends javax.swing.JInternalFrame {

    public Departamento[] dt = new Departamento[100];
    private Usuario user;
    
    public jifProfessor() {
        initComponents();
        allProfessores();
        allDepartamentos();
    }
    
    public jifProfessor(Usuario user) {
        initComponents();
        this.user = user;
        
        CheckUser();
        
        allProfessores();
        allDepartamentos();
    }
    
    
    public void CheckUser(){
        String tipo = this.user.getTipo();
        if(tipo.compareTo("comum") == 0){
            btnCadastrar.setEnabled(false);
            jBtRemover.setEnabled(false);
        }
        
    }

    public void allProfessores() {
        String sql = "from Professor p";

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery(sql);
        List<Professor> results = (List<Professor>) query.list();

        for (Professor p : results) {
            jCbProfessores.addItem(p);
        }

        session.close();
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
            jCbDepartamento.addItem(d.getNome());
            index ++;
        }

        session.close();
    }

    public String createSQLSelect() {
        String sql = "Select a from Professor a ";
        String where = " where ";
        String join = " ";
        boolean whereFlag = false;
        if (!jTfNome.getText().isEmpty()) {
            where = where + " a.nome = '" + jTfNome.getText() + "'";
            whereFlag = true;
        }
        if (!jTfCfe.getText().isEmpty()) {
            if (whereFlag) {
                where = where + " and ";
            }
            where = where + " a.CFE = '" + jTfCfe.getText() + "'";
            whereFlag = true;
        }
        if (!jTfMatricula.getText().isEmpty()) {
            if (whereFlag) {
                where = where + " and ";
            }
            where = where + " a.matricula = " + jTfMatricula.getText();
            whereFlag = true;
        }
        if (whereFlag) {
            sql = sql + where;
        }
//        JOptionPane.showMessageDialog(null,sql);
        return sql;
    }

    public boolean checkFields() {
        boolean resp = false;

        if (jTfNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite o nome!");
        } else if (jTfCfe.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite o cfe!");
        } else if (jTfMatricula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite a matricula!");
        } else if (jCbDepartamento.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Escolha o departamento!");
        } else {
            resp = true;
        }

        return resp;
    }

    public int findIndex(int codigo) {
        int index = 0;
        int tam = jCbDepartamento.getItemCount();
        while (index < tam) {
            Departamento d = (Departamento) jCbDepartamento.getItemAt(index);
            JOptionPane.showMessageDialog(null, d.getNome());
            index++;
        }
        return index;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLbNome = new javax.swing.JLabel();
        jTfNome = new javax.swing.JTextField();
        jLbCfe = new javax.swing.JLabel();
        jTfCfe = new javax.swing.JTextField();
        jLbMatricula = new javax.swing.JLabel();
        jTfMatricula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCbDepartamento = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jBtConsultar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLbProfessores = new javax.swing.JLabel();
        jCbProfessores = new javax.swing.JComboBox<>();
        jBtSelect = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        jBtRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListProfessor = new javax.swing.JList<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("Professor");

        jLbNome.setText("Nome");

        jLbCfe.setText("CFE");

        jLbMatricula.setText("Matricula");

        jLabel3.setText("Departamento");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jBtConsultar.setText("Consular");
        jBtConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConsultarActionPerformed(evt);
            }
        });

        jLbProfessores.setText("Professores");

        jBtSelect.setText("Selecionar");
        jBtSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSelectActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar/Aterar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jBtRemover.setText("Remover");
        jBtRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRemoverActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jListProfessor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLbMatricula)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTfMatricula, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLbNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTfNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLbCfe)
                            .addComponent(jTfCfe, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLbProfessores)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCbProfessores, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLbNome)
                            .addComponent(jLbCfe))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTfCfe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLbMatricula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(btnCadastrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtConsultar))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLbProfessores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCbProfessores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtSelect))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtRemover)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConsultarActionPerformed
        DefaultListModel lista = new DefaultListModel();
        String sql = createSQLSelect();
        if (sql.isEmpty()) {
            sql = "from Professor p";
        }
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery(sql);

        List<Professor> results = (List<Professor>) query.list();
        for (Professor p : results) {
            lista.addElement(p.getNome());
        }

        jListProfessor.setModel(lista);

        session.close();
    }//GEN-LAST:event_jBtConsultarActionPerformed

    private void jBtSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelectActionPerformed
        Professor a = (Professor) jCbProfessores.getSelectedItem();
//        JOptionPane.showMessageDialog(null, a.getNome());
        jTfNome.setText(a.getNome());
        jTfCfe.setText(a.getCFE());
        jTfMatricula.setText(a.getMatricula());

//        DepartamentoMain d = (DepartamentoMain) session.get(DepartamentoMain.class, a.getCodigo_departamento());
//        int i = findIndex(a.getCodigo_departamento());
//        jCbDepartamento.setSelectedIndex(a.getCodigo_departamento() - 1);
        int tam = jCbDepartamento.getItemCount();

        for (int index = 0; index < tam; index++) {
            if (this.dt[index].getCodigo() == a.getCodigo_departamento()) {
                
                jCbDepartamento.setSelectedIndex(index);
            }
        }


    }//GEN-LAST:event_jBtSelectActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (checkFields()) {
            try {
                    SessionFactory af = HibernateUtil.getSessionFactory();
                    Session session = af.openSession();
                    Transaction tx = session.beginTransaction();
                try {


                        Professor a = new Professor();
                        a.setNome(jTfNome.getText());
                        a.setCFE(jTfCfe.getText());
                        a.setMatricula(jTfMatricula.getText());

                        Departamento d = new Departamento();
                        //            a.setCodigo_departamento(d.getCodigo());

                        int tam = jCbDepartamento.getItemCount();
                        String name = jCbDepartamento.getSelectedItem().toString();
                        for (int index = 0; index < tam; index++) {
                            if (this.dt[index].getNome().compareTo(name) == 0) {
                                d = this.dt[index];
                                break;
                            }
                        }

                        a.setCodigo_departamento(d.getCodigo());

                        session.saveOrUpdate(a);

                        tx.commit();

                } catch(GenericJDBCException e){                 
                    JOptionPane.showMessageDialog(null,e.getCause().getMessage());
//                af.getCurrentSession().getTransaction().rollback();
                } catch (Exception e) {
                    af.getCurrentSession().getTransaction().rollback();
                } finally{
                    session.flush();
                    session.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void jBtRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRemoverActionPerformed
        try{
            SessionFactory af = HibernateUtil.getSessionFactory();
            Session session = af.openSession();
            Transaction tx = session.beginTransaction();
            try{
                Professor a = (Professor) jCbProfessores.getSelectedItem();
                if (a != null) {


                    String hql = "DELETE FROM Professor "
                            + "WHERE CFE = :cfe";

                    Query query = session.createQuery(hql);
                    query.setString("cfe", a.getCFE());



                    int result = query.executeUpdate();

                   

                    if (result > 0) {
                        JOptionPane.showMessageDialog(null, "Professor removido");
                    } else {
                        throw new Exception("Houve um problema na remoção");
                    }

                     tx.commit();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um Professor");
                }
            } catch (Exception e){
                af.getCurrentSession().getTransaction().rollback();
            } finally{
                session.flush();
                session.close();
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ococrreu um erro fatal!");
        }
    }//GEN-LAST:event_jBtRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton jBtConsultar;
    private javax.swing.JButton jBtRemover;
    private javax.swing.JButton jBtSelect;
    private javax.swing.JComboBox<Object> jCbDepartamento;
    private javax.swing.JComboBox<Object> jCbProfessores;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLbCfe;
    private javax.swing.JLabel jLbMatricula;
    private javax.swing.JLabel jLbNome;
    private javax.swing.JLabel jLbProfessores;
    private javax.swing.JList<Object> jListProfessor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTfCfe;
    private javax.swing.JTextField jTfMatricula;
    private javax.swing.JTextField jTfNome;
    // End of variables declaration//GEN-END:variables
}
