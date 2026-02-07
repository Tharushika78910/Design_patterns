
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncryptedPrinter extends PrinterDecorator {

    // Simple XOR key (reversible). You can change it.
    private static final byte KEY = 0x5A;

    public EncryptedPrinter(Printer wrapped) {
        super(wrapped);
    }

    @Override
    public void print(String message) {
        String encrypted = encrypt(message);
        wrapped.print(encrypted);
    }

    // Encrypt: XOR bytes, then Base64 for printable output
    public static String encrypt(String plainText) {
        byte[] data = plainText.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) (data[i] ^ KEY);
        }
        return Base64.getEncoder().encodeToString(data);
    }

    // Decrypt: Base64 decode, then XOR again
    public static String decrypt(String encryptedBase64) {
        byte[] data = Base64.getDecoder().decode(encryptedBase64);
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) (data[i] ^ KEY);
        }
        return new String(data, StandardCharsets.UTF_8);
    }
}
