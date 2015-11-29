package com.example.lizelu.userinterfacedemo;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int i = 0;
    private double imageAlpha = 0.1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myTextView = (TextView) findViewById(R.id.name_text_view);
        String myText = myTextView.getText().toString();
        myTextView.setText(myText + "  Add");

        Button button = (Button) findViewById(R.id.click_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText myEditText = (EditText) findViewById(R.id.edit_text);
                String inputText = myEditText.getText().toString();
                Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();

                //showAlter();

                //showProgressBar();

                //chageImage();
            }
        });

        button.setOnClickListener(this);

        showLayoutActivity(R.id.show_next_activity, Main2Activity.class);
        showLayoutActivity(R.id.show_relative__activity, Main3Activity.class);
        showLayoutActivity(R.id.show_relative__frame, Main4Activity.class);
        showLayoutActivity(R.id.show_relative__table, Main5Activity.class);

    }

    private void showLayoutActivity(int id, final Class<?> cls ) {
        Button button = (Button) findViewById(id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, cls);
                startActivity(intent);
            }
        });
    }

    private void showAlter() {
        AlertDialog.Builder alterDialog = new AlertDialog.Builder(MainActivity.this);
        alterDialog.setTitle("提示框");
        alterDialog.setMessage("提示内容");
        alterDialog.setCancelable(false);
        alterDialog.setPositiveButton("好的", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "好的", Toast.LENGTH_SHORT).show();
            }
        });
        alterDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
        alterDialog.show();
    }

    private void showProgressBar() {
        ProgressBar myProgressBar = (ProgressBar) findViewById(R.id.my_progress_bar);
        myProgressBar.setProgress(myProgressBar.getProgress() + 10);

        if (myProgressBar.getProgress() == myProgressBar.getMax()) {
            myProgressBar.setVisibility(View.GONE);
            myProgressBar.setProgress(0);
        } else {
            myProgressBar.setVisibility(View.VISIBLE);
        }
    }

    private void chageImage() {
        //imageView
        ImageView myImageView = (ImageView) findViewById(R.id.my_image_view);
        myImageView.setAlpha((float) (imageAlpha += 0.1));
        if (i == 0) {
            myImageView.setImageResource(R.drawable.image02);
            i = 1;
            return;
        }

        if (i == 1) {
             myImageView.setImageResource(R.drawable.image01);
            i = 0;
            return;
        }
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.click_button:

                ProgressDialog myProgressDialog = new ProgressDialog(MainActivity.this);
                myProgressDialog.setTitle("ProgressDialog");
                myProgressDialog.setMessage("Loading……");
                myProgressDialog.setCancelable(true);
                myProgressDialog.show();

                break;
            default:
                break;
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
