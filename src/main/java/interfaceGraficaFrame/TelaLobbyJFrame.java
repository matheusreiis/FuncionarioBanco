package interfaceGraficaFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.TelaLobby;

public class TelaLobbyJFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	TelaLobby telaLobby = new TelaLobby();

	private JPanel contentPane;
	private final JLabel label = new JLabel("New label");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLobbyJFrame frame = new TelaLobbyJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaLobbyJFrame() throws IOException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		tabbedPane.addTab("Lobby", telaLobby);
		label.setBounds(189, 114, 56, 16);
		
		telaLobby.add(label);

		contentPane.add(tabbedPane, BorderLayout.CENTER);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
