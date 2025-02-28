package com.aplicacao;

import com.aplicacao.dao.AlunoTurma;
import com.aplicacao.model.AlunoTurmaModel;
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
public class AlunoTurmaController {
    
    //Para abrir a pagina da respectivo função
    @RequestMapping(value = "/inserirAlunoTurma", method = RequestMethod.GET)
    public ModelAndView inserirAlunoTurma() {
        return new ModelAndView("inserirAlunoTurma", "command", new AlunoTurma());
    }
    
    @RequestMapping(value = "/consultarUmAlunoTurma", method = RequestMethod.GET)
    public ModelAndView coinsultarUmAlunoTurma() {
        return new ModelAndView("consultarUmAlunoTurma");
    }
    
    @RequestMapping(value = "/alterarAlunoTurma", method = RequestMethod.GET)
    public ModelAndView alterarAlunoTurma() {
        return new ModelAndView("alterarAlunoTurma");
    }

    @RequestMapping(value = "/removerAlunoTurma", method = RequestMethod.GET)
    public ModelAndView removerAlunoTurma() {
        return new ModelAndView("removerAlunoTurma");
    }
    //fim
    
    // Criar o modelo de Aluno para ser utilizado no formulário
    @ModelAttribute("alunoturma")
    public AlunoTurma criarAlunoTurmaModelo() {
        return new AlunoTurma();
    }
    


// Inserir aluno
    @RequestMapping(value = "/inserirAlunoTurma", method = RequestMethod.POST)
    public String inserirAlunoTurma(@ModelAttribute("alunoturma") @Validated AlunoTurma est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "inserirAlunoTurma";
        }
        String resultado = "";
  
        
        modelo.addAttribute("data_matricula", est.getData_matricula()+"");
        modelo.addAttribute("cod_aluno", est.getCod_aluno());
        modelo.addAttribute("cod_turma", est.getCod_turma());
        resultado = inserirAlunoBanco(est);
        
        
        if("inserido".equals(resultado)) {
        modelo.addAttribute("resultado", "AlunoTurma Inserido com sucesso!");
        modelo.addAttribute("alunoturma", new AlunoTurma());
    
        } else {
        modelo.addAttribute("resultado", "Erro ao inserir alunoturma!!.");
    }
        return "inserirAlunoTurma";
    }

    //Inserir aluno no banco de dados
    public String inserirAlunoBanco(AlunoTurma alt) {
        AlunoTurmaModel con = new AlunoTurmaModel();
        String res = con.inserirAlunoTurma(alt);
        return res;
    }
    
    
    
    //Chamando o Array com os alunos
    
    @Autowired
    private AlunoController alunoController;
    
    @ModelAttribute("webConsultarAlunos")
    public Map<Integer, String> webConsultarAlunos(){
        return alunoController.webConsultarAlunos();
    }
    
    //Chamando o Array com os alunos
    
    @Autowired
    private TurmaController turmaController;
    
    @ModelAttribute("webConsultarTurmas")
    public Map<Integer, String> webConsultarTurmas(){
        return turmaController.webConsultarTurmas();
    }
    
    //Fim da Inserção
    
    
    
    //Consulta do alunoturma
    @RequestMapping(value = "/consultarUmAlunoTurma", method = RequestMethod.POST) 
    public String consultarUmAlunoTurma(@ModelAttribute("alunoturma")AlunoTurma est, Model modelo) { 
       
        AlunoTurma dadosAlunoTurma = consultarAlunoTurmaBancoCodigo(est.getCod_aluno_turma());
        
        modelo.addAttribute("cod_aluno_turma", dadosAlunoTurma.getCod_aluno_turma());
        modelo.addAttribute("data_matricula", dadosAlunoTurma.getData_matricula()); 
        modelo.addAttribute("cod_aluno", dadosAlunoTurma.getCod_aluno());
        modelo.addAttribute("cod_turma", dadosAlunoTurma.getCod_turma());
        return "consultarUmAlunoTurma"; 
    }
    
    public ArrayList<AlunoTurma> consultarAlunoTurmaBanco(){
        AlunoTurmaModel con = new AlunoTurmaModel();
        ArrayList<AlunoTurma> lista = con.consultarAlunosTurmas();
        return lista;
    }

    public AlunoTurma consultarAlunoTurmaBancoCodigo(int cod_alunoturma){
        AlunoTurmaModel con = new AlunoTurmaModel();
        AlunoTurma lista = con.consultarAlunoTurmaPorCodigo(cod_alunoturma);
        return lista;
    }
    
    @ModelAttribute("webConsultarAlunosTurmas") 
public Map<Integer, String> webConsultarAlunosTurmas() { 
    ArrayList<AlunoTurma> con = consultarAlunoTurmaBanco();
    
    Map<Integer, String> consultarAlunosTurmas = new HashMap<>();
    for (AlunoTurma alunoTurma : con) {
        String des = alunoTurma.getCod_aluno_turma() + " - " + alunoTurma.getCod_aluno() + " - " + alunoTurma.getCod_aluno();
        consultarAlunosTurmas.put(alunoTurma.getCod_aluno_turma(), des);
    }
    return consultarAlunosTurmas;
}
    //Fim da Consulta do alunoturma


//Alterar alunoturma
    @RequestMapping(value = "/alterarAlunoTurma", method = RequestMethod.POST)
    public String alterarAlunoTurma(@ModelAttribute("alunoturma") @Validated AlunoTurma est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "alterarAlunoTurma";
        }
        String resultado = alterarAlunoTurmaBanco(est);

        if ("alterado".equals(resultado)) {
            modelo.addAttribute("resultado", "AlunoTurma alterado com sucesso!");
            modelo.addAttribute("alunoturma", new AlunoTurma());
            modelo.addAttribute("webConsultarAlunosTurmas", webConsultarAlunosTurmas());
        } else {
            modelo.addAttribute("resultado", "Erro ao alterar alunoturma.");
        }

        return "alterarAlunoTurma";
    }

    public String alterarAlunoTurmaBanco(AlunoTurma alt) {
        AlunoTurmaModel con = new AlunoTurmaModel();
        String res = con.alterarAlunoTurma(alt); 
        return res;
    }

    
    //Remoção do AlunoTurma
    @RequestMapping(value = "/removerAlunoTurma", method = RequestMethod.POST) 
    public String removerAlunoTurma(@ModelAttribute("alunoturma") AlunoTurma est, Model modelo) { 
        String resultado = removerAlunoTurmaBanco(est.getCod_aluno_turma());
        
        if ("removido".equals(resultado)) {
            modelo.addAttribute("resultado", "AlunoTurma removido com sucesso!");
            modelo.addAttribute("alunoturma", new AlunoTurma());
            modelo.addAttribute("webConsultarAlunosTurmas", webConsultarAlunosTurmas());
        } else {
            modelo.addAttribute("resultado", "Erro ao remover aluno_turma.");
        }
        
        return "removerAlunoTurma"; 
    }

    public String removerAlunoTurmaBanco(int cod_aluno_turma) {
        AlunoTurmaModel con = new AlunoTurmaModel();
        String res = con.removerAlunoTurma(cod_aluno_turma);
        return res;
    }
    //Fim remoção do AlunoTurma
}

