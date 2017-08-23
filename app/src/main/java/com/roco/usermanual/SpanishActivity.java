package com.roco.usermanual;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

public class SpanishActivity extends AppCompatActivity {
    private static final String pdfPath = "/system/extra/pdf/";
    private static final String pdfName = "User_Manual_Spanish.pdf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openPdf();
    }

    private void openPdf() {
        File pdfFile = new File(pdfPath + pdfName);

        if(!pdfFile.exists()) {
            Log.e("chenxs", "file not exist: " + pdfPath + pdfName);
            Toast.makeText(getApplicationContext(), "Pdf archivo no existe!",
                    Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            Uri uri = Uri.fromFile(pdfFile);
            intent.setDataAndType(uri, "application/pdf");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Log.e("chenxs", e.toString());
        }
    }
}
