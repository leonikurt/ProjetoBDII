/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connector.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Casa
 */
public class repositorioLogin {
    private Connection conexao;
    
    public repositorioLogin(){
        this.conexao = ConexaoDB.getConexaoDB();
    }
    
    public boolean ContaExiste(String user){
        boolean resp = false;
        try{
            this.conexao = ConexaoDB.getConexaoDB();
            try (PreparedStatement stmt = this.conexao.prepareStatement("")) {
                stmt.executeQuery("SELECT * FROM Aluno a Inner join Matricula m On a.cpf = m.cpf_aluno WHERE m.MATRICULA_ALUNO = '"+user+"'");
                try (ResultSet resultado = stmt.getResultSet()) {
                    while(resultado.next()){
                        resp = true;
                    }
                }
                ConexaoDB.closeConexaoDB(this.conexao);
            }
        }        
        catch(SQLException ex){
            
        }
        
        return resp;
    }
    
    
    
    
}
