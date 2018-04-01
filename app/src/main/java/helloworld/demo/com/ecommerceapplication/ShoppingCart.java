package helloworld.demo.com.ecommerceapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by shyamramesh on 31/03/18.
 */

public class ShoppingCart extends AppCompatActivity {

    private DataBaseHelper myDb;
    private ArrayList<Contact>contactlist = new ArrayList<>();
    private RelativeLayout relativelayout;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private CustomAdapter mAdapter;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        context = getApplicationContext();
        myDb = new DataBaseHelper(this);
        contactlist = myDb.getContacts();

        relativelayout = (RelativeLayout) findViewById(R.id.rl);
        recyclerView = (RecyclerView) findViewById(R.id.rc);

        mAdapter = new CustomAdapter(this,contactlist);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);


    }


}
