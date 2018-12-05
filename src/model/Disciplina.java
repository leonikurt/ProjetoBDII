
package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "disciplina")
public class Disciplina {
    @Id
    private int codigo;
    @Column
    private String nome;
    @Column
    private String cfe_professor;
    @Column
    private int carga_horaria;
    @Column
    private int creditos;
    @ManyToMany(mappedBy="disciplinas")
	private Set<Aluno> alunos = new HashSet<>();

    public Disciplina() {
    }

    public Disciplina(int codigo, String nome, String cfe_professor, int carga_horaria, int creditos) {
        this.codigo = codigo;
        this.nome = nome;
        this.cfe_professor = cfe_professor;
        this.carga_horaria = carga_horaria;
        this.creditos = creditos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCfe_professor() {
        return cfe_professor;
    }

    public void setCfe_professor(String cfe_professor) {
        this.cfe_professor = cfe_professor;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return getNome(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
