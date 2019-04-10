package nl.tudelft.cs4160.trustchain_android.QR;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.view.Display;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import nl.tudelft.cs4160.trustchain_android.R;

public class QRGenerator {

    private String content;

    public String getContent() { return content; }

    public void setContent(String content) {this.content = content; }

    public void generateQRforIP(ImageView qrImage, int width) {
        QRCodeWriter writer = new QRCodeWriter();

        try {
            BitMatrix bitMatrix = writer.encode(getContent(), BarcodeFormat.QR_CODE, width, width);
            Bitmap bmp = Bitmap.createBitmap(width, width, Bitmap.Config.RGB_565);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < width; y++) {
                    bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }

            qrImage.setImageBitmap(bmp);

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

}