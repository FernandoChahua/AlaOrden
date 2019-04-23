package com.myorg.core.entity;

public enum Estado {
    estado1(1), estado2(2);

    private final int codEstado;

    Estado(int codEstado) {
        this.codEstado = codEstado;
    }

    public int getCodEstado() {
        return this.codEstado;
    }
}
