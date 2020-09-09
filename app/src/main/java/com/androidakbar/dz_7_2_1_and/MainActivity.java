package com.androidakbar.dz_7_2_1_and;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Intent geoIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar appToolbar = findViewById(R.id.app_toolbar);
        //appToolbar.setTitle(R.string.name_dz);
        appToolbar.setTitle(R.string.title);
        appToolbar.setSubtitle(R.string.subtitle);
        appToolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryText));
        appToolbar.setTitleTextAppearance(this, R.style.ToolBarTitleTextAppearance);
        appToolbar.setSubtitleTextAppearance(this, R.style.ToolBarSubTitleTextAppearance);

        ((Button)findViewById(R.id.btn_search)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uriString = "geo:";
                if (Character.isLetter(((EditText)findViewById(R.id.ed_adress)).getText().toString().toCharArray()[0])) {
                    uriString += "?q=" + ((EditText)findViewById(R.id.ed_adress)).getText().toString();
                } else {
                    uriString += ((EditText)findViewById(R.id.ed_adress)).getText().toString();
                }
                geoIntent = new Intent(Intent.ACTION_VIEW);
                geoIntent.setData(Uri.parse(uriString));
                startActivity(geoIntent);
            }
        });

    }
}