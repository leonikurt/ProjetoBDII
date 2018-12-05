
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso implements Serializable{
    @Id()
    private int Codigo;
    @Column
    private String Nome;
    @ManyToOne
    @JoinColumn(name = "codigo_derp")
    private Departamento departamento;
    public Curso() {
    }

    public Curso(int Codigo, String Nome) {
        this.Codigo = Codigo;
        this.Nome = Nome;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    @Override
    public String toString() {
        return getNome(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
