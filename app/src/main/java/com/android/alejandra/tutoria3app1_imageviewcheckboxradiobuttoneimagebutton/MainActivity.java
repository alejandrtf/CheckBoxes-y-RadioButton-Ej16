package com.android.alejandra.tutoria3app1_imageviewcheckboxradiobuttoneimagebutton;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private LinearLayout layoutActivity;

    private ImageView imagen;
    private Drawable fondoInicialImagen;
    private Drawable fondoInicialActivity;

    private CheckBox cbRojo, cbTransparencia, cbActivityVerde;
    private RadioGroup rgOpcionesEscalado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtengo referencia objetos y asigno oyentes
        layoutActivity=(LinearLayout) findViewById(R.id.llLayoutActivity);
        imagen = (ImageView) findViewById(R.id.ivImagen);

        rgOpcionesEscalado=(RadioGroup)findViewById(R.id.rgOpcionesCentrado);
        rgOpcionesEscalado.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rbCentrado){
                    imagen.setScaleType(ScaleType.CENTER_INSIDE);
                }
                else if(checkedId==R.id.rbEstirado){
                    imagen.setScaleType(ScaleType.FIT_CENTER);
                }

            }
        });

        //obtengo el fondo original de la imagen
        fondoInicialImagen = imagen.getBackground();
        fondoInicialActivity=layoutActivity.getBackground();

        cbRojo = (CheckBox) findViewById(R.id.cbOp1Check);
        cbRojo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    imagen.setBackgroundColor(Color.RED);
                else
                    imagen.setBackground(fondoInicialImagen);


            }
        });

        cbTransparencia = (CheckBox) findViewById(R.id.cbOp2Check);
        cbTransparencia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    imagen.setAlpha(0.5f);
                else
                    imagen.setAlpha(1.0f);


            }
        });


        cbActivityVerde = (CheckBox) findViewById(R.id.cbOp3Check);
        cbActivityVerde.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    layoutActivity.setBackgroundColor(Color.GREEN);

                else
                    layoutActivity.setBackground(fondoInicialActivity);


            }
        });


    }


    /**
     * Método llamado al pulsar un botón de imagen y que carga la imagen
     * correspondiente en el ImageView
     *
     * @param v Vista sobre la que se pulsó (en este caso, botón)
     */

    public void cargarImagen(View v) {
        //hago cast sobre la vista View v que es la vista pulsada
        ImageButton botonPulsado = (ImageButton) v;

        //asigno imagen al ImageView
        imagen.setImageDrawable(botonPulsado.getDrawable());
    }
}
