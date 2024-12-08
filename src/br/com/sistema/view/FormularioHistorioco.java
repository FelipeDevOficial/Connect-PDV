/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.view;

import br.com.sistema.dao.vendasDAO;
import br.com.sistema.model.vendas;
import br.com.sistema.dao.ItensVendasDAO;
import br.com.sistema.model.ItensVendas;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dacru
 */
public class FormularioHistorioco extends javax.swing.JFrame {

    /**
     * Creates new form FormularioHistorioco
     */
    public FormularioHistorioco() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtInicio = new javax.swing.JFormattedTextField();
        txtFim = new javax.swing.JFormattedTextField();
        btnPesquisaVenda = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico de vendas");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Histórico de vendas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta por data"));
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Data início:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Data fim:");

        try {
            txtInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/20##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtInicio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        try {
            txtFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/20##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFim.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFimActionPerformed(evt);
            }
        });

        btnPesquisaVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPesquisaVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/imagens/buscar.png"))); // NOI18N
        btnPesquisaVenda.setText("PESQUISAR");
        btnPesquisaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaVendaActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/iconOficial/icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFim, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnPesquisaVenda)
                        .addGap(172, 172, 172)))
                .addComponent(jLabel4)
                .addGap(60, 60, 60))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtFim, txtInicio});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPesquisaVenda)
                        .addGap(26, 26, 26))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtFim, txtInicio});

        tabela.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cliente", "CPF", "Data da venda", "Total da venda", "Observações"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFimActionPerformed

    private void btnPesquisaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaVendaActionPerformed
        NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data_inicio = LocalDate.parse(txtInicio.getText(), formato);
        LocalDate data_fim = LocalDate.parse(txtFim.getText(), formato);
        vendasDAO vd = new vendasDAO();
        List<vendas>lista = vd.HistoricoVendas(data_inicio, data_fim);
        DefaultTableModel historico = (DefaultTableModel) tabela.getModel();
        historico.setNumRows(0);
        for (vendas v : lista){
            historico.addRow(new Object[]{
            v.getId(),
            v.getClientes().getNome(),
            v.getClientes().getCpf(),
            v.getData_venda(),
            formatador.format(v.getTotal_venda()),
            v.getObservacoes()
        });            
        }    
    }//GEN-LAST:event_btnPesquisaVendaActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked

                        
    try {
        // Inicializa o formulário de detalhes da venda
        FormularioDetalheVenda fdv = new FormularioDetalheVenda();        
        ItensVendasDAO dao = new ItensVendasDAO();

        // Obtém a linha selecionada
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow == -1) {
            System.out.println("Nenhuma linha selecionada.");
            return; // Sai se nenhuma linha estiver selecionada
        }
        
        // Criar um formatador para moeda brasileira
        NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        /*String tab = tabela.getValueAt(selectedRow, 4).toString();
        String precoFormatado = formatador.format(Double.parseDouble(tab));

        // Obtém o valor da célula como uma string
         String valorFormatado = tabela.getValueAt(selectedRow, 4).toString();*/

         // Remove o "R$", troca vírgula por ponto e elimina espaços
       /*  String valorSemFormatacao = valorFormatado.replace("R$", "").replace(",", ".").trim();
         double valorNovoFormatado = Double.parseDouble(valorSemFormatacao);
       */
        // Preenche os campos de texto no FormularioDetalheVenda com base nos dados da linha selecionada
        fdv.txtIdVenda.setText(tabela.getValueAt(selectedRow, 0).toString());
        fdv.txtCliente.setText(tabela.getValueAt(selectedRow, 1).toString());
        fdv.txtCpf.setText(tabela.getValueAt(selectedRow, 2).toString());
        fdv.txtDataVenda.setText(tabela.getValueAt(selectedRow, 3).toString());
        fdv.txtTotalVenda.setText(tabela.getValueAt(selectedRow, 4).toString());
        fdv.txtTotalVenda.setText(String.valueOf(tabela.getValueAt(selectedRow, 4).toString()));
        fdv.txtObs.setText(tabela.getValueAt(selectedRow, 5).toString());

        // Obtém o id da venda e imprime para verificação
        int venda_id = Integer.valueOf(fdv.txtIdVenda.getText());
        System.out.println("ID da venda selecionada: " + venda_id);

        // Obtém a lista de itens da venda
        List<ItensVendas> lista = dao.listaIntens(venda_id);
        if (lista == null || lista.isEmpty()) {
            System.out.println("Nenhum item encontrado para essa venda.");
            return;
        }

        // Agora verificamos se o componente JScrollPane car está corretamente associado à tabela carrinho
        if (fdv.carrinho == null) {
            System.out.println("Tabela 'carrinho' não foi inicializada corretamente.");
            return;
        }

        // Obtém o modelo da tabela carrinho e limpa os dados existentes
        DefaultTableModel modeloCarrinho = (DefaultTableModel) fdv.carrinho.getModel();
        if (modeloCarrinho == null) {
            System.out.println("Erro ao obter o modelo da tabela 'carrinho'.");
            return;
        }
        modeloCarrinho.setRowCount(0); // Limpa as linhas existentes

        // Adiciona os itens à tabela carrinho
        for (ItensVendas item : lista) {
            modeloCarrinho.addRow(new Object[]{
                item.getProdutos().getId(),       // Código do produto
                item.getProdutos().getDescricao(), // Descrição do produto
                item.getQtd(),                     // Quantidade
                formatador.format(item.getProdutos().getPreco()),     // Preço unitário
               formatador.format(item.getSubtotal())                 // Subtotal (Quantidade * Preço)
            });
            // Log para depuração
            System.out.println("Produto: " + item.getProdutos().getDescricao() + ", Quantidade: " + item.getQtd());
        }

        // Exibe o formulário de detalhes da venda
        fdv.setVisible(true);
        dispose(); // Fecha o formulário de histórico de vendas
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Erro:  " + e);
        e.printStackTrace();
    }


    }//GEN-LAST:event_tabelaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioHistorioco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioHistorioco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioHistorioco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioHistorioco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioHistorioco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisaVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JFormattedTextField txtFim;
    private javax.swing.JFormattedTextField txtInicio;
    // End of variables declaration//GEN-END:variables
}
