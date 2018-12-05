
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "historico")
public class Historico {
    
    @Id
    @Column
    private String cpf_aluno;
    @Column
    private int codigo_curso;
    @Column
    private float nota_final;
    @Column
    private String data_cursada;

    public Historico() {
    }

    public String getCpf_aluno() {
        return cpf_aluno;
    }

    public void setCpf_aluno(String cpf_aluno) {
        this.cpf_aluno = cpf_aluno;
    }

    public int getCodigo_curso() {
        return codigo_curso;
    }

    public void setCodigo_curso(int codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

    public float getNota_final() {
        return nota_final;
    }

    public void setNota_final(float nota_final) {
        this.nota_final = nota_final;
    }

    public String getData_cursada() {
        return data_cursada;
    }

    public void setData_cursada(String data_cursada) {
        this.data_cursada = data_cursada;
    }
    
    
}
