//AlunoTurmaTeste
package Teste;

import controle.AlunoTurmaControle;
import java.time.LocalDate;
import modelo.AlunoTurma;
import java.util.ArrayList;


public class AlunoTurmaTeste {
    
    public static void main(String[] args) {
        
       AlunoTurmaControle teste = new AlunoTurmaControle();
     
      //Inserir AlunoTurma
      
        AlunoTurma alunoTurma = new AlunoTurma();
                
        LocalDate dataMatricula = LocalDate.parse("2028-12-21");
        alunoTurma.setData_matricula(dataMatricula);
        
        alunoTurma.setCod_aluno(1);
        alunoTurma.setCod_turma(2);
       
        String resultado = teste.inserirAlunoTurma(alunoTurma);
        System.out.println("Inserido \n" + resultado);
      
   
      
      //Alterar AlunoTurma
      /*
        AlunoTurma alunoTurma = new AlunoTurma();
        LocalDate dataMatricula = LocalDate.parse("2024-12-21");
        alunoTurma.setData_matricula(dataMatricula);
        
        alunoTurma.setCod_aluno_turma(11); //Chave Primaria(n pode dublicatas)
        alunoTurma.setCod_aluno(1);
        alunoTurma.setCod_turma(2);
       
        String resultado = teste.alterarAlunoTurma(alunoTurma);
        System.out.println("Alterado \n" + resultado);
      */
       
      
      //Remover AlunoTurma
      /*
        System.out.println("Removido");
        teste.imprimirAlunoTurma(teste.consultarAlunoTurmaPorCodigo(11));
        String resultado = teste.removerAlunoTurma(11); 
      */
        
      //Consultar AlunoTurma por Código
      /*
        AlunoTurma Consulta = teste.consultarAlunoTurmaPorCodigo(10);
        System.out.println("Informações do AlunoTurma consultado: ");
        teste.imprimirAlunoTurma(Consulta);
      */
      
      
      //Consultar AlunoTurmas
      /*
        ArrayList<AlunoTurma> alunoTurmas = teste.consultarAlunoTurma();
        System.out.println("AlunoTurmas cadastrados:");
        teste.imprimirAlunoTurma(alunoTurmas);
      */
        
        
    }
    
}