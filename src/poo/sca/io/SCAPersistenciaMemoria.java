package poo.sca.io;

import java.util.ArrayList;

import poo.sca.Curso;
import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.Turma;

public class SCAPersistenciaMemoria implements SCAPersistencia {
	
	private ArrayList<Turma> turmas;
	private ArrayList<Disciplina> disciplinas;
	private ArrayList<Professor> professores;
	private ArrayList<Curso> cursos;
			
	public SCAPersistenciaMemoria(){
		this.turmas =  new ArrayList<Turma>();
		this.disciplinas = new ArrayList<Disciplina>();
		this.professores = new ArrayList<Professor>();
		this.cursos = new ArrayList<Curso>();
			
	}
	
	public void salvarTurma(Turma turma) {
		turmas.add(turma);
	}
	public ArrayList<Turma> recuperarTurmas() {
		return turmas;
	}
	public void salvarDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}
	public ArrayList<Disciplina> recuperarDisciplinas() {
		return disciplinas;
	}
	public void salvarProfessor(Professor professor) {
		professores.add(professor);
	}
	public ArrayList<Professor> recuperarProfessores() {
		return professores;
	}
	public void salvarCurso(Curso curso) {
		cursos.add(curso);
	}
	public ArrayList<Curso> recuperarCursos() {
		return cursos;
	}
	
}
