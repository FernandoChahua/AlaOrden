package com.myorg.core.entity;

public enum TipoTarjeta {
    Visa(1), MasterCard(2);

    private final int codTipoTarjeta;

    TipoTarjeta(int codTipoTarjeta) {
        this.codTipoTarjeta = codTipoTarjeta;
    }

    public int getCodTipoTarjeta() {
        return this.codTipoTarjeta;
    }

}
