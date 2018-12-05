
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "turma")
public class Turma implements Serializable{
    @Id
    @Column
    private int codigo_disciplina;
    @Column
    private String Nome;
    @Column
    private String Cpf_aluno;

    public Turma() {
    }

    public int getCodigo_disciplina() {
        return codigo_disciplina;
    }

    public void setCodigo_disciplina(int codigo_disciplina) {
        this.codigo_disciplina = codigo_disciplina;
    }

    public String getNome() {
        return Nome;
    }

    public String getCpf_aluno() {
        return Cpf_aluno;
    }

    public void setCpf_aluno(String Cpf_aluno) {
        this.Cpf_aluno = Cpf_aluno;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    @Override
    public String toString() {
        return getNome();
    }
    
    
}
