package th.ac.su.cp.afinal.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import th.ac.su.cp.afinal.model.Data;
@Dao
public interface SpeedDao {

    @Query("SELECT * FROM Speed")
    Data[] getAllUsers();

    @Query("SELECT * FROM Speed WHERE id = :id")
    Data getUserById(int id);

    @Insert
    void addUser(Data ... users);

    @Delete
    void deleteUser(Data user);

}
