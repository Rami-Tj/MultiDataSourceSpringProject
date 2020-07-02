package com.multiDataSourceSpring.entity.enums;

public enum DataTypeName {
    STRING, DATE, NUMERIC, AMOUNT;

    @Override
    public String toString() {
        switch (this) {
            case STRING:
                return "Chaine de caractères";
            case DATE:
                return "Date";
            case NUMERIC:
                return "Numérique";
            case AMOUNT:
                return "Montant";
            default:
                throw new IllegalArgumentException();
        }
    }
}
