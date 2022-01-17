package br.com.fabio.dnareader.model;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sequence")
public class Sequence {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Convert(converter = HashMapConverter.class)
  @Column(unique = true)
  private Map<String, Object> dnaValues;  

  @Enumerated(EnumType.STRING)
  private DnaType dnaType;

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
