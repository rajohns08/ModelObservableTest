package com.example.adamjohns.modelobservabletest;

import rx.subjects.PublishSubject;

public class Garage {

    public static PublishSubject<Garage> garageStream = PublishSubject.create();
    private static final Garage instance = new Garage();
    private int numCars;

    private Garage() {}

    public static Garage getInstance() {
        return instance;
    }

    public int getNumCars() {
        return numCars;
    }

    public void setNumCars(int numCars) {
        this.numCars = numCars;
        garageStream.onNext(this);
    }

}
