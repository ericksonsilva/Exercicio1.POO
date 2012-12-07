package poo.sca;

import java.util.ArrayList;
import java.util.Iterator;

public class Turma {
	private Disciplina disciplina;
	private ArrayList <Professor> professores = new ArrayList<Professor>();
	private String horario;
	private ArrayList <Curso> cursos = new ArrayList<Curso>();
	private int numero;
	private String periodo;
	
	public Turma(Disciplina disciplina, int numero, String periodo, String horario){
		this.disciplina = disciplina;
		this.numero = numero;
		this.periodo = periodo;
		this.horario = horario;
	}
	public void addProfessor(Professor professor){
		professores.add(professor);
	}
	public void addCurso(Curso curso){
		cursos.add(curso);
	}
	public Iterator<Professor> getProfessoresIterator(){
		return professores.iterator();
	}
	public Iterator<Curso> getCursosIterator(){
		return cursos.iterator();
	}
	public void setHorario(String horario){
		this.horario = horario;
	}
	public String getHorario(){
		return horario;
	}
	public void setPeriodo(String periodo){
		this.periodo = periodo;
	}
	public String getPeriodo(){
		return periodo;
	}
	public void setNumero(int numero){
		this.numero = numero;
	}
	public int getNumero(){
		return numero;
	}
	public void setDisciplina(Disciplina disciplina){
		this.disciplina = disciplina;
	}
	public Disciplina getDisciplina(){
		return disciplina;
	}
	public String toString(){
		StringBuffer str = new StringBuffer();
		str.append(">>> Turma\n");
		str.append("Número: "+this.numero+"\n");
		str.append("Período: "+this.periodo+"\n");
		return str.toString();
	}
}
