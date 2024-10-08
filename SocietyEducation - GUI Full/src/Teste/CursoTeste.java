package Teste;

import controle.CursoControle;
import java.util.ArrayList;
import modelo.Curso;

public class CursoTeste {
   
    public static void main(String[] args) {
        
       CursoControle teste = new CursoControle();
     
      //Inserir Curso
      /* 
        Curso curso = new Curso();
        curso.setSigla("EXA");
        curso.setNome_curso("Macaco3");
       
        String resultado = teste.inserirCurso(curso);
        System.out.println("Inserido \n" + resultado);
      */ 
   
      
      //Alterar Curso
      /*
        Curso curso = new Curso(); 
        curso.setCod_curso(4);
        curso.setNome_curso("Enfermagem");
        curso.setSigla("ENF");
        
        String resultado = teste.alterarCurso(curso);
        System.out.println("alterado: " + resultado);
      */
       
      
      //Remover Curso
      /*  
        System.out.println("Removido");
        teste.imprimirCurso(teste.consultarCursoPorCodigo(1));
        String resultado = teste.removerCurso(1); // testar remover
      */
        
      //Consultar Curso por Código
      /*
        Curso Consulta = teste.consultarCursoPorCodigo(7);
        System.out.println("Detalhes do curso consultado: ");
        teste.imprimirCurso(Consulta);
      */
      
      
      //Consultar Cursos
      /*  
        ArrayList<Curso> cursos = teste.consultarCursos();
        System.out.println("Cursos cadastrados:");
        teste.imprimirCursos(cursos);
      */
        
        
    }
}
