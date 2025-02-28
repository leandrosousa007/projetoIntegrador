/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacao;

import com.aplicacao.dao.Curso;
import com.aplicacao.model.CursoModel;
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
public class CursoController {

    @RequestMapping(value = "/inserirCurso", method = RequestMethod.GET) 
    public ModelAndView inserirCurso() {
        return new ModelAndView("inserirCurso", "command", new Curso()); 
    } 
    
    @RequestMapping(value = "/alterarCurso", method = RequestMethod.GET) 
    public ModelAndView alterarCurso() {
        return new ModelAndView("alterarCurso", "command", new Curso()); 
    } 
    
    @RequestMapping(value = "/removerCurso", method = RequestMethod.GET) 
    public ModelAndView removerCurso() {
        return new ModelAndView("removerCurso", "command", new Curso()); 
    } 
    
    @RequestMapping(value = "/consultarUmCurso", method = RequestMethod.GET) 
    public ModelAndView consultarUmCurso() {
        return new ModelAndView("consultarUmCurso", "command", new Curso()); 
    } 
    
    @RequestMapping(value = "/consultarCursos", method = RequestMethod.GET) 
    public ModelAndView consultarCursos() {
        return new ModelAndView("consultarCursos", "command", new Curso()); 
    } 
    
    @ModelAttribute("curso")
    public Curso criarCursoModelo() {
        return new Curso();
    }
    
    //Inserir
    @RequestMapping(value = "/inserirCurso", method = RequestMethod.POST) 
    public String inserirCurso(@ModelAttribute("curso")@Validated Curso est, BindingResult bindingResult, Model modelo) { 
        if (bindingResult.hasErrors()) { 
            return "inserirCurso";
        } 
        String resultado = "";
        
        modelo.addAttribute("nome_curso", est.getNome_curso()); 
        modelo.addAttribute("sigla", est.getSigla()); 
        resultado = inserirCursoBanco(est);
        
        if ("Curso Inserido com Sucesso!".equals(resultado)) {
        modelo.addAttribute("resultado", "Curso Inserido com sucesso!");
        modelo.addAttribute("curso", new Curso());
    } else {
        modelo.addAttribute("resultado", "Erro ao inserir curso.");
    }
        
        return "inserirCurso";
    }

    public String inserirCursoBanco(Curso cur){
        CursoModel con = new CursoModel();
        String res = con.inserirCurso(cur);
        return res;
    }
    //Fim inserção
    
    //Consulta do Curso
    @RequestMapping(value = "/consultarUmCurso", method = RequestMethod.POST) 
    public String consultarUmCurso(@ModelAttribute("curso")Curso est, Model modelo) { 
       
        Curso dadosCurso = consultarCursoBancoCodigo(est.getCod_curso());
        
        modelo.addAttribute("cod_curso", dadosCurso.getCod_curso());
        modelo.addAttribute("nome_curso", dadosCurso.getNome_curso()); 
        modelo.addAttribute("sigla", dadosCurso.getSigla());
        modelo.addAttribute("curso", new Curso());
        return "consultarUmCurso"; 
    }
    
    public ArrayList<Curso> consultarCursoBanco(){
        CursoModel con = new CursoModel();
        ArrayList<Curso> lista = con.consultarCursos();
        return lista;
    }

    public Curso consultarCursoBancoCodigo(int cod_curso){
        CursoModel con = new CursoModel();
        Curso lista = con.consultarCursoPorCodigo(cod_curso);
        return lista;
    }
    
    @ModelAttribute("webConsultarCursos") 
    public Map<Integer, String> webConsultarCursos() { 
        ArrayList<Curso>  con = consultarCursoBanco();
        
        Map<Integer, String> consultarCursos = new HashMap<>();
        for(Curso curso : con){
            String des = curso.getCod_curso() + " - "+ curso.getNome_curso();
            consultarCursos.put(curso.getCod_curso(), des);
}   return consultarCursos;
    }
    //Fim da Consulta do Curso
    
    //Remoção do Curso
    @RequestMapping(value = "/removerCurso", method = RequestMethod.POST) 
    public String removerCurso(@ModelAttribute("curso") Curso est, Model modelo) { 
        String resultado = removerCursoBanco(est.getCod_curso());
        
        if ("removido".equals(resultado)) {
            modelo.addAttribute("resultado", "Curso removido com sucesso!");
            modelo.addAttribute("curso", new Curso());
            modelo.addAttribute("webConsultarCursos", webConsultarCursos());
        } else {
            modelo.addAttribute("resultado", "Erro ao remover curso.");
        }
        
        return "removerCurso"; 
    }

    public String removerCursoBanco(int cod_curso) {
        CursoModel con = new CursoModel();
        String res = con.removerCurso(cod_curso);
        return res;
    }
    //Fim remoção do Curso
    
    //Alterar Curso
    @RequestMapping(value = "/alterarCurso", method = RequestMethod.POST)
    public String alterarCurso(@ModelAttribute("curso") @Validated Curso est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "alterarCurso";
        }
        String resultado = alterarCursoBanco(est);

        if ("alterado".equals(resultado)) {
            modelo.addAttribute("resultado", "Curso alterado com sucesso!");
            modelo.addAttribute("curso", new Curso());
            modelo.addAttribute("webConsultarCursos", webConsultarCursos());
        } else {
            modelo.addAttribute("resultado", "Erro ao alterar curso.");
        }

        return "alterarCurso";
    }

    public String alterarCursoBanco(Curso cur) {
        CursoModel con = new CursoModel();
        String res = con.alterarCurso(cur); 
        return res;
    }

   
    
 

}
