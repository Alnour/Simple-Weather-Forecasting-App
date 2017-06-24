package com.example.root.weatherforcasting.data.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.example.root.weatherforcasting.models.api_models.City;
import com.example.root.weatherforcasting.models.api_models.Country;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 24/06/17.
 */

public class CountriesDataBase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "countries.db";
    private static final int DATABASE_VERSION = 1;

    public CountriesDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public List<Country> getCountries(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"id", "name"};
        String sqlTables = "country";
        String sortOrder = "name";

        qb.setTables(sqlTables);
        Cursor cursor = qb.query(db, sqlSelect, null, null,
                null, null, sortOrder);

        cursor.moveToFirst();
        List<Country> res = new ArrayList<>();
        while(cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
           res.add(new Country(id, name));
        }
        cursor.close();

        return res;
    }

    public List<City> getCities(int countryId){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"id", "name"};
        String sqlTables = "city";
        String sortOrder = "name";

        String selection = "country_id" + " = ?";
        String[] selectionArgs = { countryId + "" };

        qb.setTables(sqlTables);
        Cursor cursor = qb.query(db, sqlSelect, selection, selectionArgs,
                null, null, sortOrder);
        cursor.moveToFirst();
        List<City> res = new ArrayList<>();
        while(cursor.moveToNext()) {
            Integer id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            res.add(new City(id, name));
        }
        cursor.close();

        return res;
    }

}
