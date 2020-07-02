package com.multiDataSourceSpring.entity.enums;

public enum DBSMName {
    POSTGRESQL, ORACLE, MYSQL;

    @Override
    public String toString() {
        switch (this) {
            case POSTGRESQL:
                return "PostgreSQL";
            case ORACLE:
                return "Oracle";
            case MYSQL:
                return "MySQL";
            default:
                throw new IllegalArgumentException();
        }
    }
}
