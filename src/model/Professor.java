
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor implements Serializable{
    @Id
    private String CFE;
    @Column
    private String matricula;
    @Column
    private String nome;    
    @Column
    private int codigo_departamento;

    public Professor() {
        
    }

    public Professor(String CFE, String matricula, String nome, int codigo_departamento) {
        this.CFE = CFE;
        this.matricula = matricula;
        this.nome = nome;
        this.codigo_departamento = codigo_departamento;
    }
    

    public String getCFE() {
        return CFE;
    }

    public void setCFE(String CFE) {
        this.CFE = CFE;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(int codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }

    @Override
    public String toString() {
        return getNome(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
