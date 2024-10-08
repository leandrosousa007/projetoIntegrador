// 
package Teste;

import controle.TurmaControle;
import java.time.LocalDate;
import modelo.Turma;
import java.util.ArrayList;


public class TurmaTeste {
    
    public static void main(String[] args) {
        
       TurmaControle teste = new TurmaControle();
     
      //Inserir Turma
      /*
        Turma turma = new Turma();
        
        turma.setNome_turma("cu 2B");
        turma.setAno(2024);
        turma.setPeriodo("Integral");
        turma.setCod_curso(2);
      
       
        String resultado = teste.inserirTurma(turma);
        System.out.println("Inserido \n" + resultado);
      */
   
      
      //Alterar Turma
      /*
        Turma turma = new Turma();
        
        turma.setCod_turma(1);
        turma.setNome_turma("sww");
        turma.setAno(2024);
        turma.setPeriodo("noturno");          
        turma.setCod_curso(1);
        
        String resultado = teste.alterarTurma(turma);
        System.out.println(resultado);
      */
        
     
     
      //Remover Turma
      /*
        System.out.println("Removido");
        teste.imprimirTurma(teste.consultarTurmaPorCodigo(1));
        String resultado = teste.removerTurma(1); 
      */
        
      //Consultar Turma por Código
      /*
        Turma Consulta = teste.consultarTurmaPorCodigo(7);
        System.out.println("Informações do Turma consultado: ");
        teste.imprimirTurma(Consulta);
      */
      
      
      //Consultar Turmas
      /*
        ArrayList<Turma> turmas = teste.consultarTurmas();
        System.out.println("Turmas cadastrados:");
        teste.imprimirTurmas(turmas);
      */
        
        
    }
    
}


