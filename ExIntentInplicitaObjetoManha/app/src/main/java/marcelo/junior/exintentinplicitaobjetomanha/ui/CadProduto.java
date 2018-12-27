package marcelo.junior.exintentinplicitaobjetomanha.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import marcelo.junior.exintentinplicitaobjetomanha.R;
import marcelo.junior.exintentinplicitaobjetomanha.model.Produto;

public class CadProduto extends AppCompatActivity {

    private EditText etNome;
    private EditText etValor;
    private Button btCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_produto);

        init();

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Produto p = new Produto();
                //nome
                p.setNome(etNome.getText().toString());
                //valor
                p.setValor(Double.parseDouble(etValor.getText().toString()));

                Intent it = new Intent(CadProduto.this,DetalheProduto.class);
                it.putExtra("p",p);
                startActivity(it);
            }
        });
    }//fecha oncreate

    private void init(){
        etNome = findViewById(R.id.cp_et_nome);
        etValor = findViewById(R.id.cp_et_valor);
        btCadastrar = findViewById(R.id.cp_bt_cadastrar);
    }//fecha init

}//fecha classe
