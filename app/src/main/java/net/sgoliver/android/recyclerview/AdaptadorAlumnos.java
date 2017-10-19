package net.sgoliver.android.recyclerview;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorAlumnos
        extends RecyclerView.Adapter<AdaptadorAlumnos.AlumnosViewHolder>
        implements View.OnClickListener {

    private View.OnClickListener listener;
    private ArrayList<Alumno> datos;

    public static class AlumnosViewHolder
            extends RecyclerView.ViewHolder {

        private TextView txtNombre;
        private TextView txtApellidos;
        private ImageView imgSexo;


        public AlumnosViewHolder(View itemView) {
            super(itemView);

            txtNombre = (TextView)itemView.findViewById(R.id.LblTitulo);
            txtApellidos = (TextView)itemView.findViewById(R.id.LblSubTitulo);
            imgSexo = (ImageView)itemView.findViewById(R.id.imageSexo);


        }

        public void bindTitular(Alumno t) {
            txtNombre.setText(t.getNombre());
            txtApellidos.setText(t.getApellidos());

            if (t.getSexo()=="Masculino"){
                imgSexo.setImageResource(R.mipmap.ic_masculine);
            }

            if (t.getSexo()== "Femenino"){
                imgSexo.setImageResource(R.mipmap.ic_femenino);

            }
        }
    }

    public AdaptadorAlumnos(ArrayList<Alumno> datos) {
        this.datos = datos;
    }

    @Override
    public AlumnosViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.listitem_titular, viewGroup, false);

        itemView.setOnClickListener(this);
        //android:background="?android:attr/selectableItemBackground"

        AlumnosViewHolder tvh = new AlumnosViewHolder(itemView);

        return tvh;
    }

    @Override
    public void onBindViewHolder(AlumnosViewHolder viewHolder, int pos) {
        Alumno item = datos.get(pos);

        viewHolder.bindTitular(item);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }
}
