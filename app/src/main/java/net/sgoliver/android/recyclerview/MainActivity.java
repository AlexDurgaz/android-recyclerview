package net.sgoliver.android.recyclerview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    private RecyclerView recView;
    private Button btnInsertar;
    private Button btnEliminar;
    private Button btnMover;

    private ArrayList<Alumno> datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        datos = new ArrayList<Alumno>();

        datos.add(new Alumno("Guillermo", "Nuez Gutierrez","Masculino"));
        datos.add(new Alumno("Pepita", "Nuez Moscada","Feminino"));
        datos.add(new Alumno("Maria", "Pimienta Molida","Feminino"));
        datos.add(new Alumno("Rosa", "Melano Fuerte","Feminino"));
        datos.add(new Alumno("Loco", "Del Todo","Masculino"));
        datos.add(new Alumno("Pepa", "Maquina Olimpica","Feminino"));
        datos.add(new Alumno("Lucia", "Jimenez Perez","Feminino"));
        datos.add(new Alumno("Tito", "Primero García","Masculino"));
        datos.add(new Alumno("Pipo", "Pipero Pepino","Masculino"));
        datos.add(new Alumno("Armando", "Bronca Segura","Masculino"));

        recView = (RecyclerView) findViewById(R.id.RecView);
        recView.setHasFixedSize(true);

        final AdaptadorAlumnos adaptador = new AdaptadorAlumnos(datos);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("DemoRecView", "Pulsado el elemento " + recView.getChildPosition(v));
            }
        });

        recView.setAdapter(adaptador);

        recView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //recView.setLayoutManager(new GridLayoutManager(this,3));

        recView.addItemDecoration(
                new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        recView.setItemAnimator(new DefaultItemAnimator());

        btnInsertar = (Button)findViewById(R.id.BtnInsertar);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.add(1, new Alumno("Nuevo nombre", "Nuevos apellidos", "Nuevo sexo"));
                adaptador.notifyItemInserted(1);
            }
        });

        btnEliminar = (Button)findViewById(R.id.BtnEliminar);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.remove(1);
                adaptador.notifyItemRemoved(1);
            }
        });

        btnMover = (Button)findViewById(R.id.BtnMover);

        btnMover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Alumno aux = datos.get(1);
                datos.set(1,datos.get(2));
                datos.set(2,aux);

                adaptador.notifyItemMoved(1, 2);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
