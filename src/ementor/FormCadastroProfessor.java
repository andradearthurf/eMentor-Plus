package ementor;

import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class FormCadastroProfessor extends javax.swing.JFrame {

  /**
   * Creates new form FormCadastroUsuario
   */
  public FormCadastroProfessor() {
    initComponents();
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/graduation-hat.png")));
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
    jLabel4 = new javax.swing.JLabel();
    txtTelefone = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    txtCpf = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    txtNome = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    txtDataNascimento = new javax.swing.JTextField();
    btnCadastrar = new javax.swing.JButton();
    txtSalarioBruto = new javax.swing.JTextField();
    jLabel7 = new javax.swing.JLabel();
    txtDataAdmissao = new javax.swing.JTextField();
    jLabel8 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Cadastrar professor");
    setResizable(false);
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowOpened(java.awt.event.WindowEvent evt) {
        formWindowOpened(evt);
      }
    });

    jLabel4.setText("Telefone");

    jLabel1.setText("Nome");

    jLabel2.setText("CPF");

    jLabel3.setText("Data de nascimento");

    btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sign-in.png"))); // NOI18N
    btnCadastrar.setText("  Cadastrar");
    btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCadastrarActionPerformed(evt);
      }
    });

    jLabel7.setText("Data de admissão");

    jLabel8.setText("Salário bruto");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(26, 26, 26)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jLabel4)
          .addComponent(txtDataNascimento)
          .addComponent(jLabel3)
          .addComponent(txtNome)
          .addComponent(txtCpf)
          .addComponent(jLabel2)
          .addComponent(jLabel1)
          .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel8)
                .addComponent(txtDataAdmissao)
                .addComponent(txtSalarioBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(btnCadastrar, javax.swing.GroupLayout.Alignment.TRAILING)))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(144, 144, 144)
            .addComponent(jLabel7)))
        .addGap(28, 28, 28))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(49, 49, 49)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(12, 12, 12)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel7)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel8)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtSalarioBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(92, 92, 92)
            .addComponent(btnCadastrar)
            .addGap(30, 30, 30))))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
    Conexao conexao = new Conexao();
    //Caso algum dos campos não esteja preenchido
    if (txtNome.getText().isEmpty() || txtDataNascimento.getText().isEmpty() || txtCpf.getText().isEmpty() || txtTelefone.getText().isEmpty() || txtDataAdmissao.getText().isEmpty() || txtSalarioBruto.getText().isEmpty()) {
      JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", ERROR_MESSAGE);
    } else {
      //Caso os campos estejam todos preenchidos
      //Verifica se o CPF ainda não existe
      boolean buscaProfessor = conexao.buscaCPF(Long.parseLong(txtCpf.getText()));
      if (buscaProfessor) {
        //Caso o CPF já esteja cadas
        JOptionPane.showMessageDialog(null, "O CPF já está cadastrado", "Erro!", JOptionPane.ERROR_MESSAGE);
        txtCpf.setText("");
      } else {
        //Caso não exista ninguém com o mesmo CPF, insere e fecha o formulário
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date dataNascimento = null, dataAdmissao = null;
        boolean formatoData = true;

        try {
          dataNascimento = sdf.parse(txtDataNascimento.getText());
        } catch (ParseException ex) {
          JOptionPane.showMessageDialog(null, "Formato de data de nascimento inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
          formatoData = false;
          txtDataNascimento.setText("");
        }

        try {
          dataAdmissao = sdf.parse(txtDataAdmissao.getText());
        } catch (ParseException ex) {
          JOptionPane.showMessageDialog(null, "Formato de data de admissão inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
          formatoData = false;
          txtDataAdmissao.setText("");
        }

        if (formatoData) {
          try {
            conexao.insereProfessor(txtNome.getText(), dataNascimento, Long.parseLong(txtCpf.getText()), txtTelefone.getText(), dataAdmissao, Double.parseDouble(txtSalarioBruto.getText()));
            this.dispose();
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar professor!", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro do carai: " + e.toString());
          }
        }
      }
    }
  }//GEN-LAST:event_btnCadastrarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    getRootPane().setDefaultButton(btnCadastrar);
    }//GEN-LAST:event_formWindowOpened

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
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(FormCadastroProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(FormCadastroProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(FormCadastroProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(FormCadastroProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new FormCadastroProfessor().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnCadastrar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JTextField txtCpf;
  private javax.swing.JTextField txtDataAdmissao;
  private javax.swing.JTextField txtDataNascimento;
  private javax.swing.JTextField txtNome;
  private javax.swing.JTextField txtSalarioBruto;
  private javax.swing.JTextField txtTelefone;
  // End of variables declaration//GEN-END:variables
}
