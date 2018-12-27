package marcelo.junior.exintentinplicitaobjetomanha.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import marcelo.junior.exintentinplicitaobjetomanha.R;

public class MainActivity extends AppCompatActivity {

    private Button btCadProduto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btCadProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this,CadProduto.class);

                startActivity(it);
            }
        });

    }//fecha oncreate

    private void init(){
        btCadProduto = findViewById(R.id.ma_bt_cad_produto);
    }

}//fecha classe
