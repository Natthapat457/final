package th.ac.su.cp.afinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import th.ac.su.cp.afinal.Adapter.UserAdapter;
import th.ac.su.cp.afinal.db.AppDatabase;
import th.ac.su.cp.afinal.db.SpeedDao;
import th.ac.su.cp.afinal.execute.AppExecutors;
import th.ac.su.cp.afinal.model.Data;

public class MainActivity extends AppCompatActivity {

    public int o1=0;
    public int o2=0;

    private RecyclerView mRecyclerView;
    protected void onResume() {


        TextView total =findViewById(R.id.text_total);
        TextView over =findViewById(R.id.text_over);
        super.onResume();
        final AppExecutors executors = new AppExecutors();
        executors.diskIO().execute(new Runnable() {
            @Override
            public void run() {

                AppDatabase db = AppDatabase.getInstance(MainActivity.this);
                final Data[] users = db.userDao().getAllUsers();
                Data [] allspeed = db.userDao().getAllUsers();
                o1=allspeed.length;
                for (int i=0;i<allspeed.length;i++){

                    if(allspeed[i].Speed>80.0){
                        o2+=1;
                    }
                }

                executors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        UserAdapter adapter = new UserAdapter(MainActivity.this, users);
                        mRecyclerView.setAdapter(adapter);
                    }
                });
            }
        });
        total.setText("TOTAL : "+o1);
        over.setText("OVER LIMIT : "+o2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView =findViewById(R.id.speed_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        Button addButton = findViewById(R.id.Add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddSpeedActivity.class);
                startActivity(i);
            }
        });
    }
}