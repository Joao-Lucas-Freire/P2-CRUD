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

public class TelaCadastro extends JFrame {
    private final JPanel tela;
    private final JTextField txtNome;
    private final JTextField txtUsuario;
    private final JPasswordField passSenha;
    private final JPasswordField passConfSenha;

    public TelaCadastro() {
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Cadastro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 426, 230);

        tela = new JPanel();
        tela.setBackground(SystemColor.gray);
        setContentPane(tela);
        tela.setLayout(null);

        JLabel lblIdentificacao = new JLabel("Informar campos para cadastro");
        lblIdentificacao.setBounds(60, 0, 500, 39);
        lblIdentificacao.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 19));
        tela.add(lblIdentificacao);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(24, 50, 70, 15);
        tela.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(120, 50, 219, 19);
        tela.add(txtNome);

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(24, 75, 70, 15);
        tela.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(120, 75, 219, 19);
        tela.add(txtUsuario);

        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setBounds(24, 100, 70, 15);
        tela.add(lblSenha);

        passSenha = new JPasswordField();
        passSenha.setBounds(120, 100, 219, 19);
        tela.add(passSenha);

        JLabel lblConfSenha = new JLabel("Confirmar Senha");
        lblConfSenha.setBounds(24, 125, 110, 15);
        tela.add(lblConfSenha);

        passConfSenha = new JPasswordField();
        passConfSenha.setBounds(120, 125, 219, 19);
        tela.add(passConfSenha);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(200, 156, 117, 25);
        tela.add(btnCadastrar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(50, 156, 117, 25);
        tela.add(btnCancelar);

        btnCancelar.addActionListener((ActionEvent e) -> {
            TelaLogin tLogin = new TelaLogin();
            tLogin.abreTela();
            dispose();
        });

        btnCadastrar.addActionListener((ActionEvent e) -> {
            Usuario usu = new Usuario();
            usu.setNome(txtNome.getText());
            usu.setUsuario(txtUsuario.getText());
            usu.setSenha(new String(passSenha.getPassword()));

            String senhaStr = new String(passSenha.getPassword());
            String confSenhaStr = new String(passConfSenha.getPassword());

            if ("".equals(usu.getNome())) {
                JOptionPane.showMessageDialog(null, "Campo nome do usuário precisa ser informado", "Atenção", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(usu.getUsuario())) {
                JOptionPane.showMessageDialog(null, "Campo usuário precisa ser informado", "Atenção", JOptionPane.ERROR_MESSAGE);
            } else if (!senhaStr.equals(confSenhaStr)) {
                JOptionPane.showMessageDialog(null, "Campos senha e confirmação de senha não coincidem!", "Atenção", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(senhaStr)) {
                JOptionPane.showMessageDialog(null, "A senha precisa ser informada!", "Atenção", JOptionPane.ERROR_MESSAGE);
            } else {
                if (usu.verificaUsuario(usu.getUsuario())) {
                    JOptionPane.showMessageDialog(null, "Usuário já existente na base de dados.", "Atenção", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (usu.cadastraUsuario(usu.getNome(), usu.getUsuario(), usu.getSenha())) {
                        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                        TelaLogin tLogin = new TelaLogin();
                        tLogin.abreTela();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Problemas ao inserir o usuário.", "Atenção", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    public void abreTela() {
        TelaCadastro panelCadastro = new TelaCadastro();
        panelCadastro.setVisible(true);
    }
}