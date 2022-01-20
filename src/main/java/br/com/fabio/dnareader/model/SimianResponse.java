package br.com.fabio.dnareader.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SimianResponse {

    @JsonProperty("is_simian")
    private Boolean value;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}

