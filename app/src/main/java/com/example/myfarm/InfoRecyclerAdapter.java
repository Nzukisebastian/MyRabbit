package com.example.myfarm;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class InfoRecyclerAdapter extends RecyclerView.Adapter<InfoRecyclerAdapter.UserViewHolder> {

private List<Info> listUsers;

public InfoRecyclerAdapter(List<Info> listUsers) {
        this.listUsers = listUsers;
        }

@Override
public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.iteminfo, parent, false);

        return new UserViewHolder(itemView);
        }

@Override
public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.types.setText(listUsers.get(position).getBreedtype());
        holder.description.setText(listUsers.get(position).getBreeddetails());
        }

@Override
public int getItemCount() {
        Log.v(InfoRecyclerAdapter.class.getSimpleName(),""+listUsers.size());
        return listUsers.size();
        }


/**
 * ViewHolder class
 */
public class UserViewHolder extends RecyclerView.ViewHolder {

    public AppCompatTextView types;
    public AppCompatTextView description;

    public UserViewHolder(View view) {
        super(view);
        types = (AppCompatTextView) view.findViewById(R.id.type);
        description= (AppCompatTextView) view.findViewById(R.id.descriptin);
    }
}
}
