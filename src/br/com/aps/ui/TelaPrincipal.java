package br.com.aps.ui;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

//--------------------------------------------------------------Instanciando a Janela----------------------------------------------------------------	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//----------------------------------------------------------------Criando a Frame(Janela)------------------------------------------------------------	
	public TelaPrincipal() {
		setTitle("APS 3\u00BA Semestre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 255);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

//------------------------------------------------------------------Titulo da Janela------------------------------------------------------------------
		JLabel lblAnaliseDeAlgoritmos = new JLabel("Analise de Desempenho");
		lblAnaliseDeAlgoritmos.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblAnaliseDeAlgoritmos.setBounds(99, 11, 243, 26);
		contentPane.add(lblAnaliseDeAlgoritmos);
		
//----------------------------------------------------------Botão "Ordenar Inteiros"------------------------------------------------------------------		
		JButton btnOrdenarInteiros = new JButton("Ordenar Inteiros");
		btnOrdenarInteiros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaOrdenarInteiros ordenarInteiros = null;
				try {
					ordenarInteiros = new TelaOrdenarInteiros();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				ordenarInteiros.setVisible(true);
				ordenarInteiros.setLocationRelativeTo(null);
			}
		});
		btnOrdenarInteiros.setBounds(48, 83, 150, 50);
		contentPane.add(btnOrdenarInteiros);
		
//----------------------------------------------------------Botão "Ordenar Arquivos"------------------------------------------------------------------
		JButton btnOrdenarArquivos = new JButton("Ordenar Arquivos");
		btnOrdenarArquivos.setBounds(246, 83, 150, 50);
		contentPane.add(btnOrdenarArquivos);
	}
}
