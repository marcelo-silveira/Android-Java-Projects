package marcelo.junior.projeto_manha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button btDado20;
    private Button btDado12;
    private Button btDado6;
    private TextView tvResposta;
    private Button btRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        btRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dado d = new Dado();

                tvResposta.setText("Resultados:\n"+d.toString());
            }
        });

    }//fecha oncreate

    private void initialize(){
        btDado20 = findViewById(R.id.ma_bt_dado20);
        btDado12 = findViewById(R.id.ma_bt_dado12);
        btDado6 = findViewById(R.id.ma_bt_dado6);
        tvResposta = findViewById(R.id.ma_tv_resposta);
        btRoll = findViewById(R.id.ma_bt_roll);
    }


}//fecha classe
