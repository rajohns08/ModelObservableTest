package com.example.adamjohns.modelobservabletest;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;
    private MainInteractor mainInteractor;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        this.mainInteractor = new MainInteractorImpl();
        Subscriber<Garage> garageSubscriber = initSubscriber();

        Garage.garageStream
            .subscribeOn(Schedulers.immediate())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(garageSubscriber);
    }

    // MainPresenter Overrides

    @Override
    public void updateNumCars() {
        mainInteractor.updateNumCars();
    }

    // Subscribers

    private Subscriber<Garage> initSubscriber() {
        return new Subscriber<Garage>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Garage garage) {
                mainView.updateTextView("" + garage.getNumCars());
            }
        };
    }

}
