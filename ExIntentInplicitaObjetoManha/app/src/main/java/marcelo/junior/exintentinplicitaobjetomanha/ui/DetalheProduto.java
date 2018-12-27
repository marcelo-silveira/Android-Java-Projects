package marcelo.junior.exintentinplicitaobjetomanha.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import marcelo.junior.exintentinplicitaobjetomanha.R;
import marcelo.junior.exintentinplicitaobjetomanha.model.Produto;

public class DetalheProduto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_produto);


        Produto p;
        if (getIntent().hasExtra("p")){
            p = (Produto) getIntent().getSerializableExtra("p");
            Toast.makeText(getBaseContext(),"produto:"+p.toString(),Toast.LENGTH_LONG).show();
        }

    }
}
