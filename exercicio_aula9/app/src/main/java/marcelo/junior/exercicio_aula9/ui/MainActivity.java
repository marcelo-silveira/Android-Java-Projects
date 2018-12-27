package marcelo.junior.exercicio_aula9.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import marcelo.junior.exercicio_aula9.R;

public class MainActivity extends AppCompatActivity {

    private Button btTela1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btTela1 = findViewById(R.id.ma_bt_tela1);
        btTela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(
                        MainActivity.this,Tela10.class);
                startActivity(it);
            }
        });
    }
}
