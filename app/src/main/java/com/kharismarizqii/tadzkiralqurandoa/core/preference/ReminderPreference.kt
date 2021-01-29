package com.kharismarizqii.tadzkiralqurandoa.core.preference

import android.content.Context
import com.kharismarizqii.tadzkiralqurandoa.domain.model.Reminder

class ReminderPreference(context: Context) {
    companion object{
        const val PREFS_NAME = "reminder_pref"
        private const val REMINDER = "isRemind"
    }

    private val preference = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setReminder(value: Reminder){
        val editor = preference.edit()
        editor.putBoolean(REMINDER, value.isReminded)
        editor.apply()
    }

    fun getReminder(): Reminder{
        val model = Reminder()
        model.isReminded = preference.getBoolean(REMINDER, false)
        return model
    }
}