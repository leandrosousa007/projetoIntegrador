package Teste;

import controle.FuncionarioControle;
import java.util.ArrayList;
import modelo.Funcionario;

public class FuncionarioTeste {
   
    public static void main(String[] args) {
        
       FuncionarioControle teste = new FuncionarioControle();
     
      //Inserir Funcionario
      /*
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Alexandro");
        funcionario.setCargo("professor");
       
       
        String resultado = teste.inserirFuncionario(funcionario);
        System.out.println("Inserido \n" + resultado);
      */
   
      
      //Alterar Funcionario
      
      /*  Funcionario funcionario = new Funcionario(); 
        funcionario.setNome("Alexandro");
        funcionario.setCargo("Professor");
       
         funcionario.setCod_funcionario(10);
        
        String resultado = teste.alterarFuncionario(funcionario);
        System.out.println("alterado: " + resultado);
      
       
      */
      //Remover Funcionario
      /*  
        System.out.println("Removido");
        teste.imprimirFuncionario(teste.consultarFuncionarioPorCodigo(13));
        String resultado = teste.removerFuncionario(14); // testar remover
      */
        
      //Consultar Funcionario por Código
      /*
        Funcionario Consulta = teste.consultarFuncionarioPorCodigo(12);
        System.out.println("Detalhes do funcionario consultado: ");
        teste.imprimirFuncionario(Consulta);
      */
      
      
      //Consultar Funcionarios
      /*  
        ArrayList<Funcionario> funcionarios = teste.consultarFuncionarios();
        System.out.println("Funcionarios cadastrados:");
        teste.imprimirFuncionarios(funcionarios);
      */
        
        
    }
}

