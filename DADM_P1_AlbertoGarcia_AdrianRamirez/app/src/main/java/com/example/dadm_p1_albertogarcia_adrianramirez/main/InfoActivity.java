package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_info);

        //recyclerview
        recyclerView = findViewById(R.id.reciclador);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CardAdapter(cargarDatos());
        recyclerView.setAdapter(adapter);
    }

    public List<Card> cargarDatos() {
        ArrayList<Card> listCard = new ArrayList<Card>();

        listCard.add(new Card(R.drawable.akuma_img_round, "Akuma", R.drawable.japan_flag,
                "Akuma, también conocido como Gouki es Japón, es un personaje invitado en Tekken 7: Fated Retribution y uno de los principales antagonistas de la serie Street Fighter."));
        listCard.add(new Card(R.drawable.alisa_img_round, "Alisa", R.drawable.russian_flag,
                "Alisa Bosconovitch es un personaje de la serie Tekken que se presentó en Tekken 6. Es un androide creado por el Doctor Bosconovitch, diseñado para parecerse a su hija fallecida."));
        listCard.add(new Card(R.drawable.deviljin_img_round, "Devil Jin", R.drawable.japan_flag,
                "Jin Kazama es uno de los personajes principales de la serie Tekken. Aparece en la portada de la versión de consola de casi todas las secuelas luego de su introducción en Tekken 3."));
        listCard.add(new Card(R.drawable.devilkazumi_img_round, "Devil Kazumi", R.drawable.japan_flag,
                "Kazumi Mishima apareció en Tekken 7 como un nuevo personaje y principal antagonista del juego. Es la esposa de Heihachi Mishima, nuera de Jinpachi Mishima, madre de Kazuya Mishima y abuela de Jin Kazama."));
        listCard.add(new Card(R.drawable.devilkazuya_img_round, "Devil Kazuya", R.drawable.japan_flag,
                "Kazuya Mishima es uno de los personajes principales de la serie Tekken. Aparece en todos los juegos de Tekken excepto Tekken 3, en el que solo hizo dos apariciones."));
        listCard.add(new Card(R.drawable.fahkumram_img_round, "Fahkumram", R.drawable.thailand_flag,
                "Fahkumram es un nuevo personaje de la serie Tekken. Fue anunciado en el Tekken World Tour 2019 como el quinto DLC del Season Pass 3. Fue agregado a Tekken 7: Fated Retribution."));
        listCard.add(new Card(R.drawable.julia_img_round, "Julia", R.drawable.usa_flag,
                "Julia Chang apareció por primera vez en Tekken 3. Es la hija adoptiva de Michelle Chang, quien le enseñó a pelear, razón por la cual comparten el mismo estilo de lucha."));
        listCard.add(new Card(R.drawable.king_img_round, "King", R.drawable.mexican_flag,
                "King es un luchador de México que apoya a los huérfanos en todo el mundo. En los juegos, nunca se los ve sin sus máscaras de jaguar."));
        listCard.add(new Card(R.drawable.kuma_img_round, "Kuma II", R.drawable.japan_flag,
                "Kuma es el nombre de dos personajes de la serie Tekken, ambos osos y guardaespaldas de Heihachi Mishima. Kuma II es el hijo de Kuma, quien murió de viejo después del segundo Torneo King of Iron Fist."));
        listCard.add(new Card(R.drawable.steve_img_round, "Steve", R.drawable.british_flag,
                "Steve Fox apareció por primera vez en Tekken 4. Es un joven boxeador británico que fue adoptado a una edad temprana y cuyos orígenes permanecieron envueltos en un misterio durante mucho tiempo."));

        return listCard;
    }
}