/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.jdbc;

import br.com.sistema.view.FormularioLogin;
import javax.swing.UIManager;

/**
 *
 * @author dacru
 */
public class TestarConexao {
    public static void main(String[] args) {
      //  try{
            /*
            new ConexaoBancoRelatorios().conecta();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso ao banco de dados!");
        }catch(HeadlessException erro){
            JOptionPane.showMessageDialog(null, "Erro ao se conectar ao banco de dados" + erro);
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Erro:  " + e);
        }*/
        try {
          UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
          FormularioLogin l = new FormularioLogin();
          l.setVisible(true);
            
        } catch (Exception e) {
            FormularioLogin l = new FormularioLogin();
            l.setVisible(true);
        }
        
    //}
    }
}
