package Teste;

import controle.OcorrenciaControle;
import java.time.LocalDate;
import modelo.Ocorrencia;
import java.util.ArrayList;


public class OcorrenciaTeste {
    
    public static void main(String[] args) {
        
       OcorrenciaControle teste = new OcorrenciaControle();
     
      //Inserir Ocorrencia
      /*
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setCampus("IFTmUdiCentro");
        ocorrencia.setResolucao("Em andamento");
        ocorrencia.setDescricao_ocorrencia("Assassinato");
        
        LocalDate dataRegistro = LocalDate.parse("2023-12-21");
        ocorrencia.setData_registro_ocorrencia(dataRegistro);
        
        LocalDate dataAcont = LocalDate.parse("2023-12-20");
        ocorrencia.setData_acontecimento(dataAcont);
        
        ocorrencia.setCod_aluno(1);
        ocorrencia.setCod_funcionario(2);
       
        String resultado = teste.inserirOcorrencia(ocorrencia);
        System.out.println("Inserido \n" + resultado);
      */
        
   
   
      
      //Alterar Ocorrencia
      /*
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setCod_ocorrencia(11);
        ocorrencia.setCampus("IFTmUdiCentro");
        ocorrencia.setResolucao("Concluido");
        ocorrencia.setDescricao_ocorrencia("Assassinato Duplo");
        
        LocalDate dataRegistro = LocalDate.parse("2023-12-21");
        ocorrencia.setData_registro_ocorrencia(dataRegistro);
        
        LocalDate dataAcont = LocalDate.parse("2023-12-20");
        ocorrencia.setData_acontecimento(dataAcont);
        
        ocorrencia.setCod_aluno(1);
        ocorrencia.setCod_funcionario(2);
       
        String resultado = teste.alterarOcorrencia(ocorrencia);
        System.out.println("Alterado \n" + resultado);
      */
       
      
      //Remover Ocorrencia
      /*
        System.out.println("Removido");
        teste.imprimirOcorrencia(teste.consultarOcorrenciaPorCodigo(11));
        String resultado = teste.removerOcorrencia(11); 
      */
        
      //Consultar Ocorrencia por Código
      /*
        Ocorrencia Consulta = teste.consultarOcorrenciaPorCodigo(10);
        System.out.println("Informações do Ocorrencia consultado: ");
        teste.imprimirOcorrencia(Consulta);
      */
      
      
      //Consultar Ocorrencias
      
        ArrayList<Ocorrencia> ocorrencias = teste.consultarOcorrencias();
        System.out.println("Ocorrencias cadastradas:");
        teste.imprimirOcorrencia(ocorrencias);
      
        
        
    }
    
}

