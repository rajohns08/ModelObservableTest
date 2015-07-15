package com.example.adamjohns.modelobservabletest;

public class MainInteractorImpl implements MainInteractor {

    @Override
    public void updateNumCars() {
        int currentNum = Garage.getInstance().getNumCars();
        Garage.getInstance().setNumCars(++currentNum);
    }

}
