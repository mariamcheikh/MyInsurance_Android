package esprit.tn.assuranceapp.Adapters.Constat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import esprit.tn.assuranceapp.Models.Constat;
import esprit.tn.assuranceapp.R;

/**
 * Created by Mariam on 18/12/2017.
 */

public class ConstatAdminAdapter extends RecyclerView.Adapter<ConstatAdminAdapter.ConstatViewHolder> {


    private Context mCtx;
    private List<Constat> ConstatList;

    public ConstatAdminAdapter(Context mCtx, List<Constat> constatlist) {
        this.mCtx = mCtx;
        this.ConstatList = constatlist;
    }

    @Override
    public ConstatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.constat_list_admin_row, null);
        return new ConstatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ConstatViewHolder holder, int position) {
        Constat constat = ConstatList.get(position);


        holder.textViewdate.setText(constat.getDate());
        holder.textViewlieu.setText(constat.getLieu());
        holder.textViewnomConducteur.setText(constat.getNomConducteur());
        holder.textViewprenomConducteur.setText(constat.getPrenomConducteur());
        holder.textViewmarquevoiture.setText(constat.getMarquevoiture());
        holder.textViewimmatriculation.setText(constat.getImmatriculation());
        holder.textViewnomConducteurA.setText(constat.getNomConducteurA());
        holder.textViewprenomConducteurA.setText(constat.getPrenomConducteurA());
        holder.textViewmarquevoitureA.setText(constat.getMarquevoitureA());
        holder.textViewimmatriculationA.setText(constat.getImmatriculationA());




    }



    @Override
    public int getItemCount() {
        return ConstatList.size();
    }




    class ConstatViewHolder extends RecyclerView.ViewHolder {

        TextView textViewdate, textViewlieu, textViewnomConducteur, textViewprenomConducteur,textViewmarquevoiture,textViewimmatriculation,textViewnomConducteurA,textViewprenomConducteurA,textViewmarquevoitureA,textViewimmatriculationA;
       // ImageView imageView;

        public ConstatViewHolder(View itemView) {
            super(itemView);

            textViewdate = itemView.findViewById(R.id.textViewdate);
            textViewlieu = itemView.findViewById(R.id.textViewlieu);
            textViewnomConducteur = itemView.findViewById(R.id.textViewnomConducteur);
            textViewprenomConducteur = itemView.findViewById(R.id.textViewprenomConducteur);
            textViewmarquevoiture = itemView.findViewById(R.id.textViewmarquevoiture);
            textViewimmatriculation = itemView.findViewById(R.id.textViewimmatriculation);
            textViewnomConducteurA = itemView.findViewById(R.id.textViewnomConducteurA);
            textViewprenomConducteurA = itemView.findViewById(R.id.textViewprenomConducteurA);
            textViewmarquevoitureA = itemView.findViewById(R.id.textViewmarquevoitureA);
            textViewimmatriculationA = itemView.findViewById(R.id.textViewimmatriculationA);

        }
    }
}