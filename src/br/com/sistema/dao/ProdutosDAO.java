/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.jdbc.ConexaoBanco;
import br.com.sistema.model.Fornecedores;
import br.com.sistema.model.Produtos;
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
public class ProdutosDAO {
    private Connection conn;
    
    public ProdutosDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    
    
    public void Salvar (Produtos obj) {
        try {
            //1º criar o sql
            String sql = "insert into tb_produtos (descricao,cod_barras, preco, qtd_estoque, for_id)"
                    + "values(?, ?, ?, ?, ?)";
            //2ª preparar a conexcao SQL oara se cinectar com o banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setString(2, obj.getCod_barras());
            stmt.setDouble(3, obj.getPreco());
            stmt.setInt(4, obj.getQtd_estoque());
            stmt.setInt(5, obj.getFornecedores().getId());
            //3º executar sql
            stmt.execute();
            //4º Fecha conexao
            stmt.close();    
            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao slvar o produto!" + erro);
        } catch (Exception br) {
            JOptionPane.showMessageDialog(null,"Erro desconhecido.  " + br);
        }
  
    }
    public void Editar (Produtos obj) {
        try {
            //1º criar o sql
            String sql = "update tb_produtos set descricao = ?, cod_barras = ?, preco = ?, qtd_estoque=?, for_id=? where id=?"; 
            //2ª preparar a conexcao SQL oara se cinectar com o banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setString(2, obj.getCod_barras());
            stmt.setDouble(3, obj.getPreco());
            stmt.setInt(4, obj.getQtd_estoque());
            stmt.setInt(5, obj.getFornecedores().getId());
            stmt.setInt(6, obj.getId());
            //3º executar sql
            stmt.execute();
            //4º Fecha conexao
            stmt.close();    
            JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o Produto:   " + erro);
        } catch(Exception br) {
            JOptionPane.showMessageDialog(null, "Exceção não conhecida" + br);
        }
        
    }

    public void Excluir(Produtos obj) {
    try {
        // 1º criar o sql
        // Primeiro, precisamos remover todas as referências a este produto na tabela tb_itensvendas
        String sqlDeleteFromItensVendas = "DELETE FROM tb_itensvendas WHERE produto_id = ?";
        PreparedStatement stmtDeleteFromItensVendas = conn.prepareStatement(sqlDeleteFromItensVendas);
        stmtDeleteFromItensVendas.setInt(1, obj.getId());
        stmtDeleteFromItensVendas.execute();
        stmtDeleteFromItensVendas.close();

        // Agora, podemos excluir o produto da tabela tb_produtos
        String sqlDeleteFromProdutos = "DELETE FROM tb_produtos WHERE id = ?";
        PreparedStatement stmtDeleteFromProdutos = conn.prepareStatement(sqlDeleteFromProdutos);
        stmtDeleteFromProdutos.setInt(1, obj.getId());
        stmtDeleteFromProdutos.execute();
        stmtDeleteFromProdutos.close();

        JOptionPane.showMessageDialog(null, "Produto excluído com sucesso.");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao excluir o Produto." + e);
    } catch (Exception br) {
        JOptionPane.showMessageDialog(null, "Exceção não esperada. " + br);
    }
}

    
    public Produtos BuscarProdutos(String descricao){
        try {
            
             String sql = "select p.id, p.descricao, p.cod_barras, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                   + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, descricao);
            ResultSet rs = stmt.executeQuery();
            Produtos obj = new Produtos();
            Fornecedores f = new Fornecedores();
                    
            if (rs.next()) {
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setCod_barras(rs.getString("p.cod_barras"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedores(f);
                
            }
            return obj;
                
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro as buscar produto." + erro);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Exceção não conhecida.  " +  exception);
        }
    return null;
}
    
     public Produtos BuscarProdutosCodigo(int id){
        try {
            
             String sql = "select p.id, p.descricao, p.cod_barras, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                   + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Produtos obj = new Produtos();
            Fornecedores f = new Fornecedores();
                    
            if (rs.next()) {
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setCod_barras(rs.getString("p.cod_barras"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedores(f);
                
            }
            return obj;
                
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro as buscar produto." + erro);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Exceção não conhecida.  " +  exception);
        }
    return null;
}   
    
    public List<Produtos> listar(){
        List<Produtos> lista = new ArrayList<>();
        try {
            String sql = "select p.id, p.descricao, p.cod_barras, p.preco, p.qtd_estoque, f.nome from tb_produtos as p inner join tb_fornecedores as f on(p.for_id = f.id)";
            PreparedStatement stmt =  conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
               Produtos obj = new Produtos();
               Fornecedores f = new Fornecedores();
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setCod_barras(rs.getString("p.cod_barras"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedores(f);
                lista.add(obj);            
                
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro  ao criar a lista: " + e);
        }
        return null;
    } 
    
    public List<Produtos> Filtrar(String descricao){
        List<Produtos> lista = new ArrayList<>();
        try {
            String sql = "select p.id, p.descricao, p.cod_barras, p.preco,p.qtd_estoque, f.nome from tb_produtos as p inner join"
                    + " tb_fornecedores as f on(p.for_id=f.id) where p.descricao like ?";
            PreparedStatement stmt =  conn.prepareStatement(sql);
            stmt.setString(1, descricao);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
               Produtos obj = new Produtos();
               Fornecedores f = new Fornecedores();
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setCod_barras(rs.getString("p.cod_barras"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedores(f);
                lista.add(obj);               
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro  ao criar a lista: " + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro  ao criar a lista: " + e);
        }
        return null;
    }
    
    public void adicionarEstoque(int id, int qtd_nova) {
        try {
            String sql = "update tb_produtos set qtd_estoque=? where id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao adcionar ao estoque!" + e);
        }
    }
    
 /*   public void adicionarEstoquePDV(int id, int qtdParaAdicionar) {
    try {
        String sql = "UPDATE tb_produtos SET qtd_estoque = qtd_estoque + ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, qtdParaAdicionar);
        stmt.setInt(2, id);
        stmt.execute();
        stmt.close();
        JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao adicionar ao estoque! " + e);
    }
}*/
public void adicionarEstoquePDV(int id, int qtdParaAdicionar) {
    try {
        String sql = "UPDATE tb_produtos SET qtd_estoque = qtd_estoque + ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, qtdParaAdicionar);
        stmt.setInt(2, id);
        int rowsAffected = stmt.executeUpdate(); // Executa a atualização
        stmt.close();

        // Verifica se algum registro foi atualizado
        if (rowsAffected == 0) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado para o ID informado.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao adicionar ao estoque! " + e);
        e.printStackTrace();
    }
}


    
    //método ultilizado na tela de PDV
    public void baixaEstoquePDV(int id, int qtdParaSubtrair) {
    try {
        // Subtrair diretamente no comando SQL
        String sql = "UPDATE tb_produtos SET qtd_estoque = qtd_estoque - ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, qtdParaSubtrair); // O número já será tratado como subtração
        stmt.setInt(2, id);
        int rowsAffected = stmt.executeUpdate(); // Verifica se o update afetou linhas
        stmt.close();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Produto adicionado no carrinho!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado para o ID informado.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar o estoque: " + e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
    }
}
    
    //Método normal para formulário de produto
    public void baixaEstoque(int id, int qtdParaSubtrair) {
    try {
        // Subtrair diretamente no comando SQL
        String sql = "UPDATE tb_produtos SET qtd_estoque = qtd_estoque - ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, qtdParaSubtrair); // O número já será tratado como subtração
        stmt.setInt(2, id);

        int rowsAffected = stmt.executeUpdate(); // Verifica se o update afetou linhas
        stmt.close();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Baixa no estoque efetuada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado para o ID informado.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar o estoque: " + e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
    }
}
    
    public int retornaQtdAtualEstoque (int id) {
        try {
            int qtd_atual_estoque = 0;
            String sql = "select qtd_estoque from tb_produtos where id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                qtd_atual_estoque = (rs.getInt("qtd_estoque"));
            }
            return qtd_atual_estoque;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao retornar a quantidade atual do estooque.  " + e);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao retornar a quantidade atual do estooque.  " + e);
        }
                
}
    
    public Produtos buscar_Produto_Por_Codigo_Barras(String codBarras) {
    try {
        String sql = "select p.id, p.descricao, p.cod_barras, p.preco, p.qtd_estoque, f.nome "
                   + "from tb_produtos as p "
                   + "inner join tb_fornecedores as f on (p.for_id = f.id) "
                   + "where p.cod_barras = ?";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, codBarras);
        
        ResultSet rs = stmt.executeQuery();
        Produtos obj = new Produtos();
        Fornecedores f = new Fornecedores();
        
        if (rs.next()) {
            obj.setId(rs.getInt("p.id"));
            obj.setDescricao(rs.getString("p.descricao"));
            obj.setCod_barras(rs.getString("p.cod_barras"));
            obj.setPreco(rs.getDouble("p.preco"));
            obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
            
            f.setNome(rs.getString("f.nome"));
            obj.setFornecedores(f);
        }
        return obj;
        
    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar produto." + erro);
    } catch (Exception exception) {
        JOptionPane.showMessageDialog(null, "Exceção não conhecida. " + exception);
    }
    return null;
}

    //Buscar produto por código de barras
    public Integer CB_for_ID(String codigoBarras) {
    Integer produtoId = null;
    String sql = "SELECT id FROM tb_produtos WHERE cod_barras = ?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, codigoBarras);  // Define o código de barras na consulta
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            produtoId = rs.getInt("id");  // Captura o id do produto
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar produto pelo código de barras: " + e.getMessage());
    }

    return produtoId;
}

    
//  Buscar ptoduto por código de barras  
    public Produtos BuscarProdutosPorCodigoBarras(String codBarras) {
    try {
        // Define a consulta SQL para buscar pelo código de barras
        String sql = "SELECT p.id, p.descricao, p.cod_barras, p.preco, p.qtd_estoque, f.nome " +
                     "FROM tb_produtos AS p " +
                     "INNER JOIN tb_fornecedores AS f ON (p.for_id = f.id) " +
                     "WHERE p.cod_barras = ?";

        // Prepara a consulta
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, codBarras); // Substitui o código de barras no placeholder da consulta

        // Executa a consulta
        ResultSet rs = stmt.executeQuery();

        // Inicializa os objetos para receber os dados
        Produtos obj = new Produtos();
        Fornecedores f = new Fornecedores();

        // Processa o resultado
        if (rs.next()) {
            obj.setId(rs.getInt("p.id"));
            obj.setDescricao(rs.getString("p.descricao"));
            obj.setCod_barras(rs.getString("p.cod_barras"));
            obj.setPreco(rs.getDouble("p.preco"));
            obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));

            f.setNome(rs.getString("f.nome"));
            obj.setFornecedores(f); // Associa o fornecedor ao produto
        }

        // Retorna o produto encontrado
        return obj;

    } catch (SQLException erro) {
        // Mostra mensagem de erro em caso de falha no SQL
        JOptionPane.showMessageDialog(null, "Erro ao buscar produto pelo código de barras: " + erro);
    } catch (Exception exception) {
        // Trata exceções gerais
        JOptionPane.showMessageDialog(null, "Erro inesperado: " + exception);
    }
    return null; // Retorna nulo se ocorrer erro
}

    
    
    
} 