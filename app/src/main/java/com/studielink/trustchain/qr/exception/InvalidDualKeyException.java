package com.studielink.trustchain.qr.exception;

public class InvalidDualKeyException extends QRWalletImportException {
    public InvalidDualKeyException(String message) {
        super(message);
    }
    public InvalidDualKeyException(Exception cause) {
        super(cause);
    }
}
