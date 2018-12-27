package marcelo.junior.exradiobuttoncheckboxmanha.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import marcelo.junior.exradiobuttoncheckboxmanha.R;
import marcelo.junior.exradiobuttoncheckboxmanha.model.Person;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Widgets
    private EditText etName;
    private RadioGroup rgGender;
    private RadioButton rbMale;
    private RadioButton rbFemale;
    private CheckBox cbAnime;
    private CheckBox cbManga;
    private Button btAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == rbMale.getId()){
                    toast("male!!!");
                    etName.setText("1");
                }else if(checkedId == rbFemale.getId()){
                    toast("female!!!");
                    etName.setText("0");
                }
            }
        });

        CompoundButton.OnCheckedChangeListener check = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked && buttonView.getId() == cbAnime.getId()){
                    toast("checked anime!");
                }else if(isChecked && buttonView.getId() == cbManga.getId()) {
                    toast("checked manga!");
                }else if(!isChecked && buttonView.getId() == cbAnime.getId()){
                    toast("unchecked anime!");
                }else if(!isChecked && buttonView.getId() == cbManga.getId()) {
                    toast("unchecked manga!");
                }
            }
        };
        cbAnime.setOnCheckedChangeListener(check);
        cbManga.setOnCheckedChangeListener(check);
    }//close oncreate

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ma_bt_add:

                Person p = new Person();

                p.setName(etName.getText().toString());

                //Sexo
                if(rgGender.getCheckedRadioButtonId() == rbMale.getId()){
                    p.setGender(rbMale.getText().toString());
                }else if(rgGender.getCheckedRadioButtonId() == rbFemale.getId()){
                    p.setGender(rbFemale.getText().toString());
                }

                //Prefs
                ArrayList<String> prefs = new ArrayList<>();
                if(cbAnime.isChecked()){
                    prefs.add(cbAnime.getText().toString());
                }
                if(cbManga.isChecked()){
                    prefs.add(cbManga.getText().toString());
                }

                p.setPrefs(prefs);

                toast(p.toString());

                toast("Verify gender: "+p.verifyGender());
                break;
        }//close switch
    }//close onClick

    private void toast(String msg){
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }

    private void initialize(){
        etName = findViewById(R.id.ma_et_name);
        rgGender = findViewById(R.id.ma_rg_gender);
        rbMale = findViewById(R.id.ma_rb_male);
        rbFemale = findViewById(R.id.ma_rb_female);
        cbAnime = findViewById(R.id.ma_cb_anime);
        cbManga = findViewById(R.id.ma_cb_manga);
        btAdd = findViewById(R.id.ma_bt_add);

        btAdd.setOnClickListener(this);
    }
}//close class