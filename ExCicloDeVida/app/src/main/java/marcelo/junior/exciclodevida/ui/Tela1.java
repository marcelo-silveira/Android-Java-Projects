package marcelo.junior.exciclodevida.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import marcelo.junior.exciclodevida.R;
import marcelo.junior.exciclodevida.model.Cliente;

public class Tela1 extends AppCompatActivity {

    private static final String TAG = "logsTela1";

    private EditText etURL;
    private Button btURL;

    private EditText etDiscar;
    private Button btDiscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        Log.d(TAG, "entrou no oncreate");

        etURL = findViewById(R.id.t1_et_url);
        btURL = findViewById(R.id.t1_bt_url);
        etDiscar = findViewById(R.id.t1_et_discar);
        btDiscar = findViewById(R.id.t1_bt_discar);


        btDiscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel"+etURL.getText().toString());
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }
        });

        btURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://"+etURL.getText().toString());
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }
        });

        if(getIntent().getStringExtra("nome")!=null){
            String nome = getIntent().getStringExtra("nome");
            /*Toast.makeText(
                    getBaseContext(),
                    "Olá "+nome,
                    Toast.LENGTH_LONG).show();*/
        }

        if(getIntent().getParcelableExtra("c")!=null){
            Cliente c = (Cliente) getIntent().getParcelableExtra("c");
            Toast.makeText(
                    getBaseContext(),
                    "Olá "+c.toString(),
                    Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "entrou no onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "entrou no onresume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "entrou no onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "entrou no onstop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "entrou no ondestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "entrou no onrestart");
    }
}
