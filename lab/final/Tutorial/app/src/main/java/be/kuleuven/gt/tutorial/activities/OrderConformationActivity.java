package be.kuleuven.gt.tutorial.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

import be.kuleuven.gt.tutorial.R;
import be.kuleuven.gt.tutorial.model.CoffeeOrder;


public class OrderConformationActivity extends AppCompatActivity {

    private TextView ocTextView;
    private static final String POST_URL = "https://studev.groept.be/api/a22pt211/test1/customer/coffee";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_conformation);

        ocTextView = (TextView) findViewById(R.id.ocTextView);
        CoffeeOrder order =(CoffeeOrder) getIntent().getParcelableExtra("Order");
        
        ocTextView.setText(order.toString());

        //database
        ProgressDialog progressDialog = new ProgressDialog(OrderConformationActivity.this);
        progressDialog.setMessage("Uploading...please wait...");

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest submitRequest = new StringRequest(Request.Method.POST, POST_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        Toast.makeText(
                                OrderConformationActivity.this,
                                "Post request executed",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(
                                OrderConformationActivity.this,
                                "Unable to place the order" + error,
                                Toast.LENGTH_LONG).show();
                    }
                }
        ){ //NOTE THIS PART: here we are passing the POST parameters to the webservice
            @Override
            protected Map<String, String> getParams() {
                /* Map<String, String> with key value pairs as data load */
                return order.getPostParameters();
            }
        };
        progressDialog.show();

//        add to web thread
        requestQueue.add(submitRequest);


    }

    public void onBtnShowQueue_Clicked(View caller) {
        Intent intent = new Intent(this, ShowQueueActivity.class);
        startActivity(intent);
    }


}