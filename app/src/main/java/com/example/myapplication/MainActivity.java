package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public class Products{
        List<String>getInfo(String group){
            List<String>info= new ArrayList<>();
            if (group.equals("Face Care")) {
                info.add("Suggested Products:");
                info.add("\nCleanser: \n   'CareVe Foaming Facial Cleanser' for oily skin.\n   'CareVe Hydrating Facial Cleanser' for dry skin.");
                info.add("\nMoisturizer: \n   'CareVe Daily Moisturizing Cream' for oily skin.\n   'CareVe Moisturizing Cream' for dry skin.");
                info.add("\nSunscreen: \n   'CareVe Hydrating Sunscreen with SPF30' for Summer.\n   'CareVe Hydrating Mineral Sunscreen with SPF50' for Winter.");
            }

            if (group.equals("Body Care")) {
                info.add("Suggested Products:");
                info.add("\nBody Wash: \n   'CareVe Soothing Body Wash' for oily skin.\n   'CareVe Hydrating Body wash' for dry skin.");
                info.add("\nBody Lotion: \n   'CareVe Daily Moisturizing Cream' for oily skin.\n   'CareVe SA Cream' for dry skin.");
                info.add("\nExfoliator: \n   'CareVe SA Smoothing Cleanser' for Rough & Bumpy Skin.\n   'CareVe SA Body Wash' for normal to oily skin.");
            }

            if (group.equals("Hair Care")) {
                info.add("Suggested Products:");
                info.add("\nHair Oil: \n   'WOW Onion Blackseed hair oil' for hair nourishment.\n   'WOW Castor Oil' for hair fall control.");
                info.add("\nShampoo: \n   'Olaplex No4 Shampoo' for all type hair.\n   'Olaplex No4P Shampoo' for coloured hair.");
                info.add("\nConditioner: \n   'Olaplex No5 Conditioner' for all type hair.\n   'Olaplex No5P Conditioner' for coloured hair.");
            }

            return info;
        }
    }
    private Products expert= new Products();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onClickFindInfo(View view){
        TextView info =(TextView)  findViewById(R.id.text);
        TextView info2 =(TextView)  findViewById(R.id.infoss);
        Spinner dis = (Spinner) findViewById(R.id.spinner);
        String type=String.valueOf(dis.getSelectedItem());
        List<String>infoList =expert.getInfo(type);
        StringBuilder infoFormatted = new StringBuilder();
        for(String inf : infoList)
        {
            infoFormatted.append(inf).append('\n');
        }
        info2.setText("Suggestions");
        info.setText(infoFormatted);
    }
}