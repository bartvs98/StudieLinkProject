package com.studielink.trustchain.qr.exception;

public class QRWalletParseException extends QRWalletImportException {
    public QRWalletParseException(String message) {
        super(message);
    }

    public QRWalletParseException(Exception cause) {
        super(cause);
    }
}
