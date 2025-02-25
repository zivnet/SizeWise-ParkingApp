package com.example.sizewiseparkingapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class ParkingViewModel extends ViewModel {
    private final MutableLiveData<ParkingUiState> uiState = new MutableLiveData<>();

    public ParkingViewModel() {
        loadParkingSpots();
    }

    public LiveData<ParkingUiState> getUiState() {
        return uiState;
    }

    private void loadParkingSpots() {
        List<ParkingSpot> dummySpots = new ArrayList<>();
        dummySpots.add(new ParkingSpot(1, "Mappo 22 St", "4 min away", "parking_spot_1", "Large parking space"));
        dummySpots.add(new ParkingSpot(2, "Gordon 30 St", "5 min away", "parking_spot_2", "Area under construction"));
        dummySpots.add(new ParkingSpot(3, "Mappo 11 St", "4 min away", "parking_spot_3", "Parking available"));
        dummySpots.add(new ParkingSpot(4, "Ruppin 5 St", "2 min away", "parking_spot_1", "Small parking space"));
        dummySpots.add(new ParkingSpot(5, "Byron 15 St", "3 min away", "parking_spot_2", "Double parking available"));

        uiState.setValue(new ParkingUiState(dummySpots, false, null));
    }
}



