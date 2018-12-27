package marcelo.junior.eximplementsbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.ma_bt_1);

        bt1.setOnClickListener(this);
    }//fecha oncreate

    private void toast(String msg){
        Toast.makeText(getBaseContext(), msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ma_bt_1: toast("clicou no botao 1");
            break;
        }
    }

    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()){
            case R.id.ma_bt_1: toast("clique longo no botao 1");
                break;
        }
        return true;
    }
}//fecha classe
