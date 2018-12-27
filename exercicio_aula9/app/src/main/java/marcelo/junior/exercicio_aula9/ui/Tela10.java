package marcelo.junior.exercicio_aula9.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import marcelo.junior.exercicio_aula9.R;


public class Tela10 extends AppCompatActivity {

    private EditText edNome;
    private Button btOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela10);

        edNome = findViewById(R.id.t10_ed_nome);
        btOK = findViewById(R.id.t10_bt_ok);

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(
                        Tela10.this,Tela11.class);
                it.putExtra("nome",edNome.getText().toString());
                startActivity(it);

            }
        });



    }//fecha oncreate
}//fecha classe
