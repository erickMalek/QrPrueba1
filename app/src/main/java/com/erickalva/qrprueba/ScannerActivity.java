package com.erickalva.qrprueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannerActivity extends AppCompatActivity {

    private ZXingScannerView scannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        scannerView = new ZXingScannerView(this);
        scannerView.setResultHandler(new ZxingScannerResultHandler());

        setContentView(scannerView);
        scannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    class ZxingScannerResultHandler implements ZXingScannerView.ResultHandler{

        @Override
        public void handleResult(Result result) {
            String resultCode = result.getText();
            Toast.makeText(ScannerActivity.this, resultCode , Toast.LENGTH_SHORT).show();

            setContentView(R.layout.activity_scanner);
            scannerView.stopCamera();
        }
    }
}
