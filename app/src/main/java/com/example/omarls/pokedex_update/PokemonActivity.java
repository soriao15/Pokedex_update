package com.example.omarls.pokedex_update;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class PokemonActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    public static final String Pokemon_EXTRA = "com.example.omarls.pokedex_update";

    private List<Pokemon> pokemonList = new ArrayList<Pokemon>();
    private List<String> pokestrings = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        mRecyclerView = (RecyclerView)findViewById(R.id.pokemon_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(PokemonActivity.this));

       requestObject();
    }
    private void requestObject(){

        pokestrings.add("bulbasaur");
        pokestrings.add("slowpoke");
        pokestrings.add("gengar");
        pokestrings.add("dragonite");
        pokestrings.add("ludicolo");
        pokestrings.add("snorlax");
        pokestrings.add("phanpy");
        pokestrings.add("mudkip");
        pokestrings.add("hoothoot");
        pokestrings.add("sudowoodo");
        pokestrings.add("typhlosion");


        PokemonAdapt adapter = new PokemonAdapt(pokestrings/*pokemonList*/);
        mRecyclerView.setAdapter(adapter);
        }

    }



