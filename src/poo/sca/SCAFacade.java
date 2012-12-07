package poo.sca;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import poo.sca.io.SCAPersistencia;
import poo.sca.io.SCAPersistenciaException;
import poo.sca.io.SCAPersistenciaMemoria;

public class SCAFacade {
	private SCAPersistencia persistencia;
	
	public SCAFacade(){
		this.persistencia = new SCAPersistenciaMemoria();
	}
		
	public Turma criarTurma(Disciplina disciplina, int numero, String periodo, String horario)throws SCAException,SCARuntimeException{
		Turma t = new Turma(disciplina, numero, periodo, horario);
		try {
			for(Turma turm : persistencia.recuperarTurmas()){
				if ((turm.getNumero() == numero) || (turm.getPeriodo() == periodo) && (turm.getDisciplina().getCodigo() == disciplina.getCodigo())) {
					throw new SCAException("ERROR: Turma já existente.");
				}
			}
		} catch (SCAPersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			persistencia.salvarTurma(t);
		} catch (SCAPersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	
	public Turma getTurma(String periodo, int codDisciplina, int numero)throws SCARuntimeException{
		ArrayList<Turma> turma;
		try {
			turma = persistencia.recuperarTurmas();
			for(Turma t : turma){
				if((periodo.equalsIgnoreCase(t.getPeriodo()))  && (codDisciplina == t.getDisciplina().getCodigo()) && (numero == t.getNumero())){
					return t;
				}
			}
		} catch (SCAPersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;	
	}
	
	
	public boolean removerTurma(String periodo, int codDisciplina, int numero)throws SCARuntimeException, SCAException{
		boolean st = false;
		Turma tRemove = null;
		try{
			ArrayList<Turma> turma = persistencia.recuperarTurmas();
			for(Turma t : turma){
				if((periodo.equalsIgnoreCase(t.getPeriodo()))  && (codDisciplina == t.getDisciplina().getCodigo()) && (numero == t.getNumero())){
					tRemove = t;
					JOptionPane.showMessageDialog(null, "Turma excluída com sucesso.");
				}
			}
			st = persistencia.recuperarTurmas().remove(tRemove);
			if(st == false){
				throw new SCAException("ERROR: Turma inexistente.");
					
				}
		}catch(SCAPersistenciaException e){
			e.printStackTrace();
		}
		return st;
					
	}
	
	public Iterator<Turma> getTurmasIterator()throws SCARuntimeException{
		try{
			return persistencia.recuperarTurmas().iterator();
		} catch (SCAPersistenciaException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Curso criarCurso(String nome, int codigo)throws SCARuntimeException, SCAException{
		Curso c = new Curso(nome, codigo);
		try {
			for(Curso curs : persistencia.recuperarCursos()){
				if (curs.getCodigo() == codigo) {
					throw new SCAException("ERROR: Curso já existente.");
				}
			}
		} catch (SCAPersistenciaException e) {
			e.printStackTrace();
		}
		try {
			persistencia.salvarCurso(c);
		} catch (SCAPersistenciaException e) {
			e.printStackTrace();
		}
		return c;
	}
	public Iterator<Curso> getCursosIterator() throws SCARuntimeException{
			try{
				return persistencia.recuperarCursos().iterator();
			} catch (SCAPersistenciaException e) {
				e.printStackTrace();
			}
			return null;
	}
	
	public Disciplina criarDisciplina(String nome, int codigo)throws SCARuntimeException, SCAException{
		Disciplina d = new Disciplina(nome, codigo);
		try {
			for(Disciplina disc : persistencia.recuperarDisciplinas()){
				if (disc.getCodigo() == codigo) {
					throw new SCAException("ERROR: Disciplina já existente.");
				}

			}
		} catch (SCAPersistenciaException e1) {
			e1.printStackTrace();
		}
		try{
			persistencia.salvarDisciplina(d);
		} catch (SCAPersistenciaException e) {
			e.printStackTrace();
		}
		return d;
	}
	public Iterator<Disciplina> getDisciplinaIterator()throws SCARuntimeException{
			try{
				return persistencia.recuperarDisciplinas().iterator();
			} catch (SCAPersistenciaException e) {
				e.printStackTrace();
			}
			return null;
		
	}
	public Professor criarProfessor(String nome, int matricula)throws SCARuntimeException, SCAException{
		Professor p = new Professor(nome, matricula);
		try {
			for(Professor prof : persistencia.recuperarProfessores()){
				if (prof.getMatricula() == matricula) {
					throw new SCAException("ERROR: Professor já existente.");
				}
			}
		} catch (SCAPersistenciaException e) {
			e.printStackTrace();
		}
		try {
			persistencia.salvarProfessor(p);
		} catch (SCAPersistenciaException e) {
			e.printStackTrace();
		}
		return p;
	}
	public Iterator<Professor> getProfessoresIterator()throws SCARuntimeException{
			try{
				return persistencia.recuperarProfessores().iterator();
			} catch (SCAPersistenciaException e) {
				e.printStackTrace();
			}
			return null;
	}
	
	public boolean removerDisciplina(int cod)throws SCARuntimeException, SCAException{
		boolean st = false;
		Disciplina dRemove = null;
		try{
			ArrayList<Disciplina> disciplina = persistencia.recuperarDisciplinas();
			for(Disciplina d : disciplina){
				if(cod == d.getCodigo()){
					dRemove = d;
					JOptionPane.showMessageDialog(null, "Disciplina excluída com sucesso.");
				}
			}
			st = persistencia.recuperarDisciplinas().remove(dRemove);
			if(st == false){
				throw new SCAException("ERROR: Disciplina inexistente.");
					
				}
		}catch(SCAPersistenciaException e){
			e.printStackTrace();
		}
		return st;
					
	}
	
	public boolean removerCurso(int cod)throws SCARuntimeException, SCAException{
		boolean st = false;
		Curso cRemove = null;
		try{
			ArrayList<Curso> curso = persistencia.recuperarCursos();
			for(Curso c : curso){
				if(cod == c.getCodigo()){
					cRemove = c;
					JOptionPane.showMessageDialog(null, "Curso excluído com sucesso.");
				}
			}
			st = persistencia.recuperarCursos().remove(cRemove);
			if(st == false){
				throw new SCAException("ERROR: Curso inexistente.");
					
				}
		}catch(SCAPersistenciaException e){
			e.printStackTrace();
		}
		return st;
					
	}
	
	public boolean removerProfessor(int mat)throws SCARuntimeException, SCAException{
		boolean st = false;
		Professor pRemove = null;
		try{
			ArrayList<Professor> professor = persistencia.recuperarProfessores();
			for(Professor p : professor){
				if(mat == p.getMatricula()){
					pRemove = p;
					JOptionPane.showMessageDialog(null, "Professor excluído com sucesso.");
				}
			}
			st = persistencia.recuperarProfessores().remove(pRemove);
			if(st == false){
				throw new SCAException("ERROR: Professor inexistente.");
					
				}
		}catch(SCAPersistenciaException e){
			e.printStackTrace();
		}
		return st;
					
	}
	
	
	

}
