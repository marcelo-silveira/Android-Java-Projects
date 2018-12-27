package marcelo.junior.exlistviewarrayadapter.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import marcelo.junior.exlistviewarrayadapter.R;
import marcelo.junior.exlistviewarrayadapter.adapters.PessoaAdapter;
import marcelo.junior.exlistviewarrayadapter.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etIdade;
    private Button btOK;
    private ListView lvPessoas;

    private ArrayList<Pessoa> pessoas;
    private PessoaAdapter adapter;//nós criamos p Adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //testes...
                Pessoa p =new Pessoa();
                p.setNome(etNome.getText().toString());
                p.setIdade(Integer.parseInt(etIdade.getText().toString()));

                pessoas.add(p);
                adapter.notifyDataSetChanged();

                tost("Pessoa Cadastrada com Sucesso!!!");
            }
        });

    }//fecha oncreate

    private void init(){
        etNome = findViewById(R.id.ma_et_nome);
        etIdade = findViewById(R.id.ma_et_idade);
        lvPessoas = findViewById(R.id.ma_lv_pessoas);
        btOK = findViewById(R.id.ma_bt_ok);

        pessoas = new ArrayList<>(); //vazio!
        adapter = new PessoaAdapter(MainActivity.this, pessoas);
        lvPessoas.setAdapter(adapter);
    }//fecha init



    private void tost(String msg){
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }//fecha toast


}//fecha classe
