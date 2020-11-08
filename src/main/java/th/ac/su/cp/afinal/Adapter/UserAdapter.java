package th.ac.su.cp.afinal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import th.ac.su.cp.afinal.R;
import th.ac.su.cp.afinal.model.Data;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private Context mContext;
    private Data[] mUsers;

    public UserAdapter(Context context, Data[] users) {
        this.mContext = context;
        this.mUsers = users;
    }


    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {
        Data user = mUsers[position];
        holder.Calculate.setText(String.format("%.2f",user.Speed)+" KM/H");
        holder.Meter.setText(String.format("%.1f",user.Distance)+" METERS, ");
        holder.Time.setText(String.format("%.1f",user.Time)+ " SECOND");

    }

    @Override
    public int getItemCount() {
        return mUsers.length;
    }
    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Calculate;
        TextView Meter;
        TextView Time;
        ImageView Over;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.Calculate = itemView.findViewById(R.id.calculate_speed);
            this.Meter = itemView.findViewById(R.id.meter);
            this.Time = itemView.findViewById(R.id.time);
            this.Over = itemView.findViewById(R.id.over_image);

        }
    }


}
