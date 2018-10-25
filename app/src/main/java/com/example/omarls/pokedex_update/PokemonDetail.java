package com.example.omarls.pokedex_update;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonDetail extends AppCompatActivity{

    TextView titleTextView;
    TextView hpTextView;
    TextView categoryTextView;
    TextView attackTextView;
    TextView spattackTextView;
    TextView defenseTextView;
    TextView spdefenseTextView;
    TextView speedTextView;
    TextView weightTextView;
    TextView heightTextView;
    ImageView pokeImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        titleTextView = (TextView)findViewById(R.id.pokemon_title);
        hpTextView = (TextView)findViewById(R.id.pokemon_hp);
        categoryTextView = (TextView)findViewById(R.id.pokemon_category);
        attackTextView = (TextView)findViewById(R.id.pokemon_attack);
        spattackTextView = (TextView)findViewById(R.id.pokemon_spattack);
        defenseTextView = (TextView)findViewById(R.id.pokemon_defense);
        spdefenseTextView = (TextView)findViewById(R.id.pokemon_spdefense);
        speedTextView = (TextView)findViewById(R.id.pokemon_speed);
        weightTextView = (TextView)findViewById(R.id.pokemon_weight);
        heightTextView = (TextView)findViewById(R.id.pokemon_height);
        pokeImageView = (ImageView)findViewById(R.id.imageView);


        String poke = (String)getIntent().getStringExtra(PokemonActivity.Pokemon_EXTRA);

       GetPokemonDataService pokedataservice = (GetPokemonDataService) PokemonClientReference.getRetrofitInstance().create(GetPokemonDataService.class);
       Call<Pokemon> call = pokedataservice.getPokemon(poke);
       call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon>  response) {

                titleTextView.setText( "Name: "+response.body().getName() );
                hpTextView.setText("HP: " +response.body().getHp());
                attackTextView.setText("Attack: " +response.body().getAttack());
                spattackTextView.setText("Spttack: " +response.body().getSpattack());
                defenseTextView.setText("Defense " + response.body().getDefense());
                spdefenseTextView.setText("SpDefense: " + response.body().getSpdefense());
                speedTextView.setText("Speed: " +response.body().getSpeed());
                weightTextView.setText("Weight: " +response.body().getWeight());
                heightTextView.setText("Height: " +response.body().getHeight());
                categoryTextView.setText(response.body().getCategory());

                Picasso.get().load(response.body().getImage()).into(pokeImageView);
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                titleTextView.setText(t.getMessage());
            }

        });





    }

}
