package marcelo.junior.projetoblocodenotas.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import marcelo.junior.projetoblocodenotas.R;
import marcelo.junior.projetoblocodenotas.model.Bloco;

public class BlocoAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<Bloco> blocos;

    private static ClickListener clickListener;

    public BlocoAdapter(Context context, ArrayList<Bloco> blocos) {
        this.context = context;
        this.blocos = blocos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.linha_bloco,viewGroup,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder h = (ViewHolder) viewHolder;

        Bloco b = blocos.get(i);
        h.tvtext.setText("Text: "+b.getText());
        h.tvdate.setText("Date: "+b.getDate());
    }

    @Override
    public int getItemCount() {
        return blocos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        private final TextView tvtext;

        private final TextView tvdate;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            tvtext = itemView.findViewById(R.id.lb_tv_text);
            tvdate = itemView.findViewById(R.id.lb_tv_date);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(v,getAdapterPosition());
        }

        public boolean onLongClick(View v){
            clickListener.onItemLongClick(v,getAdapterPosition());
            return true;
        }
    }//feccha classe viewHolder

    //7 - método para acessar externamente de MainActivity
    public void setOnItemClickListener(ClickListener clickListener){
        BlocoAdapter.clickListener = clickListener;
    }

    public interface ClickListener{
        void onItemClick(View v,int position);
        void onItemLongClick(View v,int position);
    }//fecha interface ClickListener

}//fecha classe