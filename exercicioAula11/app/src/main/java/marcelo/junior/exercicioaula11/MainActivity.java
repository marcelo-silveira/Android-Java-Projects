package marcelo.junior.exercicioaula11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spEstado;
    private Button btOK;
    private ArrayList<String> estado;
    private ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spEstado.getSelectedItemPosition() == 0){
                    toast("selelecione o estado civil");
                    return;
                }
                String estado = spEstado.getSelectedItem().toString();
                toast("estado civil escolhido"+estado);
            }
        });

        spEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    toast("estado civil "
                            +parent.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }



    public void init(){
        spEstado = findViewById(R.id.ma_spa_estado);
        estado = new ArrayList<>();
        estado.add("Selecione Estado Civil");
        estado.add("Casdado");
        estado.add("Solteiro");
        estado.add("Divorcio");
        estado.add("Separado");
        estado.add("Viuva");

        adapter = new ArrayAdapter(
                MainActivity.this,android.R.layout.simple_list_item_1,estado);

        spEstado.setAdapter(adapter);


        btOK = findViewById(R.id.ma_bt_ok);


    }
    private void toast (String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}
