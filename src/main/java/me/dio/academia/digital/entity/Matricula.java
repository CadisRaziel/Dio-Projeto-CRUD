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
@Table(name = "tb_matriculas")
public class Matricula {

  @Id //-> Chave primaria
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL) // -> UMA Matricula tera apenas UM aluno
  @JoinColumn(name = "aluno_id") //-> A coluna das foregin key vai estar dentro da tabela de Matricula
  //estamos relacionando a matricula ao id de cada aluno
  //cascade ->  CascadeType.ALL -> aqui se eu excluir a matricula eu excluo o aluno
  //mappedBy -> na classe aluno eu nao tenho a coluna matricula, entao nao precisamos por o 'mappedBy'
  private Aluno aluno;

  private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
