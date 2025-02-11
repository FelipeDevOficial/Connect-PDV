/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.jdbc.ConexaoBanco;
import br.com.sistema.model.Clientes;
import br.com.sistema.model.Funcionarios;
import br.com.sistema.view.AreaTrabalho;
import br.com.sistema.view.FormularioLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dacru
 */
public class FuncionariosDAO {
    private Connection conn;
    
    public FuncionariosDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    
    
    public void Salvar (Funcionarios obj) {
        try {
            //1º criar o sql
            String sql = "insert into tb_funcionarios (nome, rg, cpf, email, senha, cargo, nivel_acesso, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)"
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            //2ª preparar a conexcao SQL oara se cinectar com o banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getEstado());
            //3º executar sql
            stmt.execute();
            //4º Fecha conexao
            stmt.close();    
            JOptionPane.showMessageDialog(null, "funcionário salvo com sucesso!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao slvar o funcionário" + erro);
        }
  
    }
    public void Editar (Funcionarios obj) {
        try {
            //1º criar o sql
            String sql = "update tb_funcionarios set nome=?, rg = ?, cpf=?, email=?, senha=?, cargo=?, nivel_acesso=?, telefone=?, celular=?, cep=?, endereco=?," 
                    +"numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?"; 
            //2ª preparar a conexcao SQL oara se cinectar com o banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getEstado());
            stmt.setInt(17, obj.getId());
            //3º executar sql
            stmt.execute();
            //4º Fecha conexao
            stmt.close();    
            JOptionPane.showMessageDialog(null, "Funcionário editado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o funcionário:   " + erro);
        }
    }
    public void Excluir(Clientes obj) {
        try {
            String sql = "delete from tb_funcionarios where id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Funcionário excluido com sucesso.");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o funcionário." + e);
        }
}

    public Clientes BuscarFuncionarios(String nome){
        try {
            String sql = "select * from tb_funcionarios where nome = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Clientes obj = new Clientes();
            if (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setEmail(rs.getString("senha"));
                obj.setEmail(rs.getString("cargo"));
                obj.setEmail(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
            }
            return obj;
                
        } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Erro as buscar cliente" + erro);
    }
    return null;
}
    public List<Funcionarios> listar(){
        List<Funcionarios> lista = new ArrayList<>();
        try {
            String sql = "select * from tb_funcionarios";
            PreparedStatement stmt =  conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
              Funcionarios obj = new Funcionarios();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                lista.add(obj);            
                
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro  ao criar a lista: " + e);
        }
        return null;
    } 
    
    public List<Funcionarios> Filtrar(String nome){
        List<Funcionarios> lista = new ArrayList<>();
        try {
            String sql = "select * from tb_funcionarios where nome like ?";
            PreparedStatement stmt =  conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
               Funcionarios obj = new Funcionarios();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                lista.add(obj);
                
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro  ao criar a lista: " + e);
        }
        return null;
    }
    public void efetuarLogin(String email, String senha){
        try {
            String sql = "select * from tb_funcionarios where email=? and senha=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                
               if(rs.getString("nivel_Acesso").equals("Administrador")){
                AreaTrabalho at = new AreaTrabalho();
                at.usuarioLogado = rs.getString("nome");
                at.txtNivelAcesso.setText("Administrador");
                JOptionPane.showMessageDialog(null, "Bem vindo ao sistema!\n" + at.usuarioLogado);
                at.setVisible(true);                
                FormularioLogin lg = new FormularioLogin();
                lg.dispose();
                
               }else if(rs.getString("nivel_Acesso").equals("Usuário")){
                   
                AreaTrabalho at = new AreaTrabalho();
                at.usuarioLogado = rs.getString("nome");
                at.txtNivelAcesso.setText("Usuário");
                at.menu_funcionario.setEnabled(false);
                at.menu_fornecedores.setEnabled(false);
                at.menu_estoque.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Bem vindo ao sistema!\n" + at.usuarioLogado);
                at.setVisible(true);         
               
                FormularioLogin lg = new FormularioLogin();
                lg.dispose();
                
               }

            }else{
                //FormularioLogin login = new FormularioLogin();
                JOptionPane.showMessageDialog(null, "Dados inválidos!");                
                new FormularioLogin().setVisible(false);
                new FormularioLogin().setVisible(true);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
}
    
    
}  