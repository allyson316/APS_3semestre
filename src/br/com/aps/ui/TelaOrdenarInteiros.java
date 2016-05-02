package br.com.aps.ui;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import br.com.aps.logica.GeraVetor;
import br.com.aps.logica.QuickSort;
import br.com.aps.logica.Resultado;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class TelaOrdenarInteiros extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textTamanhoVetor;
	Resultado resultadoQuickSort = new Resultado();

//--------------------------------------------------------------Instanciando a Janela-----------------------------------------------------------------	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOrdenarInteiros frame = new TelaOrdenarInteiros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//----------------------------------------------------------------Criando a Frame(Janela)------------------------------------------------------------
	public TelaOrdenarInteiros() throws IOException {
		setTitle("APS 3\u00BA Semestre");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 479, 326);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//------------------------------------------------------------------Titulo da Janela----------------------------------------------------------------		
		JLabel lblTitulo = new JLabel("Ordenando Vetor de Inteiros");
		lblTitulo.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitulo.setBounds(86, 11, 291, 21);
		contentPane.add(lblTitulo);
		
//-------------------------------------------------------------------Escolha do tamanho do vetor-----------------------------------------------------		
		JLabel lblTamanhoDoVetor = new JLabel("Tamanho do Vetor:");
		lblTamanhoDoVetor.setBounds(10, 47, 109, 14);
		contentPane.add(lblTamanhoDoVetor);
				
		textTamanhoVetor = new JTextField();
		//limita a digitação de apenas numeros
		textTamanhoVetor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				//armazena os caracteres que devem ser digitados
				String caracteres = "0987654321";
				//valida os caracteres que foram digitados
				if(!caracteres.contains(ev.getKeyChar()+"")){
					// o caractere é removido através do método consume
					ev.consume();
				}
			}
		});
		//limita a quantidade de cacacteres que podem ser digitados
		LimitarCaracteres limite = new LimitarCaracteres();
		limite.setMaxChars(8);
		textTamanhoVetor.setDocument(limite);
		textTamanhoVetor.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		textTamanhoVetor.setBounds(125, 43, 86, 20);
		contentPane.add(textTamanhoVetor);
		textTamanhoVetor.setColumns(8);
		
//--------------------------------------------------------------------Escolha do vetor---------------------------------------------------------------		
		//Agrupa os Radio Buttons e permite a seleção de Apenas 1
		ButtonGroup bg = new ButtonGroup();
		
		JPanel panelEscolhaVetor = new JPanel();
		panelEscolhaVetor.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ordena\u00E7\u00E3o do Vetor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelEscolhaVetor.setBounds(241, 93, 201, 95);
		contentPane.add(panelEscolhaVetor);
		panelEscolhaVetor.setLayout(null);
		
		JRadioButton rdbtnVetorAleatorio = new JRadioButton("Vetor Aleat\u00F3rio");
		rdbtnVetorAleatorio.setBounds(6, 17, 189, 23);
		panelEscolhaVetor.add(rdbtnVetorAleatorio);
		bg.add(rdbtnVetorAleatorio);
		
		JRadioButton rdbtnVetorCrescente = new JRadioButton("Ordenado Crescente");
		rdbtnVetorCrescente.setBounds(6, 43, 189, 23);
		panelEscolhaVetor.add(rdbtnVetorCrescente);
		bg.add(rdbtnVetorCrescente);
		
		JRadioButton rdbtnVetorDecrescente = new JRadioButton("Ordenado Decrescente");
		rdbtnVetorDecrescente.setBounds(6, 69, 189, 23);
		panelEscolhaVetor.add(rdbtnVetorDecrescente);
		bg.add(rdbtnVetorDecrescente);
		
//-------------------------------------------------------------Escolha Método Ordenação--------------------------------------------------------------		
		//Agrupa os Checksbox e permite a seleção de apenas 1
		ButtonGroup bg1 = new ButtonGroup();
		
		JPanel panelEscolhaOrdenacao = new JPanel();
		panelEscolhaOrdenacao.setLayout(null);
		panelEscolhaOrdenacao.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "M\u00E9todo de Ordena\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelEscolhaOrdenacao.setBounds(20, 93, 201, 95);
		contentPane.add(panelEscolhaOrdenacao);
		
		JCheckBox chckbxSelectionsort = new JCheckBox("SelectionSort");
		chckbxSelectionsort.setBounds(6, 17, 189, 23);
		panelEscolhaOrdenacao.add(chckbxSelectionsort);
		bg1.add(chckbxSelectionsort);
		
		JCheckBox chckbxShellsort = new JCheckBox("ShellSort");
		chckbxShellsort.setBounds(6, 43, 189, 23);
		panelEscolhaOrdenacao.add(chckbxShellsort);
		bg1.add(chckbxShellsort);
		
		JCheckBox chckbxQuicksort = new JCheckBox("QuickSort");
		chckbxQuicksort.setBounds(6, 69, 189, 23);
		panelEscolhaOrdenacao.add(chckbxQuicksort);
		bg1.add(chckbxQuicksort);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//------------------------------------------------------escolhendo o tipo de ordenação----------------------------------------------------------------			
				//converto e passo o tamanho digitado na JtextField para a variavel tamanho 
				int tamanho = Integer.parseInt(textTamanhoVetor.getText());
				int[] vetorInteiros = new int[tamanho];
				GeraVetor vetorGerado = new GeraVetor();
				
				if(rdbtnVetorAleatorio.isSelected()){
					vetorInteiros = vetorGerado.vetorAleatorio(tamanho);
				}else{
					if(rdbtnVetorCrescente.isSelected()){
						vetorInteiros = vetorGerado.vetorCrescente(tamanho);
					}else{
						if(rdbtnVetorDecrescente.isSelected()){
							vetorInteiros = vetorGerado.vetorDecrescente(tamanho);
						}else{
							JOptionPane.showInternalMessageDialog(null, "Escolha um tipo de Ordenação!!!");
						}
					}
				}
//-----------------------------------------------------escolhendo o método de ordenação---------------------------------------------------------------				
				if(chckbxSelectionsort.isSelected()){
					
				}else{
					if(chckbxShellsort.isSelected()){
						
					}else{
						if(chckbxQuicksort.isSelected()){
							
							QuickSort ordenacao = new QuickSort();
							
							resultadoQuickSort = ordenacao.quickSortInteiros(vetorInteiros);
						}else{
							JOptionPane.showInternalMessageDialog(null, "Escolha um método de Ordenação!!!");
						}
					}
				}
				
				
				
			}
		});
		btnIniciar.setBounds(20, 216, 201, 49);
		contentPane.add(btnIniciar);
		
		JButton btnResultado = new JButton("Resultado");
		btnResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					resultadoQuickSort.geraArquivoResultado(resultadoQuickSort.toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnResultado.setBounds(241, 216, 201, 49);
		contentPane.add(btnResultado);
	}
}
