package com.JSH.ChasquillApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {

    private static final String Database_Name="registros.db";
    private static final String Tabla_Name="maestros";

    private static final String Col_1="ID";
    private static final String Col_2="NOMBRE";
    private static final String Col_3="REPARACIONES";
    private static final String Col_4="VALOR_BASE";

    public DataBase(Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ Tabla_Name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE TEXT, REPARACIONES TEXT, VALOR_BASE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ Tabla_Name);
        onCreate(db);
    }

    public boolean insertTarea(String nombre) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        String[] parts=nombre.split(", ");

        contentValues.put(Col_2, parts[0].split(": ")[1]); // Nombre
        contentValues.put(Col_3, parts[1].split(": ")[1]); // Reparaciones
        contentValues.put(Col_4, parts[2].split(": ")[1]); // Valor Base

        long result=db.insert(Tabla_Name,null,contentValues);
        return result!=-1;
    }

    public ArrayList<String> getAllTareas() {
        ArrayList<String> tareas=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor res=db.rawQuery("SELECT * FROM "+Tabla_Name,null);

        if (res.moveToFirst()) {
            do{
                tareas.add(res.getString(1));
            }while(res.moveToNext());
        }

        res.close();
        return tareas;
    }

    public void deleteTarea(String tarea) {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Tabla_Name,"NOMBRE=?",new String[]{tarea});
    }

    public void updateTarea(String oldTarea,String newTarea){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(Col_2,newTarea);

        db.update(Tabla_Name,contentValues,"NOMBRE=?",new String[]{oldTarea});
    }
}