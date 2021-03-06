package helloworld.demo.com.ecommerceapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText1;
    CheckBox checkBox;
    Button button;
    private SharedPreferences mpreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        editText = findViewById(R.id.txtemail);
        editText1 = findViewById(R.id.txtpass);
        checkBox = findViewById(R.id.chk);
        button = findViewById(R.id.btn);


        mpreferences = getSharedPreferences("helloworld.demo.com.ecommerceapplicatio", Context.MODE_PRIVATE);
        mEditor = mpreferences.edit();
        checkedSharedPreferences();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBox.isChecked()) {

                    mEditor.putString(getString(R.string.checkbox), "True");
                    mEditor.commit();

                    //save name
                    String name = editText.getText().toString();
                    mEditor.putString(getString(R.string.name), name);
                    mEditor.commit();

                    //save password
                    String password = editText.getText().toString();
                    mEditor.putString(getString(R.string.password), password);
                    mEditor.commit();
                }
               moveToShopScreen();
            }
        });
    }

    private void moveToShopScreen() {
        Intent intent = new Intent(this,ShopScreen.class);
        startActivity(intent);
    }


    private void checkedSharedPreferences() {

        String checkbox = mpreferences.getString(getString(R.string.checkbox), "false");
        String name = mpreferences.getString(getString(R.string.name), "");
        String password = mpreferences.getString(getString(R.string.password), "");
        editText.setText(name);
        editText1.setText(password);
        if (checkbox.equals("True")) {
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }

    }
}

