package View;

import Connector.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Aluno;
import model.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class jifAluno extends javax.swing.JInternalFrame {

    private Usuario user;
    public jifAluno() {

        initComponents();
        getAll();
    }
    
    public jifAluno(Usuario user){
        
        initComponents();        
        this.user = user;   
        CheckUser();     
        getAll();
    }

    public void CheckUser(){
        String tipo = this.user.getTipo();
        if(tipo.compareTo("comum") == 0){
            btnCadastrar.setEnabled(false);
            jBtDelete.setEnabled(false);
        }
        
    }
    public String createSQLSelect() {
        String sql = "Select a from Aluno a ";
        String where = " where ";
        String join = " ";
        boolean whereFlag = false;
        if (!jTfNome.getText().isEmpty()) {
            where = where + " a.nome = '" + jTfNome.getText() + "'";
            whereFlag = true;
        }
        if (!jTfCPF.getText().isEmpty()) {
            if (whereFlag) {
                where = where + " and ";
            }
            where = where + " a.CPF = '" + jTfCPF.getText() + "'";
            whereFlag = true;
        }
        if (!jTfNumero.getText().isEmpty()) {
            if (whereFlag) {
                where = where + " and ";
            }
            where = where + " a.numero = " + jTfNumero.getText();
            whereFlag = true;
        }
        if (!jTfRua.getText().isEmpty()) {
            if (whereFlag) {
                where = where + " and ";
            }
            where = where + " a.rua = '" + jTfRua.getText() + "'";
            whereFlag = true;
        }
        if (!jTfCEP.getText().isEmpty()) {
            if (whereFlag) {
                where = where + " and ";
            }
            where = where + " a.CEP = '" + jTfCEP.getText() + "'";
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
        } else if (jTfCPF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite o cpf!");
        } else if (jTfNumero.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite o numero!");
        } else if (jTfRua.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite a rua!");
        } else if (jTfCEP.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite o cep!");
        } else {
            resp = true;
        }

        return resp;
    }

    public void getAll() {
        String sql = "from Aluno a";

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery(sql);
        List<Aluno> results = (List<Aluno>) query.list();

        for (Aluno a : results) {
            jCbAlunos.addItem(a);
        }

        session.close();
    }

    public void insert(Aluno a) {
        SessionFactory af = HibernateUtil.getSessionFactory();
        Session session = af.openSession();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListAluno = new javax.swing.JList<>();
        jBtConsultar = new javax.swing.JButton();
        jLbNome = new javax.swing.JLabel();
        jTfNome = new javax.swing.JTextField();
        jLbCPF = new javax.swing.JLabel();
        jTfCPF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTfRua = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTfNumero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTfCEP = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        jBtSelect = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jCbAlunos = new javax.swing.JComboBox<>();
        jBtDelete = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Alunos");

        jScrollPane1.setViewportView(jListAluno);

        jBtConsultar.setText("Consultar");
        jBtConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConsultarActionPerformed(evt);
            }
        });

        jLbNome.setText("Nome");

        jLbCPF.setText("CPF");

        jLabel1.setText("Rua");

        jLabel2.setText("Numero");

        jTfNumero.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel3.setText("CEP");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jBtSelect.setText("Selecionar");
        jBtSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSelectActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jBtDelete.setText("Remover");
        jBtDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnCadastrar)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLbNome)
                                    .addComponent(jTfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                    .addComponent(jLabel1)
                                    .addComponent(jTfRua))
                                .addGap(24, 24, 24)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLbCPF)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jTfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jTfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtConsultar)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCbAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbNome)
                    .addComponent(jLbCPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConsultar)
                    .addComponent(btnCadastrar))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtSelect)
                    .addComponent(jCbAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtDelete)
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConsultarActionPerformed
        DefaultListModel lista = new DefaultListModel();
        String sql = createSQLSelect();
        if (sql.isEmpty()) {
            sql = "from Aluno a";
        }
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery(sql);

        List<Aluno> results = (List<Aluno>) query.list();
        for (Aluno a : results) {
            lista.addElement(a.getNome());
        }

        jListAluno.setModel(lista);

        session.close();
    }//GEN-LAST:event_jBtConsultarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (checkFields()) {
            try {

                SessionFactory af = HibernateUtil.getSessionFactory();
                Session session = af.openSession();
                try {
                    Aluno a = new Aluno();
                    a.setNome(jTfNome.getText());
                    a.setCPF(jTfCPF.getText());
                    a.setNumero(Integer.parseInt(jTfNumero.getText()));
                    a.setRua(jTfRua.getText());
                    a.setCEP(jTfCEP.getText());

                    Transaction tx = session.beginTransaction();

                    session.saveOrUpdate(a);

                    tx.commit();
                } catch (Exception e) {
                    af.getCurrentSession().getTransaction().rollback();
                } finally {
                    session.flush();
                    session.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ococrreu um erro fatal!");
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void jBtSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelectActionPerformed
        Aluno a = (Aluno) jCbAlunos.getSelectedItem();
//        JOptionPane.showMessageDialog(null, a.getNome());
        jTfNome.setText(a.getNome());
        jTfCEP.setText(a.getCEP());
        jTfCPF.setText(a.getCPF());
        jTfNumero.setText(Integer.toString(a.getNumero()));
        jTfRua.setText(a.getRua());
    }//GEN-LAST:event_jBtSelectActionPerformed

    private void jBtDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDeleteActionPerformed
        try {
            SessionFactory af = HibernateUtil.getSessionFactory();
            Session session = af.openSession();
            Transaction tx = session.beginTransaction();

            try {
                Aluno a = (Aluno) jCbAlunos.getSelectedItem();
                if (a != null) {

                    String hql = "DELETE FROM Aluno "
                            + "WHERE CPF = :cpf";

                    Query query = session.createQuery(hql);
                    query.setString("cpf", a.getCPF());

                    int result = query.executeUpdate();

                    if (result > 0) {
                        JOptionPane.showMessageDialog(null, "Aluno removido");
                    } else {
                        throw new Exception("Houve um problema na remoção");

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um Aluno");
                }
                tx.commit();
            } catch (Exception e) {
                af.getCurrentSession().getTransaction().rollback();
            } finally {
                session.flush();
                session.close();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_jBtDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton jBtConsultar;
    private javax.swing.JButton jBtDelete;
    private javax.swing.JButton jBtSelect;
    private javax.swing.JComboBox<Object> jCbAlunos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLbCPF;
    private javax.swing.JLabel jLbNome;
    private javax.swing.JList<Aluno> jListAluno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTfCEP;
    private javax.swing.JTextField jTfCPF;
    private javax.swing.JTextField jTfNome;
    private javax.swing.JTextField jTfNumero;
    private javax.swing.JTextField jTfRua;
    // End of variables declaration//GEN-END:variables
}
