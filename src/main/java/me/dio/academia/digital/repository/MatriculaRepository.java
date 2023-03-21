package me.dio.academia.digital.repository;


import me.dio.academia.digital.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    //nao precisamos por nenhum metodo aqui, porque a classe extends de JpaRepository
    //se entrarmos em JpaRepository ele tem varios metodos (CRUD) completo ja existente nela !!
    //entao ao injetar essa dependencia dessa classe em outra ele vai pegar os metodos do JpaRepository


    //metodo para filtrar pelo bairro, esse o JpaRepository nao tem, entao tem que criar na mao
    //esse filtro é igual o que filtra por data de nascimento no alunoRepository
    //porém ele sera implementado de um jeito diferente, para vermos os 2 jeitos
    List<Matricula> findByAlunoBairro(String bairro);
    //retornando lista de alunos de um determinado bairro(ou seja se o bairro se chamar luz, eu quero retornar todas as matricuas desse bairro)
    //lembre-se que o bairro é um atributo de ALUNO
    //nos vamos entrar no Aluno e pegar o bairro

    //OUTRO MODO DE FAZER ESSE FILTRO PELO BAIRRO USANDO HQL (Uma forma de escrever o sql)
    /*
    @Query("FROM Matricula m WHERE m.aluno.bairro = :bairro ")
    List<Matricula> findByAlunosMatriculadoBairro(String bairro);
     */

    //OUTRO MODO DE FAZER ESSE FILTRO PELO BAIRRO USANDO QUERY NATIVA
    //tanto essa query abaixo como a de cima, os retornos são os mesmos, só a forma de escrever que muda
    /*
    @Query(value = "SELECT * FROM tb_matriculas m" +
    "INNER JOIN tb_alunos a ON m.alunos_id = a.id " +
    "WHERE a.bairro = :bairro", nativeQuery = true)
    List<Matricula> findByAlunosMatriculadoBairro(String bairro);
    //ela pode usar a mesma função da query de cima
    */
}
