package com.aplicacao;

import com.aplicacao.dao.Ocorrencia;
import com.aplicacao.model.OcorrenciaModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author aluno
 */
@Controller
public class OcorrenciaController {
    
    
    @RequestMapping(value = "/inserirOcorrencia", method = RequestMethod.GET) 
    public ModelAndView inserirOcorrencia() {
        return new ModelAndView("inserirOcorrencia", "command", new Ocorrencia()); 
    } 
    
    @RequestMapping(value = "/alterarOcorrencia", method = RequestMethod.GET) 
    public ModelAndView alterarOcorrencia() {
        return new ModelAndView("alterarOcorrencia"); 
    } 
    
    @RequestMapping(value = "/removerOcorrencia", method = RequestMethod.GET) 
    public ModelAndView removerOcorrencia() {
        return new ModelAndView("removerOcorrencia"); 
    } 
    
    @RequestMapping(value = "/consultarUmaOcorrencia", method = RequestMethod.GET) 
    public ModelAndView consultarUmaOcorrencia() {
        return new ModelAndView("consultarUmaOcorrencia"); 
    } 
    
    
    
    @ModelAttribute("ocorrencia")
    public Ocorrencia criarOcorrenciaModelo() {
        return new Ocorrencia();
    }
    
    //Inserir
    @RequestMapping(value = "/inserirOcorrencia", method = RequestMethod.POST) 
    public String inserirOcorrencia(@ModelAttribute("ocorrencia")@Validated Ocorrencia est, BindingResult bindingResult, Model modelo) { 
        if (bindingResult.hasErrors()) { 
            return "inserirOcorrencia";
        } 
        String resultado = "";
        
        modelo.addAttribute("campus", est.getCampus());
        modelo.addAttribute("data_registro_ocorrencia", est.getData_registro_ocorrencia());
        modelo.addAttribute("resolucao", est.getResolucao());
        modelo.addAttribute("data_ocorrencia", est.getData_acontecimento());
        modelo.addAttribute("descricao_oorrencia", est.getDescricao_ocorrencia());
        modelo.addAttribute("cod_aluno", est.getCod_aluno());
        modelo.addAttribute("cod_funcionario", est.getCod_funcionario());
        
        
        resultado = inserirOcorrenciaBanco(est);
        
        
        if ("inserido".equals(resultado)) {
        modelo.addAttribute("resultado", "Ocorrencia Inserido com sucesso!");
        modelo.addAttribute("ocorrencia", new Ocorrencia());
    } else {
        modelo.addAttribute("resultado", "Erro ao inserir ocorrencia.");
    }
        
        return "inserirOcorrencia";
    }

    public String inserirOcorrenciaBanco(Ocorrencia cur){
        OcorrenciaModel con = new OcorrenciaModel();
        String res = con.inserirOcorrencia(cur);
        return res;
    }
    //Fim inserção
    
    //Consulta do Ocorrencia
    @RequestMapping(value = "/consultarUmaOcorrencia", method = RequestMethod.POST) 
    public String consultarUmaOcorrencia(@ModelAttribute("ocorrencia")Ocorrencia est, Model modelo) { 
       
        Ocorrencia dadosOcorrencia = consultarOcorrenciaBancoCodigo(est.getCod_ocorrencia());
        
        modelo.addAttribute("cod_ocorrencia", dadosOcorrencia.getCod_ocorrencia());
        modelo.addAttribute("campus", dadosOcorrencia.getCampus());
        modelo.addAttribute("data_registro_ocorrencia", dadosOcorrencia.getData_registro_ocorrencia());
        modelo.addAttribute("resolucao", dadosOcorrencia.getResolucao());
        modelo.addAttribute("data_acontecimento", dadosOcorrencia.getData_acontecimento());
        modelo.addAttribute("descricao_ocorrencia", dadosOcorrencia.getDescricao_ocorrencia());
        modelo.addAttribute("cod_aluno", dadosOcorrencia.getCod_aluno());
        modelo.addAttribute("cod_funcionario", dadosOcorrencia.getCod_funcionario());
        modelo.addAttribute("ocorrencia", new Ocorrencia());
        return "consultarUmaOcorrencia"; 
    }
    
    public ArrayList<Ocorrencia> consultarOcorrenciaBanco(){
        OcorrenciaModel con = new OcorrenciaModel();
        ArrayList<Ocorrencia> lista = con.consultarOcorrencias();
        return lista;
    }

    public Ocorrencia consultarOcorrenciaBancoCodigo(int cod_ocorrencia){
        OcorrenciaModel con = new OcorrenciaModel();
        Ocorrencia lista = con.consultarOcorrenciaPorCodigo(cod_ocorrencia);
        return lista;
    }
    
    @ModelAttribute("webConsultarOcorrencias") 
    public Map<Integer, String> webConsultarOcorrencias() { 
        ArrayList<Ocorrencia>  con = consultarOcorrenciaBanco();
        
        Map<Integer, String> consultarOcorrencias = new HashMap<>();
        for(Ocorrencia ocorrencia : con){
            String des = ocorrencia.getCod_ocorrencia()+ " - "+ ocorrencia.getCod_aluno()+ " - "+ ocorrencia.getData_registro_ocorrencia();
            consultarOcorrencias.put(ocorrencia.getCod_ocorrencia(), des);
        }return consultarOcorrencias;
    }
    //Fim da Consulta do Ocorrencia
    
    //Remoção do Ocorrencia
    @RequestMapping(value = "/removerOcorrencia", method = RequestMethod.POST) 
    public String removerOcorrencia(@ModelAttribute("ocorrencia") Ocorrencia est, Model modelo) { 
        String resultado = removerOcorrenciaBanco(est.getCod_ocorrencia());
        
        if ("removido".equals(resultado)) {
            modelo.addAttribute("resultado", "Ocorrencia removido com sucesso!");
            modelo.addAttribute("ocorrencia", new Ocorrencia());
            modelo.addAttribute("webConsultarOcorrencias", webConsultarOcorrencias());
        } else {
            modelo.addAttribute("resultado", "Erro ao remover ocorrencia.");
        }
        
        return "removerOcorrencia"; 
    }

    public String removerOcorrenciaBanco(int cod_ocorrencia) {
        OcorrenciaModel con = new OcorrenciaModel();
        String res = con.removerOcorrencia(cod_ocorrencia);
        return res;
    }
    //Fim remoção do Ocorrencia
    
    //Alterar Ocorrencia
    @RequestMapping(value = "/alterarOcorrencia", method = RequestMethod.POST)
    public String alterarOcorrencia(@ModelAttribute("ocorrencia") @Validated Ocorrencia est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "alterarOcorrencia";
        }
        String resultado = alterarOcorrenciaBanco(est);

        if ("alterado".equals(resultado)) {
            modelo.addAttribute("resultado", "Ocorrencia alterado com sucesso!");
            modelo.addAttribute("ocorrencia", new Ocorrencia());
            modelo.addAttribute("webConsultarOcorrencias", webConsultarOcorrencias());
        } else {
            modelo.addAttribute("resultado", "Erro ao alterar ocorrencia.");
        }

        return "alterarOcorrencia";
    }

    public String alterarOcorrenciaBanco(Ocorrencia cur) {
        OcorrenciaModel con = new OcorrenciaModel();
        String res = con.alterarOcorrencia(cur); 
        return res;
    }
    
    //Chamando o Array com os aluno
    @Autowired
    private AlunoController alunoController;
    
    @ModelAttribute("webConsultarAlunos")
    public Map<Integer, String> webConsultarAlunos(){
        return alunoController.webConsultarAlunos();
    }
    
    //Chamando o Array com os funcionario
    @Autowired
    private FuncionarioController funcionarioController;
    
    @ModelAttribute("webConsultarFuncionarios")
    public Map<Integer, String> webConsultarFuncionarios(){
        return funcionarioController.webConsultarFuncionarios();
    }
}
