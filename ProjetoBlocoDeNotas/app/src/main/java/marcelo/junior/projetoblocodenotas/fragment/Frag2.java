package marcelo.junior.projetoblocodenotas.fragment;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import marcelo.junior.projetoblocodenotas.R;
import marcelo.junior.projetoblocodenotas.adapter.BlocoAdapter;
import marcelo.junior.projetoblocodenotas.model.Bloco;
import marcelo.junior.projetoblocodenotas.model.MyApplication;
import marcelo.junior.projetoblocodenotas.ui.MainActivity;

public class Frag2 extends Fragment {

    public Frag2(){}



    private ArrayList<Bloco> blocos;
    private BlocoAdapter adapter;
    private RecyclerView rvBlocos;

    private MyApplication myApplication;
    private DatabaseReference bank; //Referencia do banco

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        blocos = new ArrayList<>();
        adapter = new BlocoAdapter(getContext(), blocos);

        myApplication = new MyApplication();

        bank = FirebaseDatabase.getInstance().getReference("blocos");

        bank.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                blocos.clear();
                for (DataSnapshot data: dataSnapshot.getChildren()) {

                    Bloco b = data.getValue(Bloco.class);
                    b.setKey(data.getKey());
                    blocos.add(b);
                } // fechar for

                adapter.notifyDataSetChanged(); //notifica adapter
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_frag2, container, false);

        init(view);

        adapter.setOnItemClickListener(new BlocoAdapter.ClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Toast.makeText(getContext(), "Clicou", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClick(View v, final int position) {

                AlertDialog.Builder msg = new AlertDialog.Builder(getContext());
                msg.setTitle("Confirmaçao");
                msg.setMessage("Voce tem certeza que deseja excluir essa anotação?");
                msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Bloco b = blocos.get(position);
                        bank.child(b.getKey()).removeValue();
                    }
                });
                msg.setNegativeButton("Nao", null);
                msg.show();
            }
        });

        return view;
    }

    private void init(View view){
        adapter = new BlocoAdapter(getActivity(),blocos);

        rvBlocos = view.findViewById(R.id.fg2_rv_recicle);
        rvBlocos.setAdapter(adapter);
        rvBlocos.setHasFixedSize(true);
        rvBlocos.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

    }

}