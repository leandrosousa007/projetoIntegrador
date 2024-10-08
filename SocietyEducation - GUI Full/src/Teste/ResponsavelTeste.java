package Teste;

import controle.ResponsavelControle;
import java.time.LocalDate;
import modelo.Responsavel;
import java.util.ArrayList;



public class ResponsavelTeste {
    
    public static void main(String[] args) {
        
       ResponsavelControle teste = new ResponsavelControle();
     
      //Inserir Responsavel
      /*
        Responsavel responsavel = new Responsavel();
        responsavel.setNome_resp("Junior");
        responsavel.setTelefone("34996466442");
        responsavel.setEmail("victor@gmail.com");
        responsavel.setEndereco("Rua Camargo, 350");
        
        
       
        responsavel.setCod_resp(11);
       
       
        String resultado = teste.inserirResponsavel(responsavel);
        System.out.println("Inserido \n" + resultado);
      */
   
      
      //Alterar Responsavel
      
       /* Responsavel responsavel = new Responsavel();
         responsavel.setNome_resp("Amanda");
        responsavel.setTelefone("3499451442");
        responsavel.setEmail("victor@hotmail.com");
        responsavel.setEndereco("Rua opala, 380");
        
        
       
        responsavel.setCod_resp(11);
       
        String resultado = teste.alterarResponsavel(responsavel);
        System.out.println("Alterado \n" + resultado);
      
       */
      
      //Remover Responsavel
      /*
        System.out.println("Removido");
        teste.imprimirResponsavel(teste.consultarResponsavelPorCodigo(11));
        String resultado = teste.removerResponsavel(2); 
      */
 
      //Consultar Responsavel por Código
      /*
        Responsavel Consulta = teste.consultarResponsavelPorCodigo(11);
        System.out.println("Informações do Responsavel consultado: ");
        teste.imprimirResponsavel(Consulta);
      */
      
      
      //Consultar Responsavels
      /*
        ArrayList<Responsavel> responsavels = teste.consultarResponsavels();
        System.out.println("Responsavels cadastrados:");
        teste.imprimirResponsavels(responsavels);
      */
        
        
    }
    
}

