package me.dio.academia.digital.repository;


import me.dio.academia.digital.entity.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//JpaRepository -> tambem posso extender de CrudRepository(porque o jpaRepository extends do CrudRepository)
@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {
    //nao precisamos por nenhum metodo aqui, porque a classe extends de JpaRepository
    //se entrarmos em JpaRepository ele tem varios metodos (CRUD) completo ja existente nela !!
    //entao ao injetar essa dependencia dessa classe em outra ele vai pegar os metodos do JpaRepository
}
