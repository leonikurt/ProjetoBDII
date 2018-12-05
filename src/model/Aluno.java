package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {

    @Id
    private String CPF;
    @Column
    private String nome;
    @Column
    private String rua;
    @Column
    private String CEP;
    @Column
    private int numero;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "turma",
            joinColumns = { @JoinColumn(name = "CPF_ALUNO")},
            inverseJoinColumns = { @JoinColumn(name = "CODIGO_DISCIPLINA")})
    private Set<Disciplina> disciplinas = new HashSet<>(0);

    public Aluno() {
    }

    public Aluno(String CPF, String nome, String rua, String CEP, int numero) {
        this.CPF = CPF;
        this.nome = nome;
        this.rua = rua;
        this.CEP = CEP;
        this.numero = numero;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void addDisciplina(Disciplina d){
        this.disciplinas.add(d);
    }
    
    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return getNome(); //To change body of generated methods, choose Tools | Templates.
    }

}
