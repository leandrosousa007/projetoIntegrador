package Teste;

import controle.AlunoControle;
import java.time.LocalDate;
import modelo.Aluno;
import java.util.ArrayList;


public class AlunoTeste {
    
    public static void main(String[] args) {
        
       AlunoControle teste = new AlunoControle();
     
      //Inserir Aluno
      /* 
        Aluno aluno = new Aluno();
        aluno.setNome("Leozin");
        aluno.setMatricula("1234567");
        aluno.setRg("80000");
        aluno.setEmail("leo@gmail.com");
        aluno.setTelefone("34996848289");
        aluno.setEndereco("Rua da patria, 180");
        
        LocalDate dataNascimento = LocalDate.parse("2006-12-21");
        aluno.setData_nasc(dataNascimento);
        
        aluno.setSexo('M');
        aluno.setCod_curso(1);
        aluno.setCod_resp(2);
       
        String resultado = teste.inserirAluno(aluno);
        System.out.println("Inserido \n" + resultado);
      */
   
      
      //Alterar Aluno
      /*
        Aluno aluno = new Aluno();
        aluno.setCod_aluno(2);
        aluno.setNome("Leozin33");
        aluno.setMatricula("1234567");
        aluno.setRg("80000");
        aluno.setEmail("leo@gmail.com");
        aluno.setTelefone("34996848289");
        aluno.setEndereco("Rua da patria, 180");
        
        LocalDate dataNascimento = LocalDate.parse("2006-12-21");
        aluno.setData_nasc(dataNascimento);
        
        aluno.setSexo('M');
        aluno.setCod_curso(1);
        aluno.setCod_resp(2);
       
        String resultado = teste.alterarAluno(aluno);
        System.out.println("Alterado \n" + resultado);
      */
       
      
      //Remover Aluno
      /*
        System.out.println("Removido");
        teste.imprimirAluno(teste.consultarAlunoPorCodigo(2));
        String resultado = teste.removerAluno(2); 
      */
        
      //Consultar Aluno por Código
      /*
        Aluno Consulta = teste.consultarAlunoPorCodigo(7);
        System.out.println("Informações do Aluno consultado: ");
        teste.imprimirAluno(Consulta);
      */
      
      
      //Consultar Alunos
      /*
        ArrayList<Aluno> alunos = teste.consultarAlunos();
        System.out.println("Alunos cadastrados:");
        teste.imprimirAlunos(alunos);
      */
        
        
    }
    
}
