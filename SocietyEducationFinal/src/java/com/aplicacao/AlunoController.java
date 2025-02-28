package com.aplicacao;

import com.aplicacao.dao.Aluno;
import com.aplicacao.model.AlunoModel;
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
public class AlunoController {
    
    //Para abrir a pagina da respectivo função
    @RequestMapping(value = "/inserirAluno", method = RequestMethod.GET)
    public ModelAndView inserirAluno() {
        return new ModelAndView("inserirAluno", "command", new Aluno());
    }
    
    @RequestMapping(value = "/consultarUmAluno", method = RequestMethod.GET)
    public ModelAndView coinsultarUmAluno() {
        return new ModelAndView("consultarUmAluno");
    }
    
    @RequestMapping(value = "/alterarAluno", method = RequestMethod.GET)
    public ModelAndView alterarAluno() {
        return new ModelAndView("alterarAluno");
    }

    @RequestMapping(value = "/removerAluno", method = RequestMethod.GET)
    public ModelAndView removerAluno() {
        return new ModelAndView("removerAluno");
    }
    //fim
    
    // Criar o modelo de Aluno para ser utilizado no formulário
    @ModelAttribute("aluno")
    public Aluno criarAlunoModelo() {
        return new Aluno();
    }
    
    

    
    // Inserir aluno
    @RequestMapping(value = "/inserirAluno", method = RequestMethod.POST)
    public String inserirAluno(@ModelAttribute("aluno") @Validated Aluno est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "inserirAluno";
        }
        String resultado = "";
  
        
        modelo.addAttribute("nome", est.getNome());
        modelo.addAttribute("matricula", est.getMatricula()+"");
        modelo.addAttribute("rg", est.getRg());
        modelo.addAttribute("email", est.getEmail());
        modelo.addAttribute("telefone", est.getTelefone());
        modelo.addAttribute("endereco", est.getEndereco());
        modelo.addAttribute("sexo", est.getSexo()+"");
        modelo.addAttribute("data_nasc", est.getData_nasc());
        modelo.addAttribute("cod_curso", est.getCod_curso());
        modelo.addAttribute("cod_resp", est.getCod_resp());
        resultado = inserirAlunoBanco(est);
        
        
        if("inserido".equals(resultado)) {
        modelo.addAttribute("resultado", "Aluno Inserido com sucesso!");
        modelo.addAttribute("aluno", new Aluno());
    
        } else {
        modelo.addAttribute("resultado", "Erro ao inserir aluno!!.");
    }
        return "inserirAluno";
    }

    //Inserir aluno no banco de dados
    public String inserirAlunoBanco(Aluno alu) {
        AlunoModel con = new AlunoModel();
        String res = con.inserirAluno(alu);
        return res;
    }
    
    //Fim da Inserção
    
    
    //Consulta do Aluno
    @RequestMapping(value = "/consultarUmAluno", method = RequestMethod.POST) 
    public String consultarUmAluno(@ModelAttribute("aluno")Aluno est, Model modelo) { 
       
        Aluno dadosAluno = consultarAlunoBancoCodigo(est.getCod_aluno());
        
        modelo.addAttribute("cod_aluno", dadosAluno.getCod_aluno());
        modelo.addAttribute("matricula", dadosAluno.getMatricula());
        modelo.addAttribute("nome", dadosAluno.getNome());
        modelo.addAttribute("rg", dadosAluno.getRg());
        modelo.addAttribute("email", dadosAluno.getEmail());
        modelo.addAttribute("telefone", dadosAluno.getTelefone());
        modelo.addAttribute("endereco", dadosAluno.getEndereco());
        modelo.addAttribute("sexo", dadosAluno.getSexo());
        modelo.addAttribute("data_nasc", dadosAluno.getData_nasc());
        modelo.addAttribute("cod_curso", dadosAluno.getCod_curso());
        modelo.addAttribute("cod_resp", dadosAluno.getCod_resp());
        
        
        modelo.addAttribute("aluno", new Aluno());
        return "consultarUmAluno"; 
    }
    
    public ArrayList<Aluno> consultarAlunoBanco(){
        AlunoModel con = new AlunoModel();
        ArrayList<Aluno> lista = con.consultarAlunos();
        return lista;
    }

    public Aluno consultarAlunoBancoCodigo(int cod_aluno){
        AlunoModel con = new AlunoModel();
        Aluno lista = con.consultarAlunoPorCodigo(cod_aluno);
        return lista;
    }
    
    @ModelAttribute("webConsultarAlunos") 
    public Map<Integer, String> webConsultarAlunos() { 
        ArrayList<Aluno>  con = consultarAlunoBanco();
        
        Map<Integer, String> consultarAlunos = new HashMap<>();
        for(Aluno aluno : con){
            String des = aluno.getCod_aluno() + " - " + aluno.getNome();
            consultarAlunos.put(aluno.getCod_aluno(), des);
        
    }return consultarAlunos;
    }
    //Fim da Consulta do Aluno
    
    
    //Remoção do Aluno
    @RequestMapping(value = "/removerAluno", method = RequestMethod.POST) 
    public String removerAluno(@ModelAttribute("aluno") Aluno est, Model modelo) { 
        String resultado = removerAlunoBanco(est.getCod_aluno());
        
        if ("removido".equals(resultado)) {
            modelo.addAttribute("resultado", "Aluno removido com sucesso!");
            modelo.addAttribute("aluno", new Aluno());
            modelo.addAttribute("webConsultarAlunos", webConsultarAlunos());
        } else {
            modelo.addAttribute("resultado", "Erro ao remover Aluno.");
        }
        
        return "removerAluno"; 
    }

    public String removerAlunoBanco(int cod_aluno) {
        AlunoModel con = new AlunoModel();
        String res = con.removerAluno(cod_aluno);
        return res;
    }
    //Fim remoção do Curso
    
    
    
    
    
    @ModelAttribute("sexoEscolha")
    public Map<String, String > sexoEscolha() {
        Map<String, String> sel = new HashMap<>();
        sel.put("M", "Masculino");
        sel.put("F", "Feminino");
        return sel;
    }
    
    //Chamando o Array com os cursos
    @Autowired
    private CursoController cursoController;
    
    @ModelAttribute("webConsultarCursos")
    public Map<Integer, String> webConsultarCursos(){
        return cursoController.webConsultarCursos();
    }
    
   //Chamando o Array com os responsaveis
    @Autowired
    private ResponsavelController responsavelController;
    
    @ModelAttribute("webConsultarResponsaveis")
    public Map<Integer, String> webConsultarResponsaveis(){
        return responsavelController.webConsultarResponsaveis();
    }
   
      
    
    }
