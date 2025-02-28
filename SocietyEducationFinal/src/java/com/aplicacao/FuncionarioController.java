/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacao;

import com.aplicacao.dao.Funcionario;
import com.aplicacao.model.FuncionarioModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class FuncionarioController {
    
    @RequestMapping(value = "/inserirFuncionario", method = RequestMethod.GET) 
    public ModelAndView inserirFuncionario() {
        return new ModelAndView("inserirFuncionario", "command", new Funcionario()); 
    } 
    
    @RequestMapping(value = "/alterarFuncionario", method = RequestMethod.GET) 
    public ModelAndView alterarFuncionario() {
        return new ModelAndView("alterarFuncionario", "command", new Funcionario()); 
    } 
    
    @RequestMapping(value = "/removerFuncionario", method = RequestMethod.GET) 
    public ModelAndView removerFuncionario() {
        return new ModelAndView("removerFuncionario", "command", new Funcionario()); 
    } 
    
    @RequestMapping(value = "/consultarUmFuncionario", method = RequestMethod.GET) 
    public ModelAndView consultarUmFuncionario() {
        return new ModelAndView("consultarUmFuncionario", "command", new Funcionario()); 
    } 
    
    
    
    @ModelAttribute("funcionario")
    public Funcionario criarFuncionarioModelo() {
        return new Funcionario();
    }
    
    //Inserir
    @RequestMapping(value = "/inserirFuncionario", method = RequestMethod.POST) 
    public String inserirFuncionario(@ModelAttribute("funcionario")@Validated Funcionario est, BindingResult bindingResult, Model modelo) { 
        if (bindingResult.hasErrors()) { 
            return "inserirFuncionario";
        } 
        String resultado = "";
        
        modelo.addAttribute("nome", est.getNome()); 
        modelo.addAttribute("cargo", est.getCargo());
        modelo.addAttribute("login", est.getLogin()); 
        modelo.addAttribute("senha", est.getSenha()); 
        resultado = inserirFuncionarioBanco(est);
        
        if ("inserido".equals(resultado)) {
        modelo.addAttribute("resultado", "Funcionario Inserido com sucesso!");
        modelo.addAttribute("funcionario", new Funcionario());
    } else {
        modelo.addAttribute("resultado", "Erro ao inserir funcionario.");
    }
        
        return "inserirFuncionario";
    }

    public String inserirFuncionarioBanco(Funcionario fun){
        FuncionarioModel con = new FuncionarioModel();
        String res = con.inserirFuncionario(fun);
        return res;
    }
    //Fim inserção
    
    //Consulta do Funcionario
    @RequestMapping(value = "/consultarUmFuncionario", method = RequestMethod.POST) 
    public String consultarUmFuncionario(@ModelAttribute("funcionario")Funcionario est, Model modelo) { 
       
        Funcionario dadosFuncionario = consultarFuncionarioBancoCodigo(est.getCod_funcionario());
        
        modelo.addAttribute("cod_funcionario", dadosFuncionario.getCod_funcionario());
        modelo.addAttribute("nome", dadosFuncionario.getNome()); 
        modelo.addAttribute("cargo", dadosFuncionario.getCargo());
        modelo.addAttribute("login", dadosFuncionario.getLogin()); 
        modelo.addAttribute("senha", dadosFuncionario.getSenha());
        modelo.addAttribute("funcionario", new Funcionario());
        return "consultarUmFuncionario"; 
    }
    
    public ArrayList<Funcionario> consultarFuncionarioBanco(){
        FuncionarioModel con = new FuncionarioModel();
        ArrayList<Funcionario> lista = con.consultarFuncionarios();
        return lista;
    }

    public Funcionario consultarFuncionarioBancoCodigo(int cod_funcionario){
        FuncionarioModel con = new FuncionarioModel();
        Funcionario lista = con.consultarFuncionarioPorCodigo(cod_funcionario);
        return lista;
    }
    
    @ModelAttribute("webConsultarFuncionarios") 
    public Map<Integer, String> webConsultarFuncionarios() { 
        ArrayList<Funcionario>  con = consultarFuncionarioBanco();
        
        Map<Integer, String> consultarFuncionarios = new HashMap<>();
        for(Funcionario funcionario : con){
            String des = funcionario.getCod_funcionario() + " - "+ funcionario.getNome();
            consultarFuncionarios.put(funcionario.getCod_funcionario(), des);
        } return consultarFuncionarios;
    }
    //Fim da Consulta do Funcionario
    
    //Remoção do Funcionario
    @RequestMapping(value = "/removerFuncionario", method = RequestMethod.POST) 
    public String removerFuncionario(@ModelAttribute("funcionario") Funcionario est, Model modelo) { 
        String resultado = removerFuncionarioBanco(est.getCod_funcionario());
        
        if ("removido".equals(resultado)) {
            modelo.addAttribute("resultado", "Funcionario removido com sucesso!");
            modelo.addAttribute("funcionario", new Funcionario());
            modelo.addAttribute("webConsultarFuncionarios", webConsultarFuncionarios());
        } else {
            modelo.addAttribute("resultado", "Erro ao remover funcionario.");
        }
        
        return "removerFuncionario"; 
    }

    public String removerFuncionarioBanco(int cod_funcionario) {
        FuncionarioModel con = new FuncionarioModel();
        String res = con.removerFuncionario(cod_funcionario);
        return res;
    }
    //Fim remoção do Funcionario
    
    //Alterar Funcionario
    @RequestMapping(value = "/alterarFuncionario", method = RequestMethod.POST)
    public String alterarFuncionario(@ModelAttribute("funcionario") @Validated Funcionario est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "alterarFuncionario";
        }
        String resultado = alterarFuncionarioBanco(est);

        if ("alterado".equals(resultado)) {
            modelo.addAttribute("resultado", "Funcionario alterado com sucesso!");
            modelo.addAttribute("funcionario", new Funcionario());
            modelo.addAttribute("webConsultarFuncionarios", webConsultarFuncionarios());
        } else {
            modelo.addAttribute("resultado", "Erro ao alterar funcionario.");
        }

        return "alterarFuncionario";
    }

    public String alterarFuncionarioBanco(Funcionario fun) {
        FuncionarioModel con = new FuncionarioModel();
        String res = con.alterarFuncionario(fun); 
        return res;
    }



   
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String mostrarFormularioLogin(Model modelo) {
        modelo.addAttribute("funcionario", new Funcionario());
        return "login"; 
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processarLogin(@ModelAttribute("funcionario") Funcionario funcionario, Model modelo) {
    
    FuncionarioModel funcionarioModel = new FuncionarioModel();
    Funcionario funcionarioAutenticado = funcionarioModel.validarCredenciais(funcionario.getLogin(), funcionario.getSenha());

    if (funcionarioAutenticado != null) {
        modelo.addAttribute("mensagem", "Login bem-sucedido!");
        modelo.addAttribute("funcionarioLogado", funcionarioAutenticado);
        return "painelnew"; // Redireciona para o painel
    } else {
        modelo.addAttribute("mensagem", "Login ou senha inválidos. Tente novamente.");
        return "login"; 
    }
}


    
    @RequestMapping(value = "/painel", method = RequestMethod.GET)
    public String painel(Model modelo) {
        return "painel"; 
    }
    
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model modelo) {
        return "about"; 
    }
    
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model modelo) {
        return "contact"; 
    }
    
    @RequestMapping(value = "/painelnew", method = RequestMethod.GET)
    public String painelnew(Model modelo) {
        return "painelnew"; 
    }

    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    


}


