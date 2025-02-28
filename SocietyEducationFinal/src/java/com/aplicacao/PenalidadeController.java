package com.aplicacao;

import com.aplicacao.dao.Penalidade;
import com.aplicacao.model.PenalidadeModel;
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
public class PenalidadeController {
    
    
    @RequestMapping(value = "/inserirPenalidade", method = RequestMethod.GET) 
    public ModelAndView inserirPenalidade() {
        return new ModelAndView("inserirPenalidade", "command", new Penalidade()); 
    } 
    
    @RequestMapping(value = "/alterarPenalidade", method = RequestMethod.GET) 
    public ModelAndView alterarPenalidade() {
        return new ModelAndView("alterarPenalidade"); 
    } 
    
    @RequestMapping(value = "/removerPenalidade", method = RequestMethod.GET) 
    public ModelAndView removerPenalidade() {
        return new ModelAndView("removerPenalidade"); 
    } 
    
    @RequestMapping(value = "/consultarUmaPenalidade", method = RequestMethod.GET) 
    public ModelAndView consultarUmaPenalidade() {
        return new ModelAndView("consultarUmaPenalidade"); 
    } 
    
    
    @ModelAttribute("penalidade")
    public Penalidade criarPenalidadeModelo() {
        return new Penalidade();
    }
    
    //Inserir
    @RequestMapping(value = "/inserirPenalidade", method = RequestMethod.POST) 
    public String inserirPenalidade(@ModelAttribute("penalidade")@Validated Penalidade est, BindingResult bindingResult, Model modelo) { 
        if (bindingResult.hasErrors()) { 
            return "inserirPenalidade";
        } 
        String resultado = "";
        
        modelo.addAttribute("tipo", est.getTipo()); 
        modelo.addAttribute("data_inicio", est.getData_inicio());
        modelo.addAttribute("qnt_dias", est.getQnt_dias()); 
        modelo.addAttribute("cod_ocorrencia", est.getCod_ocorrencia());  
        
        resultado = inserirPenalidadeBanco(est);
        
        if ("inserido".equals(resultado)) {
        modelo.addAttribute("resultado", "Penalidade Inserido com sucesso!");
        modelo.addAttribute("penalidade", new Penalidade());
    } else {
        modelo.addAttribute("resultado", "Erro ao inserir penalidade.");
    }
        
        return "inserirPenalidade";
    }

    public String inserirPenalidadeBanco(Penalidade cur){
        PenalidadeModel con = new PenalidadeModel();
        String res = con.inserirPenalidade(cur);
        return res;
    }
    //Fim inserção
    
    //Consulta do Penalidade
    @RequestMapping(value = "/consultarUmaPenalidade", method = RequestMethod.POST) 
    public String consultarUmaPenalidade(@ModelAttribute("penalidade")Penalidade est, Model modelo) { 
       
        Penalidade dadosPenalidade = consultarPenalidadeBancoCodigo(est.getCod_penalidade());
        
        modelo.addAttribute("cod_penalidade", dadosPenalidade.getCod_penalidade());
        modelo.addAttribute("tipo", dadosPenalidade.getTipo()); 
        modelo.addAttribute("data_inicio", dadosPenalidade.getData_inicio());
        modelo.addAttribute("qnt_dias", dadosPenalidade.getQnt_dias()); 
        modelo.addAttribute("cod_ocorrencia", dadosPenalidade.getCod_ocorrencia());
        modelo.addAttribute("penalidade", new Penalidade());
        return "consultarUmaPenalidade"; 
    }
    
    public ArrayList<Penalidade> consultarPenalidadeBanco(){
        PenalidadeModel con = new PenalidadeModel();
        ArrayList<Penalidade> lista = con.consultarPenalidades();
        return lista;
    }

    public Penalidade consultarPenalidadeBancoCodigo(int cod_penalidade){
        PenalidadeModel con = new PenalidadeModel();
        Penalidade lista = con.consultarPenalidadePorCodigo(cod_penalidade);
        return lista;
    }
    
    @ModelAttribute("webConsultarPenalidades") 
    public Map<Integer, String> webConsultarPenalidades() { 
        ArrayList<Penalidade>  con = consultarPenalidadeBanco();
        
        Map<Integer, String> consultarPenalidades = new HashMap<>();
        for(Penalidade penalidade : con){
            
            String des = penalidade.getCod_penalidade()+ " - " + penalidade.getTipo();
            consultarPenalidades.put(penalidade.getCod_penalidade(), des);
        
    }
       return consultarPenalidades;
    }
   
    //Fim da Consulta do Penalidade
    
    //Remoção do Penalidade
    @RequestMapping(value = "/removerPenalidade", method = RequestMethod.POST) 
    public String removerPenalidade(@ModelAttribute("penalidade") Penalidade est, Model modelo) { 
        String resultado = removerPenalidadeBanco(est.getCod_penalidade());
        
        if ("removido".equals(resultado)) {
            modelo.addAttribute("resultado", "Penalidade removido com sucesso!");
            modelo.addAttribute("penalidade", new Penalidade());
            modelo.addAttribute("webConsultarPenalidades", webConsultarPenalidades());
        } else {
            modelo.addAttribute("resultado", "Erro ao remover penalidade.");
        }
        
        return "removerPenalidade"; 
    }

    public String removerPenalidadeBanco(int cod_penalidade) {
        PenalidadeModel con = new PenalidadeModel();
        String res = con.removerPenalidade(cod_penalidade);
        return res;
    }
    //Fim remoção do Penalidade
    
    //Alterar Penalidade
    @RequestMapping(value = "/alterarPenalidade", method = RequestMethod.POST)
    public String alterarPenalidade(@ModelAttribute("penalidade") @Validated Penalidade est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "alterarPenalidade";
        }
        String resultado = alterarPenalidadeBanco(est);

        if ("alterado".equals(resultado)) {
            modelo.addAttribute("resultado", "Penalidade alterada com sucesso!");
            modelo.addAttribute("penalidade", new Penalidade());
            modelo.addAttribute("webConsultarPenalidades", webConsultarPenalidades());
        } else {
            modelo.addAttribute("resultado", "Erro ao alterar penalidade.");
        }

        return "alterarPenalidade";
    }

    public String alterarPenalidadeBanco(Penalidade cur) {
        PenalidadeModel con = new PenalidadeModel();
        String res = con.alterarPenalidade(cur); 
        return res;
    }
    
    
    @ModelAttribute("webConsultarTipoPenalidade")
    public Map<String, String > webConsultarTipoPenalidade() {
        Map<String, String> sel = new HashMap<>();
        sel.put("Advertência Escrita", "Advertência Escrita");
        sel.put("Advertência Oral", "Advertência Oral");
        sel.put("Suspensão", "Suspensão");
        sel.put("Chamar Responsáveis", "Chamar Responsáveis");
        return sel;
    }
    
    //Chamando o Array com as ocorrencias
    @Autowired
    private OcorrenciaController ocorrenciaController;
    
    @ModelAttribute("webConsultarOcorrencias")
    public Map<Integer, String> webConsultarOcorrencias(){
        return ocorrenciaController.webConsultarOcorrencias();
    }
    

    
}
