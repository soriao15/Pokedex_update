package com.example.omarls.pokedex_update;
import java.util.List;
import java.util.UUID;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

public class Pokemon{
    //@SerializedName("id")
    //private int mId;

    @SerializedName("name")
    private String mname;

    @SerializedName("height")
    private String mheight;

    @SerializedName("weight")
    private String mweight;

    @SerializedName("stats")
    private List <JsonObject> mstats;

    @SerializedName("types")
    private List<JsonObject> mtypes;

    @SerializedName("type")
    private String mcategory;

    @SerializedName("hp")
    private String mhp;

    @SerializedName("attack")
    private String mattack;

    @SerializedName("special-attack")
    private String mspattack;

    @SerializedName("defense")
    private String mdefense;

    @SerializedName("special-defense")
    private String mspdefense;

    @SerializedName("speed")
    private String mspeed;

    @SerializedName("sprites")
    private JsonObject sprites;

    @SerializedName("image")
    private String mimage;


    public Pokemon() {
        //mId = UUID.randomUUID();

    }



    public Pokemon(String name, String category, String hp, String attack, String spattack, String weight, String height,
                   String defense, String spdefense, String speed , String image){

        //mId = UUID.randomUUID();
        this.mname = name;
        this.mcategory = category;
       this.mhp = hp;
       this.mattack = attack;
       this.mspattack = spattack;
        this.mweight = weight;
       this.mheight = height;
       this.mdefense = defense;
        this.mspdefense = spdefense;
       this.mspeed = speed;
       this.mimage = image;

    }

    public String getWeight() {
        return mweight;
    }

   public String getAttack() {
       for (int i= 0; i < this.mstats.size(); i++) {
                JsonObject x = this.mstats.get(i);
                if ( x.get("stat") instanceof JsonObject) {
                    if( String.valueOf(((JsonObject) x.get("stat")).get("name")).equals("\"attack\"") ){
                        this.mattack = String.valueOf(x.get("base_stat"));
                    }
                }
       }
       return this.mattack;
   }

    //public int getId() {
   //     return mId;
    //}

    public String getDefense() {

        for (int i= 0; i < this.mstats.size(); i++) {
            JsonObject x = this.mstats.get(i);
            if ( x.get("stat") instanceof JsonObject) {
                if( String.valueOf(((JsonObject) x.get("stat")).get("name")).equals("\"defense\"") ){
                    this.mdefense = String.valueOf(x.get("base_stat"));
                }
            }
        }
        return this.mdefense;
    }



    public String getHp() {

        for (int i= 0; i < this.mstats.size(); i++) {
            JsonObject x = this.mstats.get(i);
            if ( x.get("stat") instanceof JsonObject) {
                if( String.valueOf(((JsonObject) x.get("stat")).get("name")).equals("\"hp\"") ){
                    this.mhp = String.valueOf(x.get("base_stat"));
                }
            }
        }
        return this.mhp;
    }

    public String getSpattack() {

        for (int i= 0; i < this.mstats.size(); i++) {
        JsonObject x = this.mstats.get(i);
        if ( x.get("stat") instanceof JsonObject) {
        if( String.valueOf(((JsonObject) x.get("stat")).get("name")).equals("\"special-attack\"") ){
        this.mspattack = String.valueOf(x.get("base_stat"));
        }
        }
        }
        return this.mspattack;
        }



    public String getSpdefense() {

        for (int i= 0; i < this.mstats.size(); i++) {
            JsonObject x = this.mstats.get(i);
            if ( x.get("stat") instanceof JsonObject) {
                if( String.valueOf(((JsonObject) x.get("stat")).get("name")).equals("\"special-defense\"") ){
                    this.mspdefense = String.valueOf(x.get("base_stat"));
                }
            }
        }
        return this.mspdefense;
    }



    public String getSpeed() {

        for (int i= 0; i < this.mstats.size(); i++) {
            JsonObject x = this.mstats.get(i);
            if ( x.get("stat") instanceof JsonObject) {
                if( String.valueOf(((JsonObject) x.get("stat")).get("name")).equals("\"speed\"") ){
                    this.mspeed = String.valueOf(x.get("base_stat"));
                }
            }
        }
        return this.mspeed;
    }
// unsuccessful api grab for pokemon type
    public String getCategory() {
        this.mcategory = "";
        for(int i = 0; i< this.mtypes.size(); i++){
            if(this.mtypes.get(i).get("type") instanceof  JsonObject){
                this.mcategory += ((JsonObject) this.mtypes.get(i).get("type")).get("name").getAsString() + " ";
            }
        }

        return this.mcategory;
    }

    public String getHeight() {
        return mheight;
    }

    public String getName() {
        return mname;
    }

    public String getImage() {
        this.mimage = this.sprites.get("front_default").getAsString();

        return this.mimage;
    }

    public void setImage(String mimage) {
        this.mimage = mimage;
    }

    public void setAttack(String mattack) {
        this.mattack = mattack;
    }

    public void setCategory(String mcategory) {
        this.mcategory = mcategory;
    }

    public void setDefense(String mdefense) {
        this.mdefense = mdefense;
    }

    public void setHeight(String mheight) {
        this.mheight = mheight;
    }

    public void setHp(String mhp) {
        this.mhp = mhp;
    }

    public void setName(String mname) {
        this.mname = mname;
    }


    public void setSpattack(String mspattack) {
        this.mspattack = mspattack;
    }

    public void setSpdefense(String mspdefense) {
        this.mspdefense = mspdefense;
    }

    public void setSpeed(String mspeed) {
        this.mspeed = mspeed;
    }

    public void setWeight( String mweight) {
        this.mweight = mweight;
    }

}

