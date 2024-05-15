
package br.com.armazem.telas;

/**
 *
 * @author Ítalo Nunes
 */
import java.sql.*;
import br.com.armazem.dal.ModuloConexao;
import javax.swing.JOptionPane;

public class TelaUsuario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    //Essa linha vai exitir o resultados das intruções SQL
    ResultSet rs = null;

    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    // metódo para consultar usuário
    private void consultar() {
        String sql = "select * from tb_usuarios where idUser=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                //a lista abaixo é de acordo com o cadastro na tabela
                //os números são referentes ao nome do campo na tabela
                //exemplo: Login é o campo 2 na table, Id é o campo 1 na tabela e assim
                //por diante
                txtUsuLogin.setText(rs.getString(2));
                txtUsuFone.setText(rs.getString(3));
                txtUsuNome.setText(rs.getString(4));
                txtUsuPerfil.setText(rs.getString(6));
                txtUsuSenha.setText(rs.getString(5));
                //código do combobox 
                //cboUsuPerf.setSelectedItem(rs.getString(5));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário Não cadastrado");
                // as linhas abaixo "limpam os campos"
                txtUsuNome.setText(null);
                txtUsuLogin.setText(null);
                txtUsuFone.setText(null);
                txtUsuPerfil.setText(null);
                txtUsuSenha.setText(null);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // metódo para adicionar usuário
    private void adicionar() {
        String sql = "insert into tb_usuarios (iduser, usuario, fone, login, senha, perfil) values(?, ?, ?, ?, ?, ?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuId.getText());
            pst.setString(2, txtUsuLogin.getText());
            pst.setString(3, txtUsuFone.getText());
            pst.setString(5, txtUsuSenha.getText());
            pst.setString(6, txtUsuPerfil.getText());
            pst.setString(4, txtUsuNome.getText());
            
            //Validação dos Campos Obrigatórios
            
            if ((((((txtUsuId.getText().isEmpty()) ||(txtUsuLogin.getText().isEmpty())) || (txtUsuFone.getText().isEmpty())) || (txtUsuNome.getText().isEmpty())) || txtUsuSenha.getText().isEmpty()) || (txtUsuPerfil.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os Campos Obrigatórios");
                        
            } else {
        
            //a linha abaixo atualiza a tabela usuário com os dados do formulário
            //a estrutura abaixo confirma o cadastro na tabela
            int adicionado = pst.executeUpdate();
            //A linha abaixo serve de entendimento para a lógica usada
            // System.out.println("adicionado");
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso");
                txtUsuId.setText(null);
                txtUsuNome.setText(null);
                txtUsuLogin.setText(null);
                txtUsuFone.setText(null);
                txtUsuPerfil.setText(null);
                txtUsuSenha.setText(null);
                }
            } 
            pst.executeUpdate();
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(null, e);
        }

    }
    //Criando o método para alterar dados do usuário
    
    private void alterar(){
        String sql= "update tb_usuarios set usuario=?, fone=?, login=?, senha=?, perfil=? WHERE iduser=?";
        try {
            
            pst=conexao.prepareStatement(sql);
            pst.setString(1,txtUsuNome.getText());
            pst.setString(3, txtUsuLogin.getText());
            pst.setString(2, txtUsuFone.getText());
            pst.setString(4, txtUsuSenha.getText());
            pst.setString(5, txtUsuPerfil.getText());
            pst.setString(6,txtUsuId.getText());
                    if ((((((txtUsuId.getText().isEmpty()) ||(txtUsuLogin.getText().isEmpty())) || (txtUsuFone.getText().isEmpty())) || (txtUsuNome.getText().isEmpty())) || txtUsuSenha.getText().isEmpty()) || (txtUsuPerfil.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os Campos Obrigatórios");
                        
            } else {
        
            //a linha abaixo atualiza a tabela usuário com os dados do formulário
            //a estrutura abaixo confirma a alteração no cadastro na tabela
            int adicionado = pst.executeUpdate();
            //A linha abaixo serve de entendimento para a lógica usada
            // System.out.println("adicionado");
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso");
                txtUsuId.setText(null);
                txtUsuNome.setText(null);
                txtUsuLogin.setText(null);
                txtUsuFone.setText(null);
                txtUsuPerfil.setText(null);
                txtUsuSenha.setText(null);
                }
            } 
        } catch (Exception e) {
       // JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //método remover usuários
    private void remover(){
        //a estrutura abaixo confirma a remoção do usuário
    int confirma=JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar o usuário?","ATENÇÃO", JOptionPane.YES_NO_OPTION);
    if(confirma==JOptionPane.YES_OPTION){
         String sql="delete from tb_usuarios WHERE iduser=?";
         try {
            pst=conexao.prepareStatement(sql);
             pst.setString(1, txtUsuId.getText());
            int apagado= pst.executeUpdate();
            if(apagado > 0){
                JOptionPane.showMessageDialog(null, "Usuário Removido com Sucesso");
                txtUsuId.setText(null);
                txtUsuNome.setText(null);
                txtUsuLogin.setText(null);
                txtUsuFone.setText(null);
                txtUsuPerfil.setText(null);
                txtUsuSenha.setText(null);
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }
   
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuId = new javax.swing.JTextField();
        txtUsuLogin = new javax.swing.JTextField();
        txtUsuFone = new javax.swing.JTextField();
        txtUsuPerfil = new javax.swing.JTextField();
        txtUsuSenha = new javax.swing.JTextField();
        btnUsoCreate = new javax.swing.JButton();
        btnUsoRead = new javax.swing.JButton();
        btnUsoUpdate = new javax.swing.JButton();
        btnUsoDelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtUsuNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        setPreferredSize(new java.awt.Dimension(600, 500));

        jLabel1.setText("*ID");

        jLabel2.setText("*Login");

        jLabel3.setText("*Fone");

        jLabel4.setText("*Senha");

        jLabel5.setText("*Perfil");

        btnUsoCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/armazem/icones/create.png"))); // NOI18N
        btnUsoCreate.setToolTipText("Adicionar ");
        btnUsoCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsoCreate.setPreferredSize(new java.awt.Dimension(48, 48));
        btnUsoCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsoCreateActionPerformed(evt);
            }
        });

        btnUsoRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/armazem/icones/read.png"))); // NOI18N
        btnUsoRead.setToolTipText("Pesquisar");
        btnUsoRead.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsoRead.setPreferredSize(new java.awt.Dimension(48, 48));
        btnUsoRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsoReadActionPerformed(evt);
            }
        });

        btnUsoUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/armazem/icones/update.png"))); // NOI18N
        btnUsoUpdate.setToolTipText("Editar");
        btnUsoUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsoUpdate.setPreferredSize(new java.awt.Dimension(48, 48));
        btnUsoUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsoUpdateActionPerformed(evt);
            }
        });

        btnUsoDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/armazem/icones/delete.png"))); // NOI18N
        btnUsoDelete.setToolTipText("Apagar");
        btnUsoDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsoDelete.setPreferredSize(new java.awt.Dimension(48, 48));
        btnUsoDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsoDeleteActionPerformed(evt);
            }
        });

        jLabel7.setText("*Nome");

        jLabel6.setText("* Campos Obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnUsoCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(btnUsoRead, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUsuNome, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUsuPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUsoUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnUsoDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtUsuFone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUsuLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsuSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtUsuSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsuFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtUsuPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUsoCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUsoUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUsoRead, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUsoDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(81, 81, 81))
        );

        setBounds(0, 0, 628, 496);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsoCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsoCreateActionPerformed
        // chamando o metódo adicionar
        adicionar();
    }//GEN-LAST:event_btnUsoCreateActionPerformed

    private void btnUsoUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsoUpdateActionPerformed
        // chamando o método alterar
        alterar();
    }//GEN-LAST:event_btnUsoUpdateActionPerformed

    private void btnUsoReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsoReadActionPerformed
        // Chamando o metódo Consultar
        consultar();
    }//GEN-LAST:event_btnUsoReadActionPerformed

    private void btnUsoDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsoDeleteActionPerformed
        // método remover
        remover();
    }//GEN-LAST:event_btnUsoDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUsoCreate;
    private javax.swing.JButton btnUsoDelete;
    private javax.swing.JButton btnUsoRead;
    private javax.swing.JButton btnUsoUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtUsuFone;
    private javax.swing.JTextField txtUsuId;
    private javax.swing.JTextField txtUsuLogin;
    private javax.swing.JTextField txtUsuNome;
    private javax.swing.JTextField txtUsuPerfil;
    private javax.swing.JTextField txtUsuSenha;
    // End of variables declaration//GEN-END:variables
}
