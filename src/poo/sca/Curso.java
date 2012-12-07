package poo.sca;

public class Curso {	
	private int codigo;
	private String nome;
	
	public Curso(String nome, int codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}
	public void setCodigo(int codigo){
		this.codigo = codigo;
	}
	public int getCodigo(){
		return codigo;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return nome;
	}
	public String toString(){
		StringBuffer str = new StringBuffer();
		str.append(">>> Curso\n");
		str.append("Nome: "+this.nome+"\n");
		str.append("Código: "+this.codigo+"\n");
		return str.toString();
	}

}
