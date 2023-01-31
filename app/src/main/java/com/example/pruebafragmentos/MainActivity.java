package com.example.pruebafragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

/*
Autor: Juan Francisco Sánchez González
Fecha: 28/01/2023
Clase: Actividad que contiene un TabLayout y que utiliza 2 fragments para cargar el contenido de la interfaz.
 Los tabs harán el reemplazo de los fragmentos en la activity.
*/

public class MainActivity extends AppCompatActivity {

    private com.google.android.material.tabs.TabLayout tabs;
    private Fragment fragmentInicio;
    private Fragment fragmentSegundo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciamos los 2 fragmentos y añadimos el 1º a la actividad utilizando la clase FragmentManager
        fragmentInicio = new PrimerFragmento();
        fragmentSegundo = new SegundoFragmento();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragment, fragmentInicio).commit();

        // Componente TabLayout
        tabs = (com.google.android.material.tabs.TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setIcon(android.R.drawable.star_on));
        tabs.addTab(tabs.newTab().setIcon(android.R.drawable.stat_notify_missed_call));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        // Reemplazamos el 1º fragmento en la actividad utilizando la clase FragmentManager
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragment, fragmentInicio).commit();
                        break;
                    case 1:
                        // Reemplazamos el 2º fragmento en la actividad utilizando la clase FragmentManager
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragment, fragmentSegundo).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}