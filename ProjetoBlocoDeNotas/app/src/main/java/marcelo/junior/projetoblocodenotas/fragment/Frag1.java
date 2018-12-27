package marcelo.junior.projetoblocodenotas.fragment;



import android.app.DatePickerDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


import marcelo.junior.projetoblocodenotas.R;
import marcelo.junior.projetoblocodenotas.adapter.BlocoAdapter;
import marcelo.junior.projetoblocodenotas.model.Bloco;
import marcelo.junior.projetoblocodenotas.model.MyApplication;

public class Frag1 extends Fragment {



    private Button btSave;

    private CalendarView cvCalendar;
    private EditText etText;

    private ArrayList<Bloco> blocos;
    private BlocoAdapter adapter;
    private RecyclerView rvBlocos;

    private MyApplication myApp;
    private DatabaseReference banco; //Referencia do banco

    private TextView etData;
    private Calendar myCalendar;


    public Frag1() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_frag1, container, false);

        //programar

        myApp = new MyApplication();



        //CRIANDO UM NÓ(TABELA) NO BANCO
        banco = FirebaseDatabase.getInstance().getReference("blocos");
        final Date date = null;
        CalendarView cv = new CalendarView(getContext());


        //Refs
        etData = v.findViewById(R.id.fg1_et_date);
        myCalendar = Calendar.getInstance();
        etText = v.findViewById(R.id.fg1_et_text);
     //   cvCalendar = v.findViewById(R.id.fg1_cv_calendarView);
        btSave = v.findViewById(R.id.fg1_bt_save);



        final DatePickerDialog.OnDateSetListener dt = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };


        etData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), dt, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        blocos = new ArrayList<>();

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etText.getText().toString().isEmpty()){
                    etText.setError("Type a text!");
                    return;
                }
//                cvCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//                    @Override
//                    public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
//                        String date = i2 + "/" + (i1+1) + "/" + i;
//                        Log.d(getTag(), "onSelectedDayChange: mm/dd/yyyy:  " + date);
//                    }
//                });

                Bloco b = new Bloco();
                b.setText(etText.getText().toString());
                b.setDate(etData.getText().toString());
                Toast.makeText(getContext(),"Anotação Cadastrada",Toast.LENGTH_LONG).show();
                banco.push().setValue(b);
            }
        });

        return v;
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, new Locale("pt","BR"));
        etData.setText(sdf.format(myCalendar.getTime()));
    }
}