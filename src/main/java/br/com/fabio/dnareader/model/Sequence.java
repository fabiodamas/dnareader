package br.com.fabio.dnareader.model;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "sequence")
public class Sequence {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  DnaType dnaType;

  @Convert(converter = HashMapConverter.class)
  @Column(unique = true)
  private Map<String, Object> dnaValues;

  public DnaType getDnaType() {
    return dnaType;
  }

  public void setDnaType(DnaType dnaType) {
    this.dnaType = dnaType;
  }

  public Sequence() {

  }

  public Sequence(Map<String, Object> dnaValues) {
    this.dnaValues = dnaValues;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Map<String, Object> getDnaValues() {
    return dnaValues;
  }

  public void setDnaValues(Map<String, Object> dnaValues) {
    this.dnaValues = dnaValues;
  }


}
