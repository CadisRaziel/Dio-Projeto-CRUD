package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data //(lombok) -> com isso não preciso usar get e setter ali em baixo, o lombok ja faz automatico
@NoArgsConstructor //(lombok)-> Cria um construtor vazio, nao sendo necessario escreve-lo ali em baixo
@AllArgsConstructor //(lombok) -> Cria um construtor que tem todos os atributos da classe, nao sendo necessario escreve-lo ali em baixo
@Entity //-> falando pro databse que essa classe aluno sera uma tabela e seus atributos serao as colunas (ao colocar ela, ela pede uma chave primaria)
@Table(name = "tb_avaliacoes")
public class AvaliacaoFisica {

  @Id //-> Chave primaria
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL) // -> VARIAS avaliacoesFisica tera apenas UM aluno
  //cascade -> a alteração que eu fizer em avaliaçãoFisica ela vai refletir em aluno (All -> tudo que eu fizer em qualquer parte de avaliacaoFisica)
  @JoinColumn(name = "aluno_id") //-> A coluna das foregin key vai estar dentro da tabela de avalicaoFisica
  //estamos relacionando a avaliacaoFiscia ao id de cada aluno
  private Aluno aluno;

  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  @Column(name = "peso_atual") //-> nome da coluna na tabela do db
  private double peso;


  @Column(name = "altura_atual") //-> nome da coluna na tabela do db
  private double altura;

}
