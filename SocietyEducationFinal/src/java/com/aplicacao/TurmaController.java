package com.aplicacao;

import com.aplicacao.dao.Turma;
import com.aplicacao.model.TurmaModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TurmaController {
    
    //Para abrir a pagina da respectivo função
    @RequestMapping(value = "/inserirTurma", method = RequestMethod.GET)
    public ModelAndView inserirTurma() {
        return new ModelAndView("inserirTurma", "command", new Turma());
    }
    
    @RequestMapping(value = "/consultarUmaTurma", method = RequestMethod.GET)
    public ModelAndView coinsultarUmaTurma() {
        return new ModelAndView("consultarUmaTurma");
    }
    
    @RequestMapping(value = "/alterarTurma", method = RequestMethod.GET)
    public ModelAndView alterarTurma() {
        return new ModelAndView("alterarTurma");
    }

    @RequestMapping(value = "/removerTurma", method = RequestMethod.GET)
    public ModelAndView removerTurma() {
        return new ModelAndView("removerTurma");
    }
    //fim
    

// Criar o modelo de Turma para ser utilizado no formulário
    @ModelAttribute("turma")
    public Turma criarTurmaModelo() {
        return new Turma();
    }
    


// Inserir Turma
    @RequestMapping(value = "/inserirTurma", method = RequestMethod.POST)
    public String inserirTurma(@ModelAttribute("turma") @Validated Turma est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "inserirTurma";
        }

        String resultado = "";
        
        modelo.addAttribute("nome_turma", est.getNome_turma());
        modelo.addAttribute("ano", est.getAno());
        modelo.addAttribute("periodo", est.getPeriodo());
        modelo.addAttribute("cod_curso", est.getCod_curso());
        resultado = inserirTurmaBanco(est);
        
        
        if ("inserido".equals(resultado)) {
        modelo.addAttribute("resultado", "Turma Inserido com sucesso!");
        modelo.addAttribute("turma", new Turma());
    } else {
        modelo.addAttribute("resultado", "Erro ao inserir turma.");
    }
        
        return "inserirTurma";
    }

    //Inserir Turma no banco de dados
    public String inserirTurmaBanco(Turma turma) {
        TurmaModel con = new TurmaModel();
        String res = con.inserirTurma(turma);
        return res;
    }
       
    //Chamando o Array com os cursos
    @Autowired
    private CursoController cursoController;
    
    @ModelAttribute("webConsultarCursos")
    public Map<Integer, String> webConsultarCursos(){
        return cursoController.webConsultarCursos();
    }

    
    
//Consulta do Turma
    @RequestMapping(value = "/consultarUmaTurma", method = RequestMethod.POST) 
    public String consultarUmaTurma(@ModelAttribute("turma")Turma est, Model modelo) { 
       
        Turma dadosTurma = consultarTurmaBancoCodigo(est.getCod_turma());
        
        modelo.addAttribute("cod_turma", dadosTurma.getCod_turma());
        modelo.addAttribute("nome_turma", dadosTurma.getNome_turma());
        modelo.addAttribute("ano", dadosTurma.getAno());
        modelo.addAttribute("periodo", dadosTurma.getPeriodo());
        modelo.addAttribute("cod_curso", dadosTurma.getCod_curso());
        
        
        modelo.addAttribute("turma", new Turma());
        return "consultarUmaTurma"; 
    }
    
    public ArrayList<Turma> consultarTurmaBanco(){
        TurmaModel con = new TurmaModel();
        ArrayList<Turma> lista = con.consultarTurmas();
        return lista;
    }

    public Turma consultarTurmaBancoCodigo(int cod_turma){
        TurmaModel con = new TurmaModel();
        Turma lista = con.consultarTurmaPorCodigo(cod_turma);
        return lista;
    }
    
    @ModelAttribute("webConsultarTurmas") 
    public Map<Integer, String> webConsultarTurmas() { 
        ArrayList<Turma>  con = consultarTurmaBanco();
        
        Map<Integer, String> consultarTurmas = new HashMap<>();
        for(Turma turma : con){
            String des = turma.getCod_turma() + " - "+ turma.getNome_turma();
            consultarTurmas.put(turma.getCod_turma(), des);
        }return consultarTurmas;
    }
    //Fim da Consulta do Turma
    
    
     //Remoção do Turma
    @RequestMapping(value = "/removerTurma", method = RequestMethod.POST) 
    public String removerTurma(@ModelAttribute("turma") Turma est, Model modelo) { 
        String resultado = removerTurmaBanco(est.getCod_turma());
        
        if ("removido".equals(resultado)) {
            modelo.addAttribute("resultado", "Turma removido com sucesso!");
            modelo.addAttribute("Turma", new Turma());
            modelo.addAttribute("webConsultarTurmas", webConsultarTurmas());
        } else {
            modelo.addAttribute("resultado", "Erro ao remover Turma.");
        }
        
        return "removerTurma"; 
    }

    public String removerTurmaBanco(int cod_turma) {
        TurmaModel con = new TurmaModel();
        String res = con.removerTurma(cod_turma);
        return res;
    }
    //Fim remoção do Curso
    
    
    //Alterar Curso
    @RequestMapping(value = "/alterarTurma", method = RequestMethod.POST)
public String alterarTurma(@ModelAttribute("turma") @Validated Turma est, BindingResult bindingResult, Model modelo) {
    if (bindingResult.hasErrors()) {
        return "alterarTurma";
    }

    // Verifique se o cod_turma está definido
    if (est.getCod_turma() == 0) {
        modelo.addAttribute("resultado", "Erro: Selecione uma turma para alterar.");
        return "alterarTurma";
    }

    String resultado = alterarTurmaBanco(est);

    if ("alterado".equals(resultado)) {
        modelo.addAttribute("resultado", "Turma alterada com sucesso!");
        modelo.addAttribute("turma", new Turma());
        modelo.addAttribute("webConsultarTurmas", webConsultarTurmas());
    } else {
        modelo.addAttribute("resultado", resultado); 
    }

    return "alterarTurma";
}

    public String alterarTurmaBanco(Turma tur) {
        TurmaModel con = new TurmaModel();
        String res = con.alterarTurma(tur); 
        return res;
    }
    
    
    
    
    
    
    }
   
    
    

    