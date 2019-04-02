package nl.tudelft.cs4160.trustchain_android.QR.exception;

public class QRWalletParseException extends QRWalletImportException {
    public QRWalletParseException(String message) {
        super(message);
    }

    public QRWalletParseException(Exception cause) {
        super(cause);
    }
}
