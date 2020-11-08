package th.ac.su.cp.afinal.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import th.ac.su.cp.afinal.model.Data;
import th.ac.su.cp.afinal.execute.AppExecutors;

@Database(entities = {Data.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase sInstance;
    public abstract SpeedDao userDao();
    private static final String TAG = "AppDatabase";
    private static final String DB_NAME = "Data.db";

    public static synchronized AppDatabase getInstance(final Context context) {
        if (sInstance == null) {

            sInstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    DB_NAME
            ).addCallback(new RoomDatabase.Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);

                }
            }).build();
        }
        return sInstance;
    }

}
