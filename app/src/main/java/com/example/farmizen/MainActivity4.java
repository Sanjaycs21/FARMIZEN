package com.example.farmizen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity {

    private ImageView shop;
    private ImageView news;
    private ImageView waterservice;
    private ImageView loan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        shop=findViewById(R.id.store);
        news=findViewById(R.id.news);
        loan=findViewById(R.id.loan);
        waterservice=findViewById(R.id.waterservice);
        shop.setOnClickListener(view -> {
            startActivity(new Intent(this,MainActivity5.class));
        });
        news.setOnClickListener(view -> {
            AlertDialog alert=new AlertDialog.Builder(this)
                    .setTitle("Latest News")
                    .setMessage("India may face a rice shortage following a similar wheat crisis earlier this year. Depleting stocks of wheat and paddy has raised concerns about the Kharif paddy procurement despite constant reassurances by the government.\n" +
                            "\n" +
                            "The central stockpile has 44.1 million tonnes of food grains September 30, 2022 — 20.9 million tonnes of rice and 23.2 million tonnes of wheat, according to the Union Ministry of Consumer Affairs, Food and Public Distribution. \n" +
                            "\n" +
                            "The stock was 49.28 million tonnes before September 1, 2022, with 27.95 million tonnes of rice and 24.82 million tonnes of wheat. \n" +
                            "\n" +
                            "The depleting food grain stock has raised concerns, despite continuous reassurances by the central government of enough stock available to meet India’s food grain demands. \n" +
                            "\n" +
                            "The numbers show grain stock is depleting at a worrying rate. There were 55.16 million tonnes of food grains in store January 2022. The Centre had 78.61 million tonnes of grains on September 1, 2021 in comparison, with 26.83 million tonnes rice and 51.78 million tonnes of wheat.")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .create();
            alert.show();
        });
        waterservice.setOnClickListener(view -> {
            AlertDialog alert=new AlertDialog.Builder(this)
                    .setTitle("IRRIGATIONS")
                    .setMessage("The main types of irrigation followed by farmers include:\n" +
                            "\n" +
                            "Surface Irrigation\n" +
                            "In this system, no irrigation pump is involved. Here, water is distributed across the land by gravity.\n" +
                            "\n" +
                            "Localized Irrigation\n" +
                            "In this system, water is applied to each plant through a network of pipes under low pressure.\n" +
                            "\n" +
                            "Sprinkler Irrigation\n" +
                            "Water is distributed from a central location by overhead high-pressure sprinklers or from sprinklers from the moving platform.\n" +
                            "\n" +
                            "Drip Irrigation\n" +
                            "In this type, drops of water are delivered near the roots of the plants. This type of irrigation is rarely used as it requires more maintenance.\n" +
                            "\n" +
                            "Centre Pivot Irrigation\n" +
                            "In this, the water is distributed by a sprinkler system moving in a circular pattern.\n" +
                            "\n" +
                            "Sub Irrigation\n" +
                            "Water is distributed through a system of pumping stations gates, ditches and canals by raising the water table.\n" +
                            "\n" +
                            "Manual Irrigation\n" +
                            "This a labour intensive and time-consuming system of irrigation. Here, the water is distributed through watering cans by manual labour.")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .create();
            alert.show();
        });

        loan.setOnClickListener(view -> {
            AlertDialog alert=new AlertDialog.Builder(this)
                    .setTitle("AGRICULTURE LOAN")
                    .setMessage("Agriculture loan\n" +
                            "Agricultural loans are availed by a farmer to fund seasonal agricultural operations or related activities like animal farming, pisci-culture or purchase of land or agricultural tools. This type of loan also helps buying inputs such as fertilizers, seeds, insecticides etc.")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .create();
            alert.show();
        });

    }
}