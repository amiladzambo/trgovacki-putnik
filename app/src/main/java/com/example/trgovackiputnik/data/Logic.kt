package com.example.trgovackiputnik.data

import android.util.Log
import java.util.*
import kotlin.math.sqrt

class Logic {
    public val CitiesList: MutableList<City> = mutableListOf();
    public var distances: MutableList<City> = mutableListOf();
    public var size:Int = CitiesList.size;

    public var permutations: MutableList<MutableList<City>> = mutableListOf();

    public var factorial:Int = 1
    public var br1:Int = 1;
    public var br2:Int = 2;

    public fun AddNewCity(idAdd:Int, cityNameAdd:String, countryAdd:String, lngAdd:Double, ltdAdd:Double){
        CitiesList.add(City(idAdd, cityNameAdd, countryAdd, lngAdd, ltdAdd));
        this.size = CitiesList.size;
    }

    public fun DeleteCity(cityNameDelete:String){
        var brojac:Int = 0;
        for (item in CitiesList){
            if(item.cityName.equals(cityNameDelete)){
                CitiesList.removeAt(brojac);
                break;
            }
            brojac++;
        }
        CalculateDistances();
    }

    public fun CalculateDistances(){
        Log.d("Spisak", permutations.toString());
        for(i in 0..factorial-1){
            var suma:Double = 0.00;
            for(j in 0..permutations[i].size-2){
                Log.d("GradoviId", permutations[i][j].id.toString() + permutations[i][j+1].id.toString());
            }
        }
    }

    public fun AddNewHome(homeTown:String){
        var brojac:Int = 0;
        for (item in CitiesList){
            if(item.cityName.equals(homeTown)){
                val tmp = CitiesList[brojac];
                CitiesList[brojac] = CitiesList[0];
                CitiesList[0] = tmp;
                break;
            }
            brojac++;
        }
        CalculateDistances();
        FindAllCombinations()
    }

    public fun AddDefaultCities(){
        CitiesList.add(City(1,"Sarajevo","Bosna i Hercegovina",43.8667,18.4167));
        CitiesList.add(City(2,"Banja Luka","Bosna i Hercegovina",44.7667,17.1833));
        CitiesList.add(City(3,"Mostar","Bosna i Hercegovina",43.3494,17.8125));
        CitiesList.add(City(4,"Bijeljina","Bosna i Hercegovina",44.7500,19.2167));
        this.size = CitiesList.size;
    }

    public fun GetAllCitiesNames():MutableList<String>{
        val allcities:MutableList<String> = mutableListOf();
        for (item in CitiesList){
            allcities.add(item.cityName);
        }
        Log.d("SviGradovi", allcities.toString());
        return allcities;
    }

    public fun CalculateCombinations(){
        for (i in 1..size-1) {
            factorial *= i;
        }
    }

    public fun FindAllCombinations(){
        CalculateCombinations();
        for(i in 0..factorial-1){
            if(br2 > size-1 ){
                br2 = 2;
                br1 = 1;
            }
            if(br1 > size-2){
                br1 = 1;
                br2 = 2;
            }
            val tmp = CitiesList[br1].id;
            CitiesList[br1].id = CitiesList[br2].id;
            CitiesList[br2].id = tmp;

            // for (item in CitiesList) CitiesListCopy.add(item);
            br1++;
            br2++;
            //permutations += CitiesList;
            val addCities:MutableList<City> = CitiesList.toMutableList();
            permutations.add(CitiesList.toCollection(mutableListOf()));
            Log.d("UTJ", CitiesList.toMutableList().toString());
        }
        Log.d("PMJ", permutations.toString());
        CalculateDistances();
    }
}