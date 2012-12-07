package poo.sca.io;

import java.util.ArrayList;

import poo.sca.Curso;
import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.Turma;

public interface SCAPersistencia {
	
	public void salvarTurma(Turma turma)throws SCAPersistenciaException;;
	public ArrayList<Turma> recuperarTurmas()throws SCAPersistenciaException;;
	public void salvarDisciplina(Disciplina disciplina)throws SCAPersistenciaException;;
	public ArrayList<Disciplina> recuperarDisciplinas()throws SCAPersistenciaException;;
	public void salvarProfessor(Professor professor)throws SCAPersistenciaException;;
	public ArrayList<Professor> recuperarProfessores()throws SCAPersistenciaException;;
	public void salvarCurso(Curso curso)throws SCAPersistenciaException;;
	public ArrayList<Curso> recuperarCursos()throws SCAPersistenciaException;;
}
