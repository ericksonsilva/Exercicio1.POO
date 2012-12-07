package poo.sca.ui;

import java.util.Scanner;
import java.util.Iterator;

import javax.swing.JOptionPane;
import poo.sca.Curso;
import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.SCAException;
import poo.sca.SCAFacade;
import poo.sca.Turma;

public class SCA {
		
	public static void main(String[] args){
		libraryManager lib = new libraryManager();
		int entry;
		
		do{
			entry = lib.exibirMenuPrincipal();
			switch (entry){
				case 0:
					JOptionPane.showMessageDialog(null, "### Obrigado pela preferência! :p ###");
				break;
				
				case 1:
					int i;
					do{
						i = lib.exibirMenuTurma();
						switch(i){
							case 0:
								continue;
							case 1:
								lib.criarTurma();
								break;
							case 2:
								lib.buscarTurma();
								break;
							case 3:
								lib.removerTurma();
								break;
							case 4:
								lib.verTurmas();
								break;
							case 5:
								lib.adicionarCurso();
								break;
							case 6:
								lib.adicionarProfessor();
								break;
							default:
								JOptionPane.showMessageDialog(null, "ERROR: Opção inválida, tente novamente.");
						}	
															
					}while ( i!=0 );
					break;
					
				case 2:
					int ii;
					do{
						ii = lib.exibirMenuDisciplina();
						switch(ii){
							case 0:
								continue;
							case 1:
								lib.criarDisciplina();
								break;
							case 2:
								lib.buscarDisciplina();
								break;
							case 3:
								lib.removerDisciplina();
								break;
							case 4:
								lib.verDisciplinas();
								break;
							default:
								JOptionPane.showMessageDialog(null, "ERROR: Opção inválida, tente novamente.");
					
						}
					
					}while ( ii!=0 );
					break;
					
				case 3:	
					int iii;
					do{
						iii = lib.exibirMenuCurso();
						switch(iii){
							case 0:
								continue;
							case 1:
								lib.criarCurso();
								break;
							case 2:
								lib.buscarCurso();
								break;
							case 3:
								lib.removerCurso();
								break;
							case 4:
								lib.verCursos();
								break;
							default:
								JOptionPane.showMessageDialog(null, "ERROR: Opção inválida, tente novamente.");
						}
					}while ( iii!=0 );
					break;
					
					
				case 4:
					int iv;
					do{
						iv = lib.exibirMenuProfessor();
						switch(iv){
							case 0:
								continue;
							case 1:
								lib.criarProfessor();
								break;
							case 2:
								lib.buscarProfessor();
								break;
							case 3:
								lib.removerProfessor();
								break;
							case 4:
								lib.verProfessores();
								break;
							default:
								JOptionPane.showMessageDialog(null, "ERROR: Opção inválida, tente novamente.");
						}
					}while ( iv!=0 );
					break;
									
				default:
					JOptionPane.showMessageDialog(null, "ERROR: Opção inválida, tente novamente.");
				}	
			
		}while (entry != 0);
		
	}

}
