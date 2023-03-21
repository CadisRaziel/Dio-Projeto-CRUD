package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data //(lombok) -> com isso não preciso usar get e setter e hashCode ali em baixo, o lombok ja faz automatico
@NoArgsConstructor //(lombok)-> Cria um construtor vazio, nao sendo necessario escreve-lo ali em baixo
@AllArgsConstructor //(lombok) -> Cria um construtor que tem todos os atributos da classe, nao sendo necessario escreve-lo ali em baixo
@Entity //-> falando pro databse que essa classe aluno sera uma tabela e seus atributos serao as colunas (ao colocar ela, ela pede uma chave primaria)
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@JsonIgnorePropertie -> como estou usando isso fetch = FetchType.LAZY, preciso colocar essa anotação
//informando que o hibernate vai ter a inicialização lenta em quem usa esse parametro
public class Aluno {

  //Construtor
  //por padrao o java ja coloca um construtor vazio
  //porém com o @NoArgsConstructor cria um vazio que é essencial pro 'hibernate'
  //@AllArgsConstructor -> cria um contrutor com todos os atributos da classe

  @Id //-> Chave primaria
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  @Column(unique = true) // -> não pode haver cpfs iguais no banco de dados
  private String cpf;
  private String bairro;
  private LocalDate dataDeNascimento; //dataDeNascimento no banco de dados sera salvo como data_de_nascimento

  //RELAÇÂO ENTRE TABELAS
  //Alunos vai se relacionar com AvaliacaoFisica
  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY) //-> UM aluno pode ter VARIAS avaliaçõesFisicas (ou seja one(um) to many(muitos))
  @JsonIgnore //-> as vezes pode aparecer alguns exceptions relacionado a serialização(json), pode acontecer loop infinto(quanto a gente pede as avaliações fique aparecendo varias infinitamente)
  //na classe AvaliacaoFisica temos o Aluno como atributo la, então essa relação sera Bidimensional
  //com isso tenho que dizer que a tabela ALUNO precisa ser mapeada (com isso pegamos o atributo aluno da classe AvaliacaoFisica)
  //fetch = FetchType.LAZY -> forma de carregamento da lista de AvaliaçãoFisica na minha tabela Aluno sera LAZY(Preguiçosa)
  //fetch = FetchType.LAZY -> ou seja quando eu pedir pra ver as informaçoes do aluno Vitor, quando eu pedir
  //essas informaçoes do Vitor, vai carregar todas as informaçoes MENOS a lista de AvaliaçãoFisica
  //quando quisermos ver as AvaliacoesFisicas vamos crair um endpoint para retornar todas AvaliaçoesFisicas referente ao Vitor
  //isso é uma boa pratica para PERFORMANCE (pois avaliaçãoFisica pode ter MUITAS sobre o Vitor)
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();


  //GETTERS AND SETTERS
  //O @Data ja faz isso automatico com o 'Lombok' então nao preciso escrever aqui
  //O lombok é adicionao no projeto na criação dele
}
//Anotação de relação entre tabelas
//@ManyToMany
//@ManyToOne
//@OneToMany
//@OneToOne