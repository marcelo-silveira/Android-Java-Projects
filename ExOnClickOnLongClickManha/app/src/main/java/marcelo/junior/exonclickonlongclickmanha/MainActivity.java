package marcelo.junior.exonclickonlongclickmanha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btButton1;

    private Button btButton3;
    private Button btButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btButton1 = findViewById(R.id.ma_bt_button1);
        btButton1 = findViewById(R.id.ma_bt_button3);
        btButton1 = findViewById(R.id.ma_bt_button4);

        btButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("clique simples");
            }
        });

        btButton1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                toast("clique longo");
                return true;
            }
        });


        View.OnClickListener clique = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast("X");

            }
        };

        btButton3.setOnClickListener(clique);
        btButton4.setOnClickListener(clique);


    }//fecha oncreate

    public void toast(String msg){
        Toast.makeText(getBaseContext(), msg,
                Toast.LENGTH_LONG).show();
    }

    public void clicarBotao1(View view) {
    }

    public void clicarBotao2(View view) {
        toast("clicou no boatão 2");
    }
}//fecha classe
