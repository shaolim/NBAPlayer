package com.example.michael.nbaplayer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by michael on 12/5/17.
 */

public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListAdapter.MyViewHolder>{
    private Context context;
    private List<Player> playerList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tvPlayerName, tvPlayerHW, tvPlayerTeam;
        public ImageView imPlayer;

        public MyViewHolder(View view) {
            super(view);
            tvPlayerName = view.findViewById(R.id.tv_player_name);
            tvPlayerHW = view.findViewById(R.id.tv_player_hw);
            tvPlayerTeam = view.findViewById(R.id.tv_team);
            imPlayer = view.findViewById(R.id.im_player);
        }
    }

    public PlayerListAdapter(Context context, List<Player> playerList) {
        this.context = context;
        this.playerList = playerList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.player_list_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Player player = playerList.get(position);
        final Player.teamData teamData = player.teamData;
        holder.tvPlayerName.setText(player.getDisplayName());

        String playerDescription = player.getPosExpanded() + " | "
                + player.getHeightFeet() + " ft " + player.getHeightInches() + " | "
                + player.getWeightPounds() + " lbs";

        holder.tvPlayerHW.setText(playerDescription);
        holder.tvPlayerTeam.setText(teamData.getTricode());

        String imgUrl = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/" + player.getPersonId() + ".png";
        Log.d("IMGURL", imgUrl);
        Glide.with(context)
                .load(imgUrl)
                .override(60, 60)
                .crossFade()
                .into(holder.imPlayer);
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }
}
