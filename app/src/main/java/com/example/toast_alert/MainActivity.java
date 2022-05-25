package com.example.toast_alert;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.AliasActivity;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
    Button pesantoast;
    Button keluar;
    Button tampillist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pesantoast=(Button)findViewById(R.id.pesantoast);
        pesantoast.setOnClickListener(this);
        tampillist=(Button)findViewById(R.id.tampillist);
        tampillist.setOnClickListener(this);
        keluar=(Button)findViewById(R.id.keluar);
        keluar.setOnClickListener(this);
    }
    @SuppressLint("ResourceType")
    @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.layout.activity_main, menu);
            return true;
    }
    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        if(arg0 == pesantoast){
            Toast.makeText(getBaseContext(), "Anda Memilih Toast",Toast.LENGTH_LONG).show();
        }
        else if(arg0==keluar){
            AlertDialog.Builder builder= new AlertDialog.Builder(this);
            builder.setMessage("Apakah Anda Ingin Keluar?").setCancelable(false)
                    .setPositiveButton("YA",new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    MainActivity.this.finish();
                                    // TODO Auto-generated method stub

                                }
                            }
                    ).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    arg0.cancel();
                    // TODO Auto-generated method stub

                }
            }).show();
        }
        else if(arg0==tampillist){
            final CharSequence[]item={"pena","buku tulis","buku gambar","penghapus","mistar","spidol","pensil warna"};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("AlatTulis");
            builder.setItems(item, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(getBaseContext(),item[arg1], Toast.LENGTH_SHORT).show();
                    // TODO Auto-generated method stub
                }
            }).show();
        }

        //
    }
}

