package com.example.android.justjava;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.android.justjava.R.id.Schlagsahne;
import static com.example.android.justjava.R.id.Schokolade;

public class MainActivity extends AppCompatActivity {

    int numberOfCoffees;
    boolean willSchlagsahne;
    boolean willSchokolade;
    int priceTotal;
    String orderSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public int increment (View view) {
        numberOfCoffees++;
        displayQuantity (numberOfCoffees);
        return numberOfCoffees;
    }


    public int decrement (View view) {
        numberOfCoffees--;
        displayQuantity (numberOfCoffees);
        return numberOfCoffees;
    }


    public void submitOrder(View view) {
//        priceTotal = calculatePrice(numberOfCoffees, willSchlagsahne, willSchokolade);
//        String myname=holeName();
//        String Bestellung=createOrderSummary(numberOfCoffees, myname, priceTotal);
//        displayMessage(Bestellung);
    }


    private int calculatePrice(int numberOfCoffees, boolean Schlagsahne, boolean Schokolade) {
        int priceOneCup = 5;
        if (Schlagsahne == true) {
            priceOneCup++;
        }
        if (Schokolade == true) {
            priceOneCup = priceOneCup+2;
        }
        int priceTotal = priceOneCup * numberOfCoffees;
        return priceTotal;
    }


    public String holeName () {
        EditText Name = (EditText) findViewById(R.id.TextField);
        String myname = Name.getText().toString();
        return myname;
    }


    private String createOrderSummary (int numberOfCoffees, String myname, int priceTotal){
        String orderSummary;
        orderSummary="Name: " + myname;
        orderSummary=orderSummary + "\nQuantity: " + numberOfCoffees;
        orderSummary=orderSummary + "\nSchlagsahne?: " + willSchlagsahne;
        orderSummary=orderSummary + "\nSchokolade?: " + willSchokolade;
        orderSummary=orderSummary + "\nTotal: " + "€" + priceTotal;
        orderSummary=orderSummary + "\nThank you!";
        System.out.println(orderSummary);
        return orderSummary;
    }


    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }


    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }


    public void Schlagsahne (View view) {
        CheckBox checkBox = (CheckBox) findViewById(Schlagsahne);
        willSchlagsahne = checkBox.isChecked();
    }


    public void Schokolade (View view) {
        CheckBox checkBox = (CheckBox) findViewById(Schokolade);
        willSchokolade = checkBox.isChecked();
    }


}
