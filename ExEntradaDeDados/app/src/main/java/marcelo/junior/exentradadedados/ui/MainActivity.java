package marcelo.junior.exentradadedados.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import marcelo.junior.exentradadedados.R;
import marcelo.junior.exentradadedados.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etIdade;
    private EditText etPeso;
    private TextView tvResposta;
    private Button btOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etNome.getText().toString().isEmpty()){
                    toast("Digite um nome!");
                    etNome.setError("Digite um nome!");
                    return;
                }

                if (etIdade.getText().toString().isEmpty()){
                    toast("Digite uma Idade!");
                    etNome.setError("Digite uma Idade!");
                    return;
                }
                if (etPeso.getText().toString().isEmpty()){
                    toast("Digite um peso!");
                    etNome.setError("Digite um peso!");
                    return;
                }

                Pessoa p = new Pessoa();
                p.setNome(etNome.getText().toString());
                p.setIdade(Integer.parseInt(etIdade.getText().toString()));
                p.setPeso(Double.parseDouble(etPeso.getText().toString()));
                toast("Pessoa cadastrada com sucesso!\n"+p.toString());


                tvResposta.setText("Dados:\n"+p.toString());
            }
        });


    }//fecha oncreate

    private void toast(String msg){
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }

    private void initialize(){
        etNome = findViewById(R.id.ma_et_nome);
        etIdade = findViewById(R.id.ma_et_idade);
        etPeso = findViewById(R.id.ma_et_peso);
        tvResposta = findViewById(R.id.ma_tv_resposta);
        btOk = findViewById(R.id.ma_bt_ok);
    }
}//fecha classe
