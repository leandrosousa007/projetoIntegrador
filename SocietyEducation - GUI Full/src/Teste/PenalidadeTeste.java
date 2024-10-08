//PenalidadeTeste (n está concluido)
package Teste;

import controle.PenalidadeControle;
import java.time.LocalDate;
import modelo.Penalidade;
import java.util.ArrayList;


public class PenalidadeTeste {
    
    public static void main(String[] args) {
        
       PenalidadeControle teste = new PenalidadeControle();
     
      //Inserir Penalidade
      /*
        Penalidade penalidade = new Penalidade();
        penalidade.setTipo("Leozin dos crias ");
        penalidade.setQnt_dias(2);
       
        
        LocalDate dataInicio = LocalDate.parse("2035-12-21");
        penalidade.setData_inicio(dataInicio);
        
        penalidade.setCod_ocorrencia(2);
       
        String resultado = teste.inserirPenalidade(penalidade);
        System.out.println("Inserido \n" + resultado);
      */
   
      
      //Alterar Penalidade
      /*
        Penalidade penalidade = new Penalidade();
        penalidade.setTipo("Leozin");
        penalidade.setQnt_dias(2);
       
        
        LocalDate dataInicio = LocalDate.parse("2024-12-21");
        penalidade.setData_inicio(dataInicio);
        
        penalidade.setCod_penalidade(1); // chave primaria
        penalidade.setCod_ocorrencia(2);
       
       
        String resultado = teste.alterarPenalidade(penalidade);
        System.out.println("Alterado \n" + resultado);
      */
       
      
      //Remover Penalidade
      /*
        System.out.println("Removido");
        teste.imprimirPenalidade(teste.consultarPenalidadePorCodigo(2));
        String resultado = teste.removerPenalidade(2); 
      */
        
      //Consultar Penalidade por Código
      /*
        Penalidade Consulta = teste.consultarPenalidadePorCodigo(7);
        System.out.println("Informações do Penalidade consultado: ");
        teste.imprimirPenalidade(Consulta);
      */
      
      
      //Consultar Penalidades
      /*
        ArrayList<Penalidade> penalidades = teste.consultarPenalidades();
        System.out.println("Penalidades cadastrados:");
        teste.imprimirPenalidade(penalidades);
      */
        
        
    }
    
}
