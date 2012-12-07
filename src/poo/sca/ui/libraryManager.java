package poo.sca.ui;

import java.util.Iterator;

import javax.swing.JOptionPane;

import poo.sca.Curso;
import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.SCAException;
import poo.sca.SCAFacade;
import poo.sca.SCARuntimeException;
import poo.sca.Turma;

public class libraryManager {
	
	SCAFacade facade =  new SCAFacade();
	
	public static String lerEntradaUsuario(String pergunta){
		String output = JOptionPane.showInputDialog(null, pergunta);
		return output;
	}
	
	public void exibirMensagemUsuario(String texto){
		JOptionPane.showMessageDialog(null, texto);
	}
	
	public static int exibirMenuPrincipal(){
		String choose = JOptionPane.showInputDialog(null, "###### SCA - Sistema de Controle Acadêmico ######\n\n#    1 - TURMAS\n#    2 - DISCIPLINAS\n#    3 - CURSOS\n#    4 - PROFESSORES\n                                                                          0 - sair #\n\n");
		return Integer.parseInt(choose);
	}
		
	public static int exibirMenuTurma(){
		String choose = JOptionPane.showInputDialog(null, "###### SCA - Sistema de Controle Acadêmico ######\n\n#    1 - CRIAR TURMA\n#    2 - PESQUISAR TURMA\n#    3 - REMOVER TURMA\n#    4 - LISTAR TURMAS\n#    5 - ADICIONAR CURSO\n#    6 - ADICIONAR PROFESSOR\n                                                                          0 - voltar #\n\n");
		return Integer.parseInt(choose);
	}
	
	public static int exibirMenuDisciplina(){
		String choose = JOptionPane.showInputDialog(null, "###### SCA - Sistema de Controle Acadêmico ######\n\n#    1 - CADASTRAR DISCIPLINA\n#    2 - PESQUISAR DISCIPLINA\n#    3 - REMOVER DISCIPLINA\n#    4 - LISTAR DISCIPLINAS\n                                                                          0 - voltar #\n\n");
		return Integer.parseInt(choose);
	}
	
	public static int exibirMenuCurso(){
		String choose = JOptionPane.showInputDialog(null, "###### SCA - Sistema de Controle Acadêmico ######\n\n#    1 - CADASTRAR CURSO\n#    2 - PESQUISAR CURSO\n#    3 - REMOVER CURSO\n#    4 - LISTAR CURSOS\n                                                                          0 - voltar #\n\n");
		return Integer.parseInt(choose);
	}
	
	public static int exibirMenuProfessor(){
		String choose = JOptionPane.showInputDialog(null, "###### SCA - Sistema de Controle Acadêmico ######\n\n#    1 - CADASTRAR PROFESSOR\n#    2 - PESQUISAR PROFESSOR\n#    3 - REMOVER PROFESSOR\n#    4 - LISTAR PROFESSORES\n                                                                          0 - voltar #\n\n");
		return Integer.parseInt(choose);
	}
	
	
	public void criarDisciplina(){
		String d1 = lerEntradaUsuario("Digite o nome da disciplina:");
		int d2 = Integer.parseInt(lerEntradaUsuario("Digite o código da disciplina:"));
		try{
			Disciplina disciplina = facade.criarDisciplina(d1, d2);
			exibirMensagemUsuario("Disciplina cadastrada com sucesso.");
		} catch (SCARuntimeException | SCAException e) {
			exibirMensagemUsuario(e.getMessage());
		}
		
	}
	
	public void criarCurso(){
		String d1 = lerEntradaUsuario("Digite o nome do curso:");
		int d2 = Integer.parseInt(lerEntradaUsuario("Digite o código do curso:"));
		try {
			Curso curso = facade.criarCurso(d1, d2);
			exibirMensagemUsuario("Curso cadastrado com sucesso.");
		} catch (SCARuntimeException | SCAException e) {
			exibirMensagemUsuario(e.getMessage());
		}
	}
	
	public void criarProfessor() {
		String d1 = lerEntradaUsuario("Digite o nome do professor:");
		int d2 = Integer.parseInt(lerEntradaUsuario("Digite o número da matricula:"));
		Iterator<Professor> itProfessor = facade.getProfessoresIterator();
		try {
			Professor professor = facade.criarProfessor(d1, d2);
			exibirMensagemUsuario("Professor cadastrado com sucesso.");
		} catch (SCARuntimeException | SCAException e) {
			exibirMensagemUsuario(e.getMessage());
		}
		
	}
	
	public void criarTurma(){
		Iterator<Disciplina> disciplina = facade.getDisciplinaIterator();
		if(disciplina.hasNext() == false){
			exibirMensagemUsuario("ERROR: Não existem disciplinas cadastradas.");
		}
		else{
			int d1 = Integer.parseInt(lerEntradaUsuario("Digite o código da disciplina:"));
			while(disciplina.hasNext()){
				Disciplina d = disciplina.next();
				if(d.getCodigo() == d1){
					int d2 = Integer.parseInt(lerEntradaUsuario("Digite o número da turma:"));
					String d3 = lerEntradaUsuario("Digite o período:");
					String d4 = lerEntradaUsuario("Digite o horário:");
					try {
						Turma turma = facade.criarTurma(d, d2, d3, d4);
						exibirMensagemUsuario("Turma criada com sucesso.");
					} catch (SCARuntimeException | SCAException e) {
						exibirMensagemUsuario(e.getMessage());
	
					}
				}
				else{
					exibirMensagemUsuario("ERROR: Disciplina inexistente.");
				}
			}
			}
		}
		
		
		public void removerTurma(){
			Iterator<Turma> itTurma = facade.getTurmasIterator();
			if(itTurma.hasNext() == false){
				exibirMensagemUsuario("ERROR: Não existem turmas cadastradas.");
			}
			else{
				String d1 = lerEntradaUsuario("Digite o período:");
				int d2 = Integer.parseInt(lerEntradaUsuario("Digite o código da disciplina:"));
				int d3 = Integer.parseInt(lerEntradaUsuario("Digite o número da turma:"));
				try {	
					boolean b = facade.removerTurma(d1, d2, d3);
				} catch (SCARuntimeException | SCAException e) {
					exibirMensagemUsuario(e.getMessage());
				}
			}
		}
		
		public void buscarTurma(){
			Iterator<Turma> itTurma = facade.getTurmasIterator();
			if(itTurma.hasNext() == false){
				exibirMensagemUsuario("ERROR: Não existem turmas cadastradas.");
			}
			else{
				String d1 = lerEntradaUsuario("Digite o período:");
				int d2 = Integer.parseInt(lerEntradaUsuario("Digite o código da disciplina:"));
				int d3   = Integer.parseInt(lerEntradaUsuario("Digite o número da turma:"));
				Turma t = facade.getTurma(d1, d2, d3);
				if(t == null){
					exibirMensagemUsuario("ERROR: Turma inexistente.");
				}
				else{
					StringBuffer str1 = new StringBuffer();
					str1.append(t.toString() + "\n");
					str1.append(t.getDisciplina().toString() + "\n");
					JOptionPane.showMessageDialog(null, str1);
					Iterator<Curso> itCurso = t.getCursosIterator();
					while(itCurso.hasNext()){
						StringBuffer str2 = new StringBuffer();
						str2.append(itCurso.next().toString() + "\n");
						JOptionPane.showMessageDialog(null, str2);
					}
					Iterator<Professor> itProfessor = t.getProfessoresIterator();
					while(itProfessor.hasNext()){
						StringBuffer str3 = new StringBuffer();
						str3.append(itProfessor.next().toString() + "\n");
						JOptionPane.showMessageDialog(null, str3);
					}
				}
			}
		}
		
		public void verTurmas(){
			Iterator<Turma> itTurma = facade.getTurmasIterator();
			if(itTurma.hasNext() == false){
				exibirMensagemUsuario("ERROR: Não existem turmas cadastradas.");
			}
			else{
				StringBuffer str = new StringBuffer();
				while(itTurma.hasNext()){
					str.setLength(0);
					Turma t = itTurma.next();
					str.append(t.toString() + "\n");
					str.append(t.getDisciplina().toString() + "\n");
					JOptionPane.showMessageDialog(null, str);
					Iterator<Curso> curso = t.getCursosIterator();
					StringBuffer str2 = new StringBuffer();
					while(curso.hasNext()){
						str2.setLength(0);
						str2.append(curso.next().toString() + "\n");
						JOptionPane.showMessageDialog(null, str2);
					}		
					Iterator<Professor> professor = t.getProfessoresIterator();
					StringBuffer str3 = new StringBuffer();
					while(professor.hasNext()){
						str3.setLength(0);
						str3.append(professor.next().toString() + "\n");
						JOptionPane.showMessageDialog(null, str3);
					}
				}
			}
		}
		
		public void adicionarCurso(){
			Iterator<Turma> turma = facade.getTurmasIterator();
			Iterator<Curso> curso = facade.getCursosIterator();
			boolean b = false;
			
			if(turma.hasNext() == false){
				exibirMensagemUsuario("ERROR: Não existem turmas cadastradas.");
			}
			else if(curso.hasNext() == false){
				exibirMensagemUsuario("ERROR: Não existem cursos cadastradas.");
			}
			else{
				int d1 = Integer.parseInt(lerEntradaUsuario("Digite o número da turma: "));
				while(turma.hasNext()){
					Turma t = turma.next();
					if(t.getNumero() == d1){
						int d2 = Integer.parseInt(lerEntradaUsuario("Digite o código do curso: "));
						while(curso.hasNext()){
							Curso c = curso.next();
							if(c.getCodigo() == d2){
								Iterator<Curso> curs = t.getCursosIterator();
								while(curs.hasNext()){
									Curso cursoIT = curs.next();
									if(cursoIT.getCodigo() == d2){
										b = true;
									}
								}
							if(b == false){
								t.addCurso(c);
								exibirMensagemUsuario("Curso cadastrado na turma com sucesso.");
							}
							else{
								exibirMensagemUsuario("ERROR: Curso já cadastrado na turma.");
							}
							}
							else{
								exibirMensagemUsuario("ERROR: Curso inexistente, tente novamente.");
							}
						}
						
					}	
					else{
						exibirMensagemUsuario("ERROR: Turma inexistente, tente novamente.");
					}
				}
				
			}
					
		
			
}
			
		public void adicionarProfessor(){
			Iterator<Turma> turma = facade.getTurmasIterator();
			Iterator<Professor> professor = facade.getProfessoresIterator();
			boolean b = false;
			
			if(turma.hasNext() == false){
				exibirMensagemUsuario("ERROR: Não existem turmas cadastradas.");
			}
			else if(professor.hasNext() == false){
				exibirMensagemUsuario("ERROR: Não existem professores cadastradas.");
			}
			else{
				int d1 = Integer.parseInt(lerEntradaUsuario("Digite o número da turma: "));
				while(turma.hasNext()){
					Turma t = turma.next();
					if(t.getNumero() == d1){
						int d2 = Integer.parseInt(lerEntradaUsuario("Digite a matrícula do professor: "));
						while(professor.hasNext()){
							Professor p = professor.next();
							if(p.getMatricula() == d2){
								Iterator<Professor> prof = t.getProfessoresIterator();
								while(prof.hasNext()){
									Professor professorIT = prof.next();
									if(professorIT.getMatricula() == d2){
										b = true;
									}
								}
							if(b == false){
								t.addProfessor(p);
								exibirMensagemUsuario("Professor cadastrado na turma com sucesso.");
							}
							else{
								exibirMensagemUsuario("ERROR: Professor já cadastrado na turma.");
							}
							}
							else{
								exibirMensagemUsuario("ERROR: Professor inexistente, tente novamente.");
							}
						}
					}
					else{
						exibirMensagemUsuario("ERROR: Turma inexistente, tente novamente.");
					}
				}
			}
						
		}
		
		public void buscarDisciplina(){
			Iterator<Disciplina> disciplina = facade.getDisciplinaIterator();
			if(disciplina.hasNext() == false){
				exibirMensagemUsuario("ERROR: Não existem disciplinas cadastradas.");
			}
			else{
				int d1 = Integer.parseInt(lerEntradaUsuario("Digite o código: "));
				boolean b = false;
				while(disciplina.hasNext()){
					Disciplina d = disciplina.next();
					if(d.getCodigo() == d1){
						exibirMensagemUsuario(d.toString());
						b = true;
					}
				}
				if(b == false){
					exibirMensagemUsuario("ERROR: Disciplina inexistente.");
				}
			}
		}
		
		
		public void removerDisciplina(){
			Iterator<Disciplina> disciplina = facade.getDisciplinaIterator();
			if(disciplina.hasNext() == false){
				exibirMensagemUsuario("ERROR: Não existem disciplinas cadastradas.");
			}
			else{
				int d1 = Integer.parseInt(lerEntradaUsuario("Digite o código: "));
				try {	
					boolean b = facade.removerDisciplina(d1);
				} catch (SCARuntimeException | SCAException e) {
					exibirMensagemUsuario(e.getMessage());
				}
			}
		}
		
		public void verDisciplinas(){
			Iterator<Disciplina> disciplina = facade.getDisciplinaIterator();
			if(disciplina.hasNext() == false){
				exibirMensagemUsuario("ERROR: Não existem disciplinas cadastradas.");
			}
			else{
				StringBuffer str = new StringBuffer();
				while(disciplina.hasNext()){
					str.setLength(0);
					str.append(disciplina.next().toString() + "\n");
					JOptionPane.showMessageDialog(null, str);
				}
			}
		}
		
		public void buscarCurso(){
			Iterator<Curso> curso = facade.getCursosIterator();
			if(curso.hasNext() == false){
				exibirMensagemUsuario("ERROR: Não existem cursos cadastradas.");
			}
			else{
				int d1 = Integer.parseInt(lerEntradaUsuario("Digite o código: "));
				boolean b = false;
				while(curso.hasNext()){
					Curso c = curso.next();
					if(c.getCodigo() == d1){
						exibirMensagemUsuario(c.toString());
						b = true;
					}
				}
				if(b == false){
					exibirMensagemUsuario("ERROR: Curso inexistente.");
				}
			}
		}
		
		public void removerCurso(){
			Iterator<Curso> curso = facade.getCursosIterator();
			if(curso.hasNext() == false){
				exibirMensagemUsuario("ERROR: Não existem cursos cadastrados.");
			}
			else{
				int d1 = Integer.parseInt(lerEntradaUsuario("Digite o código: "));
				try {	
					boolean b = facade.removerCurso(d1);
				} catch (SCARuntimeException | SCAException e) {
					exibirMensagemUsuario(e.getMessage());
				}
			}
		}
		
		public void verCursos(){
			Iterator<Curso> curso = facade.getCursosIterator();
			if(curso.hasNext() == false){
				exibirMensagemUsuario("ERROR: Não existem cursos cadastrados.");
			}
			else{
				StringBuffer str = new StringBuffer();
			
				while(curso.hasNext()){
					str.append(curso.next().toString() + "\n");
					JOptionPane.showMessageDialog(null, str);
					str.setLength(0);
				}
			}
		}
		
		public void buscarProfessor(){
			Iterator<Professor> professor = facade.getProfessoresIterator();
			if(professor.hasNext() == false){
				exibirMensagemUsuario("ERROR: Não existem professores cadastrados.");

			}
			else{
				int d1 = Integer.parseInt(lerEntradaUsuario("Digite a matrícula: "));
				boolean b = false;
				while(professor.hasNext()){
					Professor p = professor.next();
					if(p.getMatricula() == d1){
						exibirMensagemUsuario(p.toString());
						b = true;
					}
				}
				if(b == false){
					exibirMensagemUsuario("ERROR: Professor inexistente.");
				}
			}
		}
		
		public void removerProfessor(){
			Iterator<Professor> professor = facade.getProfessoresIterator();
			if(professor.hasNext() == false){
				exibirMensagemUsuario("ERROR: Não existem professores cadastrados.");
			}			
			else{
				int d1 = Integer.parseInt(lerEntradaUsuario("Digite a matrícula: "));
				try {	
					boolean b = facade.removerProfessor(d1);
				} catch (SCARuntimeException | SCAException e) {
					exibirMensagemUsuario(e.getMessage());
				}
			}
		}
		
		public void verProfessores(){
			Iterator<Professor> professor = facade.getProfessoresIterator();
			if(professor.hasNext() == false){
				exibirMensagemUsuario("ERROR: Não existem professores cadastrados.");
			}
			else{
				StringBuffer str = new StringBuffer();
				while(professor.hasNext()){
					str.setLength(0);
					str.append(professor.next().toString() + "\n");
					JOptionPane.showMessageDialog(null, str);
				}
							}
		}
}
