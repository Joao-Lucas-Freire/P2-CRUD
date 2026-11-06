package login;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelaInicio extends JFrame {
    private final JPanel tela;

    public TelaInicio() {
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 426, 212);

        tela = new JPanel();
        tela.setBackground(SystemColor.gray);
        setContentPane(tela);
        tela.setLayout(null);

        JLabel lblUsuario = new JLabel("Bem-vindo " + Usuario.nomeUsuario);
        lblUsuario.setBounds(24, 65, 300, 15);
        tela.add(lblUsuario);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(20, 130, 117, 25);
        tela.add(btnExcluir);

        JButton btnAlterar = new JButton("Alterar Dados");
        btnAlterar.setBounds(150, 130, 125, 25);
        tela.add(btnAlterar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(290, 130, 100, 25);
        tela.add(btnVoltar);

        btnVoltar.addActionListener((ActionEvent e) -> {
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.abreTela();
            dispose();
        });

        btnAlterar.addActionListener((ActionEvent e) -> {
            TelaAlteracao telaAlterar = new TelaAlteracao();
            telaAlterar.abreTela();
            dispose();
        });

        btnExcluir.addActionListener((ActionEvent e) -> {
            Object[] options = {"Sim", "Não"};
            int opcao = JOptionPane.showOptionDialog(
                null,
                Usuario.nomeUsuario + ", deseja excluir a sua conta?",
                "Atenção",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
            );

            if (opcao == 0) {
                Usuario usu = new Usuario();
                if (usu.excluiUsuario(Usuario.usuarioSistema)) {
                    JOptionPane.showMessageDialog(null, "Usuário deletado corretamente, voltaremos à tela de login.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    TelaLogin tLogin = new TelaLogin();
                    tLogin.abreTela();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Problemas ao excluir o usuário", "Atenção", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void abreTela() {
        TelaInicio telaInicio = new TelaInicio();
        telaInicio.setVisible(true);
    }
}