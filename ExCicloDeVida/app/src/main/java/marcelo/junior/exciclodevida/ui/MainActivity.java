package marcelo.junior.exciclodevida.ui;

import  android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import marcelo.junior.exciclodevida.R;
import marcelo.junior.exciclodevida.model.Cliente;

public class MainActivity extends AppCompatActivity {

    private static  final String TAG = "logsMainActivity";

    private Button btOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "entrou no oncreate");
        btOK = findViewById(R.id.ma_bt_ok);
        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cliente c = new Cliente();
                c.setNome("Ayrtom Senna");
                c.setRenda(1000);


                Intent it = new Intent(
                        MainActivity.this,Tela1.class);
                it.putExtra("nome","Marcelo Júnior");
                it.putExtra("c",c);
                startActivity(it);


                /*startActivity(new Intent(MainActivity.this, Tela1.class));*/
            }
        });
    }//fecha oncreate

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "entrou no onstart");
    }//fecha onstart

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "entrou no onresume");
    }//fecha onresume

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "entrou no onpause");
    }//fecha onpause

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "entrou no onstop");
    }//fecha onstop

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "entrou no ondestroy");
    }//fecha ondestroy

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "entrou no onrestart");
    }//fecha onstart
}//fecha classe
