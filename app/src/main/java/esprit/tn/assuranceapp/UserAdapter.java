package esprit.tn.assuranceapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Hamza FAIZA on 07/10/2017.
 */

public class UserAdapter extends ArrayAdapter<User> {

    public static class ViewHolder{
        TextView name;
        TextView ville;
        TextView immat;
        TextView modele;
        TextView marque;
        TextView phone;
    }

    public UserAdapter(@NonNull Context context, @NonNull List<User> users) {
        super(context, 0, users);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        User user=getItem(position);
        ViewHolder viewHolder;


        /*if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.activity_affecter_depannage,parent,false);
        }*/

        if(convertView==null){
            //injecter le layout roww dans son parent
            LayoutInflater layoutInflater=LayoutInflater.from(getContext());
            convertView =layoutInflater.inflate(R.layout.row_example,parent,false);

            //creer une nvlle instance du view holder
            viewHolder=new ViewHolder();

            //faire le binding des composant
            viewHolder.name = (TextView)convertView.findViewById(R.id.txtValue1);
            viewHolder.ville = (TextView)convertView.findViewById(R.id.txtValue2);
            viewHolder.immat = (TextView)convertView.findViewById(R.id.txtImmat);
            viewHolder.marque = (TextView)convertView.findViewById(R.id.txtMarque);
            viewHolder.modele = (TextView)convertView.findViewById(R.id.txtModel);
            viewHolder.phone = (TextView)convertView.findViewById(R.id.txtPhone);

            //garder un refenrece sur le convertView
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }

       /* TextView txt1=(TextView)convertView.findViewById(R.id.txtValue1);
        txt1.setText(user.getFname());

        TextView txt2=(TextView)convertView.findViewById(R.id.txtValue2);
        txt2.setText(user.getVeh_mark());*/
        viewHolder.name.setText(viewHolder.name.getText()+user.getFname()+" "+user.getLname());
        viewHolder.ville.setText(viewHolder.ville.getText()+user.getVille());
        viewHolder.immat.setText(viewHolder.immat.getText()+user.getVeh_number());
        viewHolder.marque.setText(viewHolder.marque.getText()+user.getVeh_mark());
        viewHolder.modele.setText(viewHolder.modele.getText()+user.getVeh_modele());
        viewHolder.phone.setText(viewHolder.phone.getText()+user.getPhone());

        return convertView;
    }
}














