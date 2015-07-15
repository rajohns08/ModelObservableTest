package com.example.adamjohns.modelobservabletest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements MainView {

    TextView numCarsTextView;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenterImpl(this);
        numCarsTextView = (TextView)findViewById(R.id.num_cars);
    }

    // XML Clicks

    public void buyCarClicked(View view) {
        presenter.updateNumCars();
    }

    // MainView Overrides

    @Override
    public void updateTextView(String numCars) {
        numCarsTextView.setText("Number of cars owned: " + numCars);
    }

}
