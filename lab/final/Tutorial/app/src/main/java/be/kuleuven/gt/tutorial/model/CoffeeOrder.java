package be.kuleuven.gt.tutorial.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeOrder implements Parcelable {
    private String name;
    private String coffee;
    private boolean sugar;
    private boolean whipCream;
    private int quantity;

    private String dateDue;
    public CoffeeOrder(String name, String coffee, boolean sugar, boolean cream,int quantity){
        this.name = name;
        this.coffee = coffee;
        this.sugar = sugar;
        this.whipCream = cream;
        this.quantity = quantity;


    }

    protected CoffeeOrder(Parcel in) {
        name = in.readString();
        coffee = in.readString();
        sugar = in.readByte() != 0;
        whipCream = in.readByte() != 0;
        quantity = in.readInt();
    }

    public CoffeeOrder(JSONObject o) {
        try {
            name = o.getString("name");
            coffee = o.getString("coffee");
            String toppings = o.getString("toppings");
            sugar = toppings.contains("sugar");
            whipCream = toppings.contains("cream");
            quantity = o.getInt("quantity");
            dateDue = o.getString("date_due"); // yyyy-mm-dd hh:mm
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final Creator<CoffeeOrder> CREATOR = new Creator<CoffeeOrder>() {
        @Override
        public CoffeeOrder createFromParcel(Parcel in) {
            return new CoffeeOrder(in);
        }

        @Override
        public CoffeeOrder[] newArray(int size) {
            return new CoffeeOrder[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(coffee);
        dest.writeByte((byte) (sugar ? 1 : 0));
        dest.writeByte((byte) (whipCream ? 1 : 0));
        dest.writeInt(quantity);

    }
    public Map<String, String> getPostParameters() {
        Map<String, String> params = new HashMap<>();
        params.put("customer", name);
        params.put("coffee", coffee);
        params.put("toppings", getToppingsURL());
        params.put("quantity", String.valueOf(quantity)); //map this to the sql :quantity
        return params;
    }

    private String getToppingsURL() {
        if (sugar || whipCream) {
            return (sugar ? "+sugar" : "") + (whipCream ? "+cream" : "");
        } else {
            return "-";
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return "sth";
    }

    public int getQuantity() {
        return quantity;
    }
}
