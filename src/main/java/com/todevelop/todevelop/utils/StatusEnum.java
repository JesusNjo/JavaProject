package com.todevelop.todevelop.utils;

import java.util.HashMap;
import java.util.Map;

public enum StatusEnum {
    ACTIVE,
    INACTIVE,
    LOCKED,
    EXPIRED,
    CLOSED,
    OPEN,
    UNKNOWN,
    DEPRECATED,
    PENDING,
    PROCESSING,
    DONATED,
    CANCELED,
    REJECTED,
    APPROVED,
    COMPLETED,
    CONCILIATION,
    ERROR,
    HOLDING,
    PROCESSED,
    ABORTED,
    BLOCKED;

    private static final Map<StatusEnum, String> translations = new HashMap();

    private StatusEnum() {
    }

    public String getTranslation() {
        return (String)translations.get(this);
    }

    static {
        translations.put(ACTIVE, "Activo");
        translations.put(INACTIVE, "Inactivo");
        translations.put(LOCKED, "Bloqueado");
        translations.put(BLOCKED, "Bloqueado");
        translations.put(EXPIRED, "Expirado");
        translations.put(CLOSED, "Cerrado");
        translations.put(OPEN, "Abierto");
        translations.put(UNKNOWN, "Desconocido");
        translations.put(DEPRECATED, "Obsoleto");
        translations.put(PENDING, "Pendiente");
        translations.put(PROCESSING, "Procesando");
        translations.put(DONATED, "Donado");
        translations.put(CANCELED, "Cancelado");
        translations.put(REJECTED, "Rechazado");
        translations.put(APPROVED, "Aprobado");
        translations.put(COMPLETED, "Completado");
        translations.put(CONCILIATION, "Conciliación");
        translations.put(ERROR, "Error");
        translations.put(HOLDING, "Retenido");
        translations.put(PROCESSED, "Procesado");
        translations.put(ABORTED, "Abortado");
    }
}
