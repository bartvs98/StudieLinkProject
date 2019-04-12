package nl.tudelft.cs4160.trustchain_android.Main;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.Result;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import nl.tudelft.cs4160.trustchain_android.R;
import nl.tudelft.cs4160.trustchain_android.SharedPreferences.BootstrapIPStorage;

public class FindInstitutionActivity extends AppCompatActivity {

    public static final int PERMISSIONS_REQUEST_CAMERA = 0;
    public static final String TAG = "ScanQRActivity";

    private Vibrator vibrator;
    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscan);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        scannerView = findViewById(R.id.scanner_view);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Camera request permission handling
        if (hasCameraPermission()) {
            startCamera();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {

                DialogInterface.OnDismissListener dismissListener = new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        requestCameraPermission();
                    }
                };


                new AlertDialog.Builder(this).setTitle(R.string.camera_permissions_required)
                        .setMessage(R.string.camera_permisions_required_long)
                        .setNeutralButton(android.R.string.ok, null)
                        .setOnDismissListener(dismissListener)
                        .show();
            } else {
                requestCameraPermission();
            }
        }
    }

    private void requestCameraPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},
                PERMISSIONS_REQUEST_CAMERA);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_CAMERA) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startCamera();
            } else {
                finish();
            }
        }
    }

    private ZXingScannerView.ResultHandler scanResultHandler = new ZXingScannerView.ResultHandler() {
        public void handleResult(Result result) {
            vibrator.vibrate(100);

            try{
                Object res = InetAddress.getByName(result.toString());
                if(!(res instanceof Inet4Address) && !(res instanceof Inet6Address)){
                    Log.i("Bootstrap IP Adress: ", res.toString());
                    throw new Exception("Bootstrap IP is not a valid IP4 or IP6 address.");
                }
//                Intent returnIntent = new Intent();
                BootstrapIPStorage.setIP(FindInstitutionActivity.this, result.toString());

                new AlertDialog.Builder(FindInstitutionActivity.this)
                        .setTitle("Success")
                        .setMessage(result.toString())
                        .setNeutralButton(android.R.string.ok, null)
                        .setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialogInterface) {
                                FindInstitutionActivity.this.finish();
                            }
                        }).show();

//                returnIntent.putExtra("ConnectableAddress", result.toString());
//                setResult(OverviewConnectionsActivity.RESULT_OK,returnIntent);
//                finish();
            } catch (Exception e){
                Toast.makeText(FindInstitutionActivity.this, "The bootstrap IP address is not a valid IP address: " + result.toString(), Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(FindInstitutionActivity.this)
                        .setTitle("Error")
                        .setMessage("Something went wrong processing the QR data")
                        .setNeutralButton(android.R.string.ok, null)
                        .setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialogInterface) {
                                scannerView.resumeCameraPreview(scanResultHandler);
                            }
                        }).show();
            }
        }
    };

    private void startCamera() {
        scannerView.setResultHandler(scanResultHandler);
        scannerView.startCamera();
    }


    private boolean hasCameraPermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        return permissionCheck == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

}
