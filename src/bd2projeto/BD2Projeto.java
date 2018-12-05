

package bd2projeto;
import Connector.HibernateUtil;
import java.util.List;
import model.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BD2Projeto {

    public static void main(String[] args) {
        
        SessionFactory sf = HibernateUtil.getSessionFactory(); 
        Session session = sf.openSession();
        
//        Aluno a = new Aluno();
        Transaction tx = session.beginTransaction();
        
        Query query = session.createSQLQuery("Select * from Turma");        
//        Query query = session.createQuery("from Turma t");
//        Query query = session.createSQLQuery("CALL InsertTurma()");
//        query.setString("cfe", "123123");
//        List<Professor> results = (List<Professor>)query.list();
//        List<Turma> results = (List<Turma>)query.list();
        List<Turma> s = (List<Turma>) query.list();
        Turma teste = new Turma();
        teste.setCodigo_disciplina(s.get(0).getCodigo_disciplina());
        System.out.println();
        for(Turma d: s){
            System.out.println(d.getNome());
        }
        
        
        tx.commit();
        session.flush();
        
        session.close();
    }
    
}
