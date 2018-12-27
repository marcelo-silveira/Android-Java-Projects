package marcelo.junior.exercicio2aula11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvUrf;
    private ArrayList<String> estados;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        lvUrf.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String estado = parent.getItemAtPosition(position).toString();
                toast("selecionou "+estado);
            }
        });
        lvUrf.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String estado =parent.getItemAtPosition(position).toString();
                toast("clicou e segurou o estado "+estado);
                return true;
            }
        });

    }


        public void init(){
            lvUrf=findViewById(R.id.ma_lv_urf);
            estados = new ArrayList<>();
            estados.add("AC");
            estados.add("AL");
            estados.add("AP");
            estados.add("AM");
            estados.add("BA");
            estados.add("CE");
            estados.add("DF");
            estados.add("ES");
            estados.add("GO");
            estados.add("MA");
            estados.add("MT");
            estados.add("MS");
            estados.add("MG");
            estados.add("PA");
            estados.add("PB");
            estados.add("PR");
            estados.add("PE");
            estados.add("PI");
            estados.add("RJ");
            estados.add("RN");
            estados.add("RS");
            estados.add("RO");
            estados.add("RR");
            estados.add("SC");
            estados.add("SP");
            estados.add("SE");
            estados.add("TO");

            adapter = new ArrayAdapter(
                    MainActivity.this,android.R.layout.simple_list_item_1,estados);

            lvUrf.setAdapter(adapter);



        }
        private void toast(String msg){
            Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
        }

}
