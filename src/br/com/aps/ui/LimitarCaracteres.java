package br.com.aps.ui;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitarCaracteres extends PlainDocument{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Armazena o número máximo de caracteres para o texto.
	private int maxChars;
	
	public LimitarCaracteres() {
	}
	
	//sobreescreve o método insertString da classe PlainDocument limitando a quantidade
	//de caracteres que podem ser digitados
	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException{
		if(str != null && (getLength() + str.length() < maxChars)){
			super.insertString(offs, str, a);
		}
	}

	public int getMaxChars() {
		return maxChars;
	}

	public void setMaxChars(int maxChars) {
		this.maxChars = maxChars;
	}
	
}
