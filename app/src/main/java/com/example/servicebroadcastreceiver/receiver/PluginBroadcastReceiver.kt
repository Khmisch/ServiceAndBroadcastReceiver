package com.example.servicebroadcastreceiver.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.widget.Toast


class PluginBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // isCharging if true indicates charging is ongoing and vice-versa
        val status: Int = intent?.getIntExtra(BatteryManager.EXTRA_STATUS, -1) ?: -1
        val isCharging: Boolean = status == BatteryManager.BATTERY_STATUS_CHARGING
                || status == BatteryManager.BATTERY_STATUS_FULL
        // Display whatever the state in the form of a Toast
        if (isCharging) {
            Toast.makeText(context, "Charging", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Not Charging", Toast.LENGTH_LONG).show()
        }
    }
}