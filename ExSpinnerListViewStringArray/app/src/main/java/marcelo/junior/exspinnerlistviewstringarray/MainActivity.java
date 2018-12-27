package marcelo.junior.exspinnerlistviewstringarray;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spContatos;
    private Button btOK;
    private ListView lvContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

         btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spContatos.getSelectedItemPosition() == 0){
                    toast("Selecione um contato!");
                    return;
                }
                String contato = spContatos.getSelectedItem().toString();
                toast("Contato escolhido: "+contato);
            }
        });

        spContatos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    toast("Contato selecionado: "
                            +parent.getSelectedItem().toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        lvContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    toast("Selecione um contato");
                    return;
                }
                String contato = parent.getItemAtPosition(position).toString();
                toast("Clicou no contato: "+contato);
            }
        });
        lvContatos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    toast("Selecione um contato");
                    return true;
                }
                String contato = parent.getItemAtPosition(position).toString();
                toast("Clicou e segurou no contato: "+contato);
                return true;
            }
        });

    }//fecha oncreate

    private void init(){
        spContatos = findViewById(R.id.ma_sp_contatos);
        btOK = findViewById(R.id.ma_bt_ok);
        lvContatos = findViewById(R.id.ma_lv_contatos);
    }

    private void toast(String msg){
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }
}//fecha classe

