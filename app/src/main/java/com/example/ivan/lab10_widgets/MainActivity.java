package com.example.ivan.lab10_widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class MainActivity extends AppWidgetProvider{
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        /* Old widget code
        for (int i = 0; i < appWidgetIds.length; i++) {
            int currentWidgetId = appWidgetIds[i];
            String url = "http://www.google.com";

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse(url));

            PendingIntent pending = PendingIntent.getActivity(context, 0, intent, 0);
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.activity_main);

            views.setOnClickPendingIntent(R.id.button, pending);
            appWidgetManager.updateAppWidget(currentWidgetId, views);
            Toast.makeText(context, "widget added", Toast.LENGTH_SHORT).show();
        }*/

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.activity_main);

        Intent configIntent = new Intent(context, LocationMain.class);
        PendingIntent configPendingIntent = PendingIntent.getActivity(context,0,configIntent,
                0);
        remoteViews.setOnClickPendingIntent(R.id.button, configPendingIntent);
        appWidgetManager.updateAppWidget(appWidgetIds,remoteViews);
    }




}
