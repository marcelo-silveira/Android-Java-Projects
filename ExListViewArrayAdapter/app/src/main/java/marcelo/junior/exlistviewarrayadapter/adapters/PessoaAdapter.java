package marcelo.junior.exlistviewarrayadapter.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


import marcelo.junior.exlistviewarrayadapter.R;
import marcelo.junior.exlistviewarrayadapter.model.Pessoa;

public class PessoaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Pessoa> pessoas;
    private LayoutInflater inflater;

    public PessoaAdapter(Context context, ArrayList<Pessoa> pessoas) {
        this.context = context;
        this.pessoas = pessoas;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return pessoas.size();
    }

    @Override
    public Pessoa getItem(int position) {
        return pessoas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0; //nao usa!
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.linha_pessoa, parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Pessoa p = getItem(position);

        holder.tvNome.setText("Nome: "+p.getNome());
        holder.tvIdade.setText("Idade: "+p.getIdade());
        holder.tvIdadeMeses.setText("Idade em meses: "+p.calcularIdadeMeses());

        return convertView;
    }//fecha getView

    static class ViewHolder{

        private TextView tvNome;
        private TextView tvIdade;
        private TextView tvIdadeMeses;

        public ViewHolder(View v) {
            tvNome = v.findViewById(R.id.lp_tv_nome);
            tvIdade = v.findViewById(R.id.lp_tv_idade);
            tvIdadeMeses= v.findViewById(R.id.lp_lv_idade_meses);
        }
    }
}//fecha classe