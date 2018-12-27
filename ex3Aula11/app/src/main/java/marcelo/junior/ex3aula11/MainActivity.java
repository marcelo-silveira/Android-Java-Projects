package marcelo.junior.ex3aula11;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etNome;
    private Button btOK;
    private ListView lvContatos;

    private ArrayList<String> contatos;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etNome.getText().toString().isEmpty()){
                    toast("Nome em branco!");
                    return;
                }

                contatos.add(etNome.getText().toString());
                limpar();

                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);

                toast("Contato cadastrado com sucesso!");
                adapter.notifyDataSetChanged();
            }
        });

        lvContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    toast("Escolha um contato!");
                    return;
                }
                String contato = parent.getItemAtPosition(position).toString();
                toast("clicou em: "+contato);
            }
        });
        lvContatos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                contatos.remove(position);
                adapter.notifyDataSetChanged();
                toast("contato excluído com sucesso!");
                return true;
            }
        });

    }//fecha oncreate

    private void init(){
        etNome = findViewById(R.id.ma_et_nome);
        btOK = findViewById(R.id.ma_bt_ok);
        lvContatos = findViewById(R.id.ma_lv_contatos);

        contatos = new ArrayList<>();
        adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                contatos);
        lvContatos.setAdapter(adapter);
    }

    private void limpar(){
        etNome.setText("");
    }

    private void toast(String msg){
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }
}//fecha classe