package en.ase.group1097;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CompanieDao {

    @Insert
    long insertCompanie(Companie companie);

    @Delete
    void deleteCompanie(Companie companie);

    @Query("delete from companie")
    void deleteAll();

    @Query("select * from companie")
    List<Companie> getAll();

    @Query("update companie set nrAngajati =:nrAngajati WHERE id =:id")
    int updateCompanie(String nrAngajati, int id);

}
