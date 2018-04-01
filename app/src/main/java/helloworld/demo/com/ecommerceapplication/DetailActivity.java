package helloworld.demo.com.ecommerceapplication;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class DetailActivity extends AppCompatActivity {

    TextView mTextView;
    ImageView mImageView;
    DataBaseHelper myDb;
    DbHelper Db;
    Button addtocartbutton, makeorderbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        myDb = new DataBaseHelper(this);
        Db = new DbHelper(this);
        mTextView = (TextView) findViewById(R.id.from_name);
        mImageView = (ImageView) findViewById(R.id.list_image);
        addtocartbutton = (Button) findViewById(R.id.btn1);
        makeorderbutton = (Button) findViewById(R.id.btn2);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mTextView.setText(mBundle.getString("fruitNames"));
            mImageView.setImageResource(mBundle.getInt("fruitImages"));
        }

        addtocartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCartData();
            }
        });

        makeorderbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOrderData();
            }
        });
    }

    private void addOrderData() {

        if (mTextView.getText().toString().length() == 0) {
            Toast.makeText(getApplicationContext(), "Enter Name", Toast.LENGTH_SHORT).show();
        } else {
            String name = Db.checkName(mTextView.getText().toString());
            if (name == null) {
                boolean isInserted = Db.insertData(new Contact(null,
                        mTextView.getText().toString()));
                if (isInserted)
                    Toast.makeText(getApplicationContext(), "Placed Order Successfully", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Order not Placed", Toast.LENGTH_LONG).show();
            }
        }
    }


    public void addCartData() {
        if (mTextView.getText().toString().length() == 0) {
            Toast.makeText(getApplicationContext(), "Enter Name", Toast.LENGTH_SHORT).show();
        } else {
            String name = myDb.checkName(mTextView.getText().toString());
            if (name == null) {
                boolean isInserted = myDb.insertData(new Contact(null,
                        mTextView.getText().toString()));
                if (isInserted)
                    Toast.makeText(getApplicationContext(), "Added to Cart", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Not Added to Cart", Toast.LENGTH_LONG).show();
            }
        }
    }

}
