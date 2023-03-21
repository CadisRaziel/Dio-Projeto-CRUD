package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//Controller chama o service
//service chama o repository
//repository é onde temos o acesso ao banco de dados


//service -> onde fica toda lógica

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    //injetando o service
    @Autowired
    private AlunoServiceImpl service;


    //@Valid -> para habilitar as nossas validações nas entidades !!
    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form){
        //@RequestBody -> porque estamos passando no corpo da requisição o form de aluno
        return service.create(form);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaId(id);
    }

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento){
        //required -> false porque eu vo quere ter um retorno e se eu nao passar tambem eu vou ter outro retorno
        //por padrao ele é true
        //quando eu retornar uma lista de alunos eu vo retornar ela com a data de nascimento que eu passar
        //required = false -> tambem quer dizer que eu posso ou nao posso receber essa dataDeNascimento
        return service.getAll(dataDeNascimento);
    }

}
