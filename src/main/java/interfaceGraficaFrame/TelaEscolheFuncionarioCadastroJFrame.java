package interfaceGraficaFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.TelaEscolheFuncionarioCadastro;

public class TelaEscolheFuncionarioCadastroJFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	TelaEscolheFuncionarioCadastro escolheFuncionarioCadastro = new TelaEscolheFuncionarioCadastro();

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEscolheFuncionarioCadastroJFrame frame = new TelaEscolheFuncionarioCadastroJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaEscolheFuncionarioCadastroJFrame() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("Cadastro Funcionario", escolheFuncionarioCadastro);
	}

}
