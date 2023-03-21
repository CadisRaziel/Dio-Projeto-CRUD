package me.dio.academia.digital.repository;


import me.dio.academia.digital.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    //nao precisamos por nenhum metodo aqui, porque a classe extends de JpaRepository
    //se entrarmos em JpaRepository ele tem varios metodos (CRUD) completo ja existente nela !!
    //entao ao injetar essa dependencia dessa classe em outra ele vai pegar os metodos do JpaRepository

    //metodo para filtrar pela data de nascimento, esse o JpaRepository nao tem, entao tem que criar na mao
    //ou seja eu quero  buscar a lista de alunos filtrando pela data de nascimento
    //entao se eu colocar 16/11/1992 eu quero só os alunos com essa data !
    //caso tambem eu quero enviar um email para o dia que ele faz data de aniversario podemos usar esse metodo
    //eu poderia fazer com nome, com telefone, com qualquer outra variavel da classe ALuno esse filtro
    public List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimetno);
}
