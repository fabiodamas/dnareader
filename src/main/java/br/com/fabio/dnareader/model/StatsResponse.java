package br.com.fabio.dnareader.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class StatsResponse {

    @JsonProperty("count_simian_dna")
    private Long countSimian;

    @JsonProperty("count_human_dna")
    private Long countHuman;

    @JsonProperty("ratio")
    private BigDecimal ratio;

    public Long getCountSimian() {
        return countSimian;
    }

    public void setCountSimian(Long countSimian) {
        this.countSimian = countSimian;
    }

    public Long getCountHuman() {
        return countHuman;
    }

    public void setCountHuman(Long countHuman) {
        this.countHuman = countHuman;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }
}

