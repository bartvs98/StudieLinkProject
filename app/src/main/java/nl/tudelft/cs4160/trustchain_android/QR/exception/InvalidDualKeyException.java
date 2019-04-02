package nl.tudelft.cs4160.trustchain_android.QR.exception;

public class InvalidDualKeyException extends QRWalletImportException {
    public InvalidDualKeyException(String message) {
        super(message);
    }
    public InvalidDualKeyException(Exception cause) {
        super(cause);
    }
}
