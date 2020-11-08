package th.ac.su.cp.afinal.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "Speed")
public class Data {

        @PrimaryKey(autoGenerate = true)
        public final int id;

        @ColumnInfo(name = "speedkm")
        public Double Speed=0.0;

        @ColumnInfo(name = "Distance")
        public Double Distance=0.0;

        @ColumnInfo(name = "time")
        public Double Time=0.0;


        public Data(int id, Double Speed, Double Distance,Double Time) {
            this.id = id;
            this.Speed = Speed;
            this.Time = Time;
            this.Distance = Distance;
        }



}




