package helloworld.demo.com.ecommerceapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by shyamramesh on 31/03/18.
 */

public class ShopScreen extends AppCompatActivity {

    ListView listView;
    Button ordersbutton, cartbutton;


    String[] names = {"apple", "mango", "banana", "grapes", "orange", "blackgrapes", "cherry", "greenapple", "jackfruit", "melon", "pineapple", "strawberry", "sugarapple"};

    int[] images = {R.drawable.apple,
                    R.drawable.mango,
                    R.drawable.banana,
                    R.drawable.grapes,
                    R.drawable.orange,
                    R.drawable.blackgrapes,
                    R.drawable.cherry,
                    R.drawable.greenapple,
                    R.drawable.jackfruit,
                    R.drawable.melon,
                    R.drawable.pineapple,
                    R.drawable.strawberry,
                    R.drawable.sugarapple};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        ordersbutton = findViewById(R.id.btn1);
        cartbutton = findViewById(R.id.btn2);
        listView = findViewById(R.id.products_listview);

        ListAdapter listAdapter = new ListAdapter(ShopScreen.this, names, images);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(ShopScreen.this, DetailActivity.class);
                mIntent.putExtra("fruitNames", names[i]);
                mIntent.putExtra("fruitImages", images[i]);
                startActivity(mIntent);
            }
        });

        ordersbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopScreen.this,MyOrders.class);
                startActivity(intent);
            }
        });

        cartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopScreen.this,ShoppingCart.class);
                startActivity(intent);
            }
        });
    }


}
