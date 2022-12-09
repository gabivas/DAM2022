package en.ase.group1097;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Companie.class}, version=1, exportSchema = false)
public abstract class CompanieDB extends RoomDatabase{

    private static final String DB_NAME="comapanii.db";
    private static CompanieDB instanta;

    public static CompanieDB getInstance(Context context){
        if(instanta==null){
            instanta = Room.databaseBuilder(context, CompanieDB.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instanta;
    }

    public abstract CompanieDao getCompanieDao();

}
