package com.example.android.erasmuslife;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Display the icon in the ActionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);
        MainActivity.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MainActivity.context;
    }

    public void showToursInfos(View view) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle(R.string.dialog_infos_title);
        dialogBuilder.setMessage(R.string.dialog_infos_messages);

        dialogBuilder.setPositiveButton(
                R.string.open_maps,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        showMap(Uri.parse("geo:47.3942462,0.6849003?z=12"));
                    }
                });

        AlertDialog dialogInfos = dialogBuilder.create();
        dialogInfos.show();
    }

    public void showUniversityInfos(View view) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle(R.string.dialog_studying_title);
        dialogBuilder.setMessage(R.string.dialog_studying_message);

        dialogBuilder.setPositiveButton(
                R.string.learn_more,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        openWebPage("http://www.univ-tours.fr");
                    }
                });

        AlertDialog dialogInfos = dialogBuilder.create();
        dialogInfos.show();
    }

    public void showTramway(View view) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle(R.string.dialog_tramway_title);
        dialogBuilder.setMessage(R.string.dialog_tramway_message);

        dialogBuilder.setPositiveButton(
                R.string.learn_more,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        openWebPage("https://www.filbleu.fr");
                    }
                });

        AlertDialog dialogInfos = dialogBuilder.create();
        dialogInfos.show();
    }

    public void showUrgenceServices(View view) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle(R.string.dialog_numbers_title);
        dialogBuilder.setMessage(R.string.dialog_numbers_message);

        dialogBuilder.setPositiveButton(
                R.string.learn_more,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //define a new Intent for the second Activity
                        Intent intent = new Intent(MainActivity.context, SecondActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        //start the second Activity
                        MainActivity.context.startActivity(intent);
                    }
                });

        AlertDialog dialogInfos = dialogBuilder.create();
        dialogInfos.show();
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openPhone(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri number = Uri.parse("tel:" + phoneNumber);
        intent.setData(number);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
