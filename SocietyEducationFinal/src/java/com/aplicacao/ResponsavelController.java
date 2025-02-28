/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacao;

import com.aplicacao.dao.Responsavel;
import com.aplicacao.model.ResponsavelModel;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

/**
 *
 * @author leand
 */
@Controller
public class ResponsavelController {
    
    @RequestMapping(value = "/inserirResponsavel", method = RequestMethod.GET) 
    public ModelAndView inserirResponsavel() {
        return new ModelAndView("inserirResponsavel", "command", new Responsavel()); 
    } 
    
    @RequestMapping(value = "/consultarUmResponsavel", method = RequestMethod.GET)
    public ModelAndView coinsultarUmResponsavel() {
        return new ModelAndView("consultarUmResponsavel");
    }
    
    @RequestMapping(value = "/alterarResponsavel", method = RequestMethod.GET)
    public ModelAndView alterarResponsavel() {
        return new ModelAndView("alterarResponsavel");
    }

    @RequestMapping(value = "/removerResponsavel", method = RequestMethod.GET)
    public ModelAndView removerResponsavel() {
        return new ModelAndView("removerResponsavel");
    }
    
    @ModelAttribute("responsavel")
    public Responsavel criarResponsavelModelo() {
        return new Responsavel();
    }
    
    
    //Inserir
    @RequestMapping(value = "/inserirResponsavel", method = RequestMethod.POST) 
    public String inserirResponsavel(@ModelAttribute("responsavel")@Validated Responsavel est, BindingResult bindingResult, Model modelo) { 
        if (bindingResult.hasErrors()) { 
            return "inserirResponsavel";
        } 
        String resultado = "";
        
        modelo.addAttribute("nome_resp", est.getNome_resp()); 
        modelo.addAttribute("telefone", est.getTelefone());
        modelo.addAttribute("email", est.getEmail());
        modelo.addAttribute("endereco", est.getEndereco()); 
        resultado = inserirResponsavelBanco(est);
        
        if ("inserido".equals(resultado)) {
        modelo.addAttribute("resultado", "Responsável Inserido com sucesso!");
        modelo.addAttribute("responsavel", new Responsavel());
    } else {
        modelo.addAttribute("resultado", "Erro ao inserir responsável.");
    }
        
        return "inserirResponsavel";
    }

    public String inserirResponsavelBanco(Responsavel resp){
        ResponsavelModel con = new ResponsavelModel();
        String res = con.inserirResponsavel(resp);
        return res;
    }
    //Fim inserção
    
    
    //Consulta do Responsavel
    @RequestMapping(value = "/consultarUmResponsavel", method = RequestMethod.POST) 
    public String consultarUmResponsavel(@ModelAttribute("responsavel")Responsavel est, Model modelo) { 
       
        Responsavel dadosResponsavel = consultarResponsavelBancoCodigo(est.getCod_resp());
        
        modelo.addAttribute("cod_resp", dadosResponsavel.getCod_resp());
        modelo.addAttribute("nome_resp", dadosResponsavel.getNome_resp()); 
        modelo.addAttribute("telefone", dadosResponsavel.getTelefone());
        modelo.addAttribute("email", dadosResponsavel.getEmail());
        modelo.addAttribute("endereco", dadosResponsavel.getEndereco());
        modelo.addAttribute("responsavel", new Responsavel());
        return "consultarUmResponsavel"; 
    }
    
    public ArrayList<Responsavel> consultarResponsavelBanco(){
        ResponsavelModel con = new ResponsavelModel();
        ArrayList<Responsavel> lista = con.consultarResponsaveis();
        return lista;
    }

    public Responsavel consultarResponsavelBancoCodigo(int cod_resp){
        ResponsavelModel con = new ResponsavelModel();
        Responsavel lista = con.consultarResponsavelPorCodigo(cod_resp);
        return lista;
    }
    
    @ModelAttribute("webConsultarResponsaveis") 
    public Map<Integer, String> webConsultarResponsaveis() { 
        ArrayList<Responsavel>  con = consultarResponsavelBanco();
        
        Map<Integer, String> consultarResponsaveis = new HashMap<>();
        for(Responsavel responsavel : con){
            String des = responsavel.getCod_resp() + " - "+ responsavel.getNome_resp();
            consultarResponsaveis.put(responsavel.getCod_resp(), des);
        }return consultarResponsaveis;
    }
    //Fim da Consulta do Responsavel
    
    @ModelAttribute("sexoEscolha")
    public Map<String, String > sexoEscolha() {
        Map<String, String> sel = new HashMap<>();
        sel.put("M", "Masculino");
        sel.put("F", "Feminino");
        return sel;
    }
    
    //Remoção do Responsavel
    @RequestMapping(value = "/removerResponsavel", method = RequestMethod.POST) 
    public String removerResponsavel(@ModelAttribute("responsavel") Responsavel est, Model modelo) { 
        String resultado = removerResponsavelBanco(est.getCod_resp());
        
        if ("removido".equals(resultado)) {
            modelo.addAttribute("resultado", "Responsavel removido com sucesso!");
            modelo.addAttribute("responsavel", new Responsavel());
            modelo.addAttribute("webConsultarResponsaveis", webConsultarResponsaveis());
        } else {
            modelo.addAttribute("resultado", "Erro ao remover Responsavel.");
        }
        
        return "removerResponsavel"; 
    }

    public String removerResponsavelBanco(int cod_resp) {
        ResponsavelModel con = new ResponsavelModel();
        String res = con.removerResponsavel(cod_resp);
        return res;
    }
    //Fim remoção do Curso
    
    //Alterar Curso
    @RequestMapping(value = "/alterarResponsavel", method = RequestMethod.POST)
    public String alterarResponsavel(@ModelAttribute("responsavel") @Validated Responsavel est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "alterarResponsavel";
        }
        String resultado = alterarResponsavelBanco(est);

        if ("alterado".equals(resultado)) {
            modelo.addAttribute("resultado", "Responsavel alterado com sucesso!");
            modelo.addAttribute("responsavel", new Responsavel());
            modelo.addAttribute("webConsultarResponsaveis", webConsultarResponsaveis());
        } else {
            modelo.addAttribute("resultado", "Erro ao alterar Responsavel.");
        }

        return "alterarResponsavel";
    }

    public String alterarResponsavelBanco(Responsavel resp) {
        ResponsavelModel con = new ResponsavelModel();
        String res = con.alterarResponsavel(resp); 
        return res;
    }
}
