package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaImpl implements IAvaliacaoFisicaService {

    //injetando o repository

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    //pegando o aluno atraves do ID (indo la no banco de dados na tabela alunos e trazer esse aluno a parte do ID)
    @Autowired
    private AlunoRepository alunoRepository;
    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        //pegando o aluno atraves do ID (indo la no banco de dados na tabela alunos e trazer esse aluno a parte do ID)
        //pois a avaliaçãoFisica pra ser criada precisa de um Aluno
        //o form de avaliaçãoFisica precisa desse aluno
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get(); //pegando o aluno pelo ID (aqui é necessario fazer um try catch para verificar se o aluno existe ou nao !!)
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());
        //o dataAvaliacao definimos como LocalDateTime.now() ou seja vai ser criado automaticamente, nao precisamos passar
        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return null;
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return null;
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
