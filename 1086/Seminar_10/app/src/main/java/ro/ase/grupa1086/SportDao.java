package ro.ase.grupa1086;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SportDao {

    @Insert
    long insertSport(Sport sport);

    @Query("select * from sport")
    List<Sport> selectALl();

    @Query("update sport set dificultate =:dificultate WHERE id=:id")
    int updateSport(String dificultate, int id);

    @Delete
    void deleteSport(Sport sport);

    @Query("delete from sport")
    void deleteAll();
}
