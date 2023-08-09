package com.example.ejercicio_3_2_recyclerview_3p;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv1;
    String []nombres={"Marco Paz","Carlos Ancelotti","Ana Rosa","Laura Alvarez","Oscar Castañeda","Antonela Rocuzo","Guztavo Cerati"};
    int []edades={23,35,21,45,7,32,23,45};
    int []fotos={R.drawable.persona1,R.drawable.persona2,R.drawable.persona3,R.drawable.persona4,R.drawable.persona5,R.drawable.persona6,R.drawable.persona7,R.drawable.persona8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv1=findViewById(R.id.rv1);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rv1.setLayoutManager(linearLayoutManager);

        rv1.setAdapter(new AdaptadorPersona());
    }

    private class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.AdaptadorPersonaHolder> {

        @NonNull
        @Override
        public AdaptadorPersonaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorPersonaHolder(getLayoutInflater().inflate(R.layout.layout_tarjeta,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorPersonaHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return nombres.length;
        }

        class AdaptadorPersonaHolder extends RecyclerView.ViewHolder {
            ImageView iv1;
            TextView tv1,tv2;
            public AdaptadorPersonaHolder(@NonNull View itemView) {
                super(itemView);
                iv1=itemView.findViewById(R.id.imageView);
                tv1=itemView.findViewById(R.id.tvnombre);
                tv2=itemView.findViewById(R.id.tvedad);
            }

            public void imprimir(int position) {
                iv1.setImageResource(fotos[position]);
                tv1.setText(nombres[position]);
                tv2.setText("Edad:"+edades[position]);
            }
        }
    }
}