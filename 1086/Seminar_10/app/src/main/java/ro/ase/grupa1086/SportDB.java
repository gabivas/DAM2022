package ro.ase.grupa1086;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Sport.class}, version = 1, exportSchema = false)
public abstract class SportDB extends RoomDatabase {

    private static final String DB_NAME="sporturi.db";
    private static SportDB instanta;

    public static SportDB getInstance(Context context){
        if(instanta==null){
            instanta= Room.databaseBuilder(context, SportDB.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instanta;
    }

    public abstract SportDao getSportDao();

}
