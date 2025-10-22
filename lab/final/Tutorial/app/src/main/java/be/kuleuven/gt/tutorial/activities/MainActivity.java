package be.kuleuven.gt.tutorial.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import be.kuleuven.gt.tutorial.R;
import be.kuleuven.gt.tutorial.model.CoffeeOrder;


public class MainActivity extends AppCompatActivity {

    private Button btnPlus;
    private TextView lblQty;
    private Button btnMinus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        lblQty = (TextView) findViewById(R.id.lblQty);
        btnMinus =(Button) findViewById(R.id.btnMinus);
    }

    public void onBtnPlus_Clicked(View caller){
        int quantity = Integer.parseInt(lblQty.getText().toString()) + 1;
        lblQty.setText(Integer.toString(quantity));
    }

    public void onBtnMinus_Clicked(View caller){

        int quantity = Integer.parseInt(lblQty.getText().toString());
        if(quantity > 0)
            quantity --;
        lblQty.setText(Integer.toString(quantity));
    }

    public void onSubmitBtn_Clicked(View caller){

        EditText textName = findViewById(R.id.textName);
        Spinner spCoffee = findViewById(R.id.spCoffee);
        CheckBox cbSuger = findViewById(R.id.cbSugar);
        CheckBox cbCream = findViewById(R.id.cbWhipCream);

        CoffeeOrder order = new CoffeeOrder(
                textName.getText().toString(),
                spCoffee.getSelectedItem().toString(),
                cbSuger.isChecked(),
                cbCream.isChecked(),
                Integer.parseInt(lblQty.getText().toString())
        );

        Intent intent = new Intent(this, OrderConformationActivity.class);
        intent.putExtra("Order",order);
        startActivity(intent);
    }
}