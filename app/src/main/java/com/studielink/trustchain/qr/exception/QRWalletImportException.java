package com.studielink.trustchain.qr.exception;

public abstract class QRWalletImportException extends Exception {
    public QRWalletImportException() {
        super();
    }

    public QRWalletImportException(String message) {
        super(message);
    }

    public QRWalletImportException(Exception cause) {
        super(cause);
    }
}
