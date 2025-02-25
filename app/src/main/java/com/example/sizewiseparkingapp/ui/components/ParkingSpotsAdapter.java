package com.example.sizewiseparkingapp.ui.components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sizewiseparkingapp.ParkingSpot;
import com.example.sizewiseparkingapp.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotsAdapter extends RecyclerView.Adapter<ParkingSpotsAdapter.ViewHolder> {
    private List<ParkingSpot> parkingSpots;
    private final Context context;

    public ParkingSpotsAdapter(Context context, List<ParkingSpot> parkingSpots) {
        this.context = context;
        this.parkingSpots = parkingSpots != null ? parkingSpots : new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_parking_spot, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ParkingSpot spot = parkingSpots.get(position);
        holder.bind(spot);
        
        // Load parking spot image
        int imageResource = context.getResources().getIdentifier(
            spot.getImageUrl(), "drawable", context.getPackageName());
        if (imageResource != 0) {
            holder.parkingImage.setImageResource(imageResource);
        }

        holder.mainContent.setOnClickListener(v -> {
            spot.setExpanded(!spot.isExpanded());
            notifyItemChanged(position);
        });

        holder.navigateButton.setOnClickListener(v -> {
            Toast.makeText(context, "Navigate to: " + spot.getStreet(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return parkingSpots.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateData(List<ParkingSpot> newSpots) {
        this.parkingSpots = newSpots;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View mainContent;
        View expandableContent;
        ImageView parkingImage;
        TextView streetText;
        TextView timeText;
        TextView descriptionText;
        MaterialButton navigateButton;

        ViewHolder(View itemView) {
            super(itemView);
            mainContent = itemView.findViewById(R.id.main_content);
            expandableContent = itemView.findViewById(R.id.expandable_content);
            parkingImage = itemView.findViewById(R.id.parking_image);
            streetText = itemView.findViewById(R.id.parking_street);
            timeText = itemView.findViewById(R.id.parking_time);
            descriptionText = itemView.findViewById(R.id.parking_description);
            navigateButton = itemView.findViewById(R.id.navigate_button);
        }

        void bind(ParkingSpot spot) {
            streetText.setText(spot.getStreet());
            timeText.setText(spot.getTime());
            descriptionText.setText(spot.getDescription());
            expandableContent.setVisibility(spot.isExpanded() ? View.VISIBLE : View.GONE);
        }
    }
}
