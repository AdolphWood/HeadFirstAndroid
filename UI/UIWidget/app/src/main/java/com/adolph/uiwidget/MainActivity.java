package com.adolph.uiwidget;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;

    private ImageView imageView;

    private ProgressBar progressBarStep;

    private ProgressBar progressBarCycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button displaytextview = (Button) findViewById(R.id.displaytextview);
        Button changePic = (Button) findViewById(R.id.changePic);
        Button processBarHint = (Button) findViewById(R.id.process_bar_hint);
        Button processBarAdd10 = (Button) findViewById(R.id.process_bar_add10);
        Button alertDialog = (Button) findViewById(R.id.alertDialog);
        Button processDialog = (Button) findViewById(R.id.processDialog);

        editText = (EditText) findViewById(R.id.edit_text);
        imageView  = (ImageView) findViewById(R.id.image_view);
        progressBarCycle = (ProgressBar) findViewById(R.id.progress_bar_cycle);
        progressBarStep = (ProgressBar) findViewById(R.id.progress_bar_step);

        displaytextview.setOnClickListener(this);
        changePic.setOnClickListener(this);
        processBarHint.setOnClickListener(this);
        processBarAdd10.setOnClickListener(this);
        alertDialog.setOnClickListener(this);
        processDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.displaytextview:
                String inputText = editText.getText().toString();
                Toast.makeText(MainActivity.this, inputText,Toast.LENGTH_SHORT).show();
                break;
            case R.id.changePic:
                imageView.setImageResource(R.drawable.img_2);
                break;
            case R.id.process_bar_hint:
                if(progressBarCycle.getVisibility() == View.GONE) {
                    progressBarCycle.setVisibility(View.VISIBLE);
                } else {
                    progressBarCycle.setVisibility(View.GONE);
                }
                break;
            case R.id.process_bar_add10:
                int process = progressBarStep.getProgress();
                process = process + 10;
                progressBarStep.setProgress(process);
                break;
            case R.id.alertDialog:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("Something important.");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
                break;
            case R.id.processDialog:
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            default:
                break;
        }
    }
}
