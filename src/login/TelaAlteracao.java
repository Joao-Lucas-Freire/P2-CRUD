package login;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaAlteracao extends JFrame {
    private final JPanel tela;
    private final JTextField txtNome;
    private final JPasswordField passAtual;
    private final JPasswordField passSenha;
    private final JPasswordField confPassSenha;

    public TelaAlteracao() {
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Alteração");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 426, 212);

        tela = new JPanel();
        tela.setBackground(SystemColor.gray);
        setContentPane(tela);
        tela.setLayout(null);

        JLabel lblIdentificacao = new JLabel("Informar campos para alteração");
        lblIdentificacao.setBounds(60, 0, 500, 39);
        lblIdentificacao.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 19));
        tela.add(lblIdentificacao);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(24, 35, 100, 15);
        tela.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(120, 35, 218, 20);
        txtNome.setText(Usuario.nomeUsuario);
        tela.add(txtNome);

        JLabel lblSenhaAtual = new JLabel("Senha Atual");
        lblSenhaAtual.setBounds(24, 60, 100, 15);
        tela.add(lblSenhaAtual);

        passAtual = new JPasswordField();
        passAtual.setBounds(120, 60, 219, 19);
        tela.add(passAtual);

        JLabel lblNovaSenha = new JLabel("Nova Senha");
        lblNovaSenha.setBounds(24, 85, 100, 15);
        tela.add(lblNovaSenha);

        passSenha = new JPasswordField();
        passSenha.setBounds(120, 85, 219, 19);
        tela.add(passSenha);

        JLabel lblConfSenha = new JLabel("Confirmar Senha");
        lblConfSenha.setBounds(24, 110, 110, 15);
        tela.add(lblConfSenha);

        confPassSenha = new JPasswordField();
        confPassSenha.setBounds(120, 110, 219, 19);
        tela.add(confPassSenha);

        JButton btnAlterar = new JButton("Alterar");
        btnAlterar.setBounds(200, 136, 117, 25);
        tela.add(btnAlterar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(50, 136, 117, 25);
        tela.add(btnCancelar);

        btnCancelar.addActionListener((ActionEvent e) -> {
            TelaInicio telaIni = new TelaInicio();
            telaIni.setVisible(true);
            dispose();
        });

        btnAlterar.addActionListener((ActionEvent e) -> {
            Usuario usu = new Usuario();
            usu.setSenha(new String(confPassSenha.getPassword()));
            usu.setUsuario(Usuario.usuarioSistema);

            String senhaAtualStr = new String(passAtual.getPassword());
            String novaSenhaStr = new String(passSenha.getPassword());
            String confSenhaStr = new String(confPassSenha.getPassword());

            if ("".equals(txtNome.getText())) {
                JOptionPane.showMessageDialog(null, "Campo nome do usuário precisa ser informado!", "Atenção", JOptionPane.ERROR_MESSAGE);
                txtNome.grabFocus();
            } else if ("".equals(novaSenhaStr)) {
                JOptionPane.showMessageDialog(null, "Campo senha precisa ser informado!", "Atenção", JOptionPane.ERROR_MESSAGE);
                passSenha.grabFocus();
            } else if (!usu.verificaUsuario(usu.getUsuario(), senhaAtualStr)) {
                JOptionPane.showMessageDialog(null, "Senha atual inválida, verifique!", "Atenção", JOptionPane.ERROR_MESSAGE);
                passAtual.grabFocus();
            } else if (!novaSenhaStr.equals(confSenhaStr)) {
                JOptionPane.showMessageDialog(null, "Campos de Senha e Confirmação não são iguais!", "Atenção", JOptionPane.ERROR_MESSAGE);
                passSenha.grabFocus();
            } else {
                if (usu.alteraUsuario(txtNome.getText(), usu.getUsuario(), usu.getSenha())) {
                    JOptionPane.showMessageDialog(null, "Dados alterados com sucesso! Retornando à tela de login.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    TelaLogin tLogin = new TelaLogin();
                    tLogin.abreTela();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Problemas ao atualizar o usuário", "Atenção", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void abreTela() {
        TelaAlteracao telaAlteracao = new TelaAlteracao();
        telaAlteracao.setVisible(true);
    }
}