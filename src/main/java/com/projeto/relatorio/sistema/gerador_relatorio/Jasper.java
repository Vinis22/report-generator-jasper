package com.projeto.relatorio.sistema.gerador_relatorio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Jasper {

    @Id
    private Long id;

    public Jasper() {}

    public Jasper clone() {
        try {
            return (Jasper) super.clone();
        } catch (CloneNotSupportedException e) {
            return this;
        }
    }
}