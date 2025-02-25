package com.example.sizewiseparkingapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sizewiseparkingapp.R;
import com.example.sizewiseparkingapp.ui.components.ParkingSpotsAdapter;
import com.example.sizewiseparkingapp.ParkingViewModel;

import java.util.Objects;

public class MapFragment extends Fragment {
    private RecyclerView parkingSpotsRecyclerView;
    private ParkingSpotsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        initializeViews(view);
        setupViewModel();
        return view;
    }

    private void initializeViews(View view) {
        parkingSpotsRecyclerView = view.findViewById(R.id.parkingSpotsRecyclerView);
        parkingSpotsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setupViewModel() {
        ParkingViewModel viewModel = new ViewModelProvider(requireActivity()).get(ParkingViewModel.class);
        adapter = new ParkingSpotsAdapter(requireContext(), Objects.requireNonNull(viewModel.getUiState().getValue()).getParkingSpots());
        parkingSpotsRecyclerView.setAdapter(adapter);

        viewModel.getUiState().observe(getViewLifecycleOwner(), uiState -> 
            adapter.updateData(uiState.getParkingSpots())
        );
    }
} 