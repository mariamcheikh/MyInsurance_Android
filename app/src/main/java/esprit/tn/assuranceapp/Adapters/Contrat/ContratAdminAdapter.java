package esprit.tn.assuranceapp.Adapters.Contrat;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import esprit.tn.assuranceapp.Models.Contrat;
import esprit.tn.assuranceapp.R;

/**
 * Created by Mariam on 21/12/2017.
 */

public class ContratAdminAdapter extends RecyclerView.Adapter<ContratAdminAdapter.ContratViewHolder> {

    private Context mCtx;
    private List<Contrat> ContratList;

    public ContratAdminAdapter(Context mCtx, List<Contrat> ContratList) {
        this.mCtx = mCtx;
        this.ContratList = ContratList;
    }

    @Override
    public ContratViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.contrat_list_admin_row, null);
        return new ContratViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContratViewHolder holder, int position) {
        Contrat contrat = ContratList.get(position);


        holder.textViewSerial_Num.setText(contrat.getSerial_num());
        holder.textViewmarque.setText(contrat.getMarque());
        holder.textViewmodele.setText(contrat.getModele());
        holder.textViewenergie.setText(contrat.getEnergie());
        holder.textViewcv_fiscaux.setText(String.valueOf(contrat.getCv_fiscaux()));
        holder.textViewimmat.setText(contrat.getImmat());
        holder.textViewdate_circul.setText(contrat.getDate_circul());





    }

    @Override
    public int getItemCount() {
        return ContratList.size();
    }

    class ContratViewHolder extends RecyclerView.ViewHolder {

        TextView textViewSerial_Num, textViewmarque, textViewmodele, textViewenergie,textViewcv_fiscaux,textViewimmat,textViewdate_circul;
        // ImageView imageView;

        public ContratViewHolder(View itemView) {
            super(itemView);

            textViewSerial_Num = itemView.findViewById(R.id.textViewSerial_Num);
            textViewmarque = itemView.findViewById(R.id.textViewmarque);
            textViewmodele = itemView.findViewById(R.id.textViewmodele);
            textViewenergie = itemView.findViewById(R.id.textViewenergie);
            textViewcv_fiscaux = itemView.findViewById(R.id.textViewcv_fiscaux);
            textViewimmat = itemView.findViewById(R.id.textViewimmat);
            textViewdate_circul = itemView.findViewById(R.id.textViewdate_circul);


        }
    }
}
