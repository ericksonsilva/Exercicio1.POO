package poo.sca;

public class Professor {
	private int matricula;
	private String nome;
	
	public Professor(String nome, int matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public void setMatricula(int matricula){
		this.matricula = matricula;
	}
	public int getMatricula(){
		return matricula;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return nome;
	}
	public String toString(){
		StringBuffer str = new StringBuffer();
		str.append(">>> Professor\n");
		str.append("Nome: "+this.nome+"\n");
		str.append("Matrícula: "+this.matricula+"\n");
		return str.toString();
	}
}
