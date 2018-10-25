package com.example.omarls.pokedex_update;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class PokemonAdapt extends RecyclerView.Adapter<PokemonAdapt.PokemonHolder>{

    private List<String> mPokemonList;
    public PokemonAdapt(List <String> pokemonList ){ mPokemonList = pokemonList;}

    @Override
    public  PokemonHolder onCreateViewHolder(ViewGroup parent, int viewtype) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View pokeView = inflater.inflate(R.layout.list_item_pokemon, parent, false);

        PokemonHolder pokeHolder = new PokemonHolder(pokeView);

        return pokeHolder;
    }

    @Override
    public void onBindViewHolder(PokemonAdapt.PokemonHolder pokeHolder, int position) {
        String poke = mPokemonList.get(position);

        TextView titleTextView = pokeHolder.pokemonTitleTextView;
        titleTextView.setText(poke);


    }

    @Override
    public int getItemCount() {
        return mPokemonList.size();
    }

    public class PokemonHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView pokemonTitleTextView;


        public PokemonHolder(View itemView) {
            super(itemView);
            pokemonTitleTextView = (TextView)itemView.findViewById(R.id.poke_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String news = mPokemonList.get(getLayoutPosition());
            Intent intent = new Intent(itemView.getContext(), PokemonDetail.class);
            intent.putExtra(PokemonActivity.Pokemon_EXTRA, news);
            itemView.getContext().startActivity(intent);
        }

    }



}


