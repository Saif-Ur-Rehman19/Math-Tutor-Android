package com.saif.mathtutor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.operation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.addition:{
                Intent intent = new Intent(this,Addition.class);
                startActivity(intent);
                break;
            }
            case R.id.subtraction:{
                Intent intent = new Intent(this,Subtraction.class);
                startActivity(intent);
                break;
            }
            case R.id.multiplication:{
                Intent intent = new Intent(this,Multiplication.class);
                startActivity(intent);
                break;
            }
            case R.id.division:{
                Intent intent = new Intent(this,Division.class);
                startActivity(intent);
                break;
            }

        }
        return true;
    }
}