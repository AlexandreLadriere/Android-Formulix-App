package com.alexandreladriere.f1companion

import android.app.AlarmManager
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.util.Log
import android.widget.RemoteViews
import android.widget.Toast


/**
 * Implementation of App Widget functionality.
 */
class CalendarMediumWidget : AppWidgetProvider() {

    private var service: PendingIntent? = null

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        val manager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val i = Intent(context, CalendarService::class.java)

        if (service == null) {
            service = PendingIntent.getService(context, 0, i, PendingIntent.FLAG_CANCEL_CURRENT)
        }
        manager.setRepeating(
            AlarmManager.ELAPSED_REALTIME,
            SystemClock.elapsedRealtime(),
            3600000,
            service
        )
        Log.d("UpdatingWidget: ","onUpdate");
        // There may be multiple widgets active, so update all of them
        // for (appWidgetId in appWidgetIds) {
        //     updateAppWidget(context, appWidgetManager, appWidgetId)
        // }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    Toast.makeText(context, CURRENT_SEASON_ENDPOINT, Toast.LENGTH_LONG).show()
    val widgetText = context.getString(R.string.appwidget_text)
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.calendar_medium_widget)
    views.setTextViewText(R.id.appwidget_text, widgetText)

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}