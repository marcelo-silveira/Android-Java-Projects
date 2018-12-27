package marcelo.junior.exclickmanha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnLongClickListener{

    private Button btButtonA;
    private Button btButtonB;
    private Button btButtonC;

    private Button btButtonM;
    private Button btButtonN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btButtonA = findViewById(R.id.ma_bt_a);
        btButtonB = findViewById(R.id.ma_bt_b);
        btButtonC = findViewById(R.id.ma_bt_c);

        btButtonM = findViewById(R.id.ma_bt_m);
        btButtonN = findViewById(R.id.ma_bt_n);

        btButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast("clique simples no botao a");
            }
        });

        btButtonA.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                toast("clique longo no botao a");
                return true;
            }
        });

        btButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast("clique simples no botao b");
            }
        });

        btButtonB.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                toast("clique longo no botao b");
                return true;
            }
        });

        btButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast("clique simples no botao c");
            }
        });

        btButtonC.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                toast("clique longo no botao c");
                return true;
            }
        });

        btButtonM.setOnClickListener(this);
        btButtonM.setOnLongClickListener(this);
        btButtonN.setOnClickListener(this);
        btButtonN.setOnLongClickListener(this);

    }//fecha oncreate

    public void toast(String msg){
        Toast.makeText(getBaseContext(), msg,
                Toast.LENGTH_LONG).show();
    }

    public void clicarBotaoX(View view) {
        toast("clicou no botão X!");
    }

    public void clicarBotaoY(View view) {
        toast("clicou no botão Y!");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ma_bt_m:toast("clicou no botao m");
            break;
            case  R.id.ma_bt_n:toast("clicou no botao n");
            break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()){
            case R.id.ma_bt_m: toast("Clique longo no botao m");
                break;
            case R.id.ma_bt_n:toast("clique longo no botao n");
            break;
        }
        return true;
    }
}//fecha classe
