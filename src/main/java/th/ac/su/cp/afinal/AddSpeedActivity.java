package th.ac.su.cp.afinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import th.ac.su.cp.afinal.db.AppDatabase;
import th.ac.su.cp.afinal.execute.AppExecutors;
import th.ac.su.cp.afinal.model.Data;

public class AddSpeedActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        Button save = findViewById(R.id.save_button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText ed1 = findViewById(R.id.meter_input);
                String s1=ed1.getText().toString();
                Double distance = Double.parseDouble(s1);
                EditText ed2 = findViewById(R.id.time_input);
                Double timer = Double.parseDouble(ed2.getText().toString());
                Double speed = (((distance/(timer*100))*100)*60*60)/1000;
                final Data adddata = new Data(0,speed,distance,timer);


                AppExecutors executors = new AppExecutors();
                executors.diskIO().execute(new Runnable() {
                    @Override
                    public void run() { // worker thread
                        AppDatabase db = AppDatabase.getInstance(AddSpeedActivity.this);
                        db.userDao().addUser(adddata);
                        final Data[] users = db.userDao().getAllUsers();
                        Data [] allspeed = db.userDao().getAllUsers();
                        int o1=0;
                        int o2=0;
                        o1=allspeed.length;
                        for (int i=0;i<allspeed.length;i++){

                            if(allspeed[i].Speed>80.0){
                                o2+=1;
                            }
                        }

                        finish();


                    }
                });


            }
        });






    }


}
