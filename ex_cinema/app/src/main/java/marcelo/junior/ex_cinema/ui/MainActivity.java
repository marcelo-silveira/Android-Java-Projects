package marcelo.junior.ex_cinema.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import marcelo.junior.ex_cinema.R;

import marcelo.junior.ex_cinema.model.Movie;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //widgets

    private EditText etMovie;
    private RatingBar rating;
    private TextView tvMovieType;
    private RadioGroup rgTypes;
    private RadioButton rbHorror;
    private RadioButton rbAction;
    private RadioButton rbThriller;
    private RadioButton rbComedy;
    private RadioButton rbRomance;
    private Button btAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

    }//close oncreate

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ma_bt_add:
                Movie m = new Movie();
                //star
                m.setEv(rating.getRating());
                //movie name
                m.setMovieName(etMovie.getText().toString());
                //movie type
                if (rgTypes.getCheckedRadioButtonId() == rbHorror.getId()){
                    m.setmType(rbHorror.getText().toString());
                }else if (rgTypes.getCheckedRadioButtonId() == rbAction.getId()) {
                    m.setmType(rbAction.getText().toString());
                }else if (rgTypes.getCheckedRadioButtonId() == rbThriller.getId()) {
                    m.setmType(rbThriller.getText().toString());
                }else if (rgTypes.getCheckedRadioButtonId() == rbComedy.getId()) {
                    m.setmType(rbComedy.getText().toString());
                }else if (rgTypes.getCheckedRadioButtonId() == rbRomance.getId()) {
                    m.setmType(rbRomance.getText().toString());
                }

                toast(m.toString());

                break;
        }//close switch
    }//close onClick

    private void toast(String msg){
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }

    private void initialize(){
        etMovie = findViewById(R.id.ma_et_movie);
        rating = findViewById(R.id.ma_rb_ev);
        tvMovieType = findViewById(R.id.ma_tv_mtype);
        rgTypes = findViewById(R.id.ma_rg_types);
        rbHorror = findViewById(R.id.ma_rb_horror);
        rbAction = findViewById(R.id.ma_rb_action);
        rbThriller = findViewById(R.id.ma_rb_thriller);
        rbComedy = findViewById(R.id.ma_rb_comedy);
        rbRomance = findViewById(R.id.ma_rb_romance);
        btAdd = findViewById(R.id.ma_bt_add);

        btAdd.setOnClickListener(this);
    }//close initialize
}//close slass
