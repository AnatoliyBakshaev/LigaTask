
package com.library.ligatask.exception;

public class Exep extends RuntimeException {
    public Exep(Long id) {
        super("клиент с id " + id + " не найден");
    }
}
