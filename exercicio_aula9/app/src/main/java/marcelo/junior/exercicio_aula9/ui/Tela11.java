package marcelo.junior.exercicio_aula9.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import marcelo.junior.exercicio_aula9.R;

public class    Tela11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela11);


        if (getIntent().getStringExtra("nome")!=null){
            String nome = getIntent().getStringExtra("nome");
            Toast.makeText(getBaseContext(),"Olá "+nome,Toast.LENGTH_LONG).show();
        }
    }


}
