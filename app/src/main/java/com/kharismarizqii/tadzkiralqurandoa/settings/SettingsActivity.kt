package com.kharismarizqii.tadzkiralqurandoa.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kharismarizqii.tadzkiralqurandoa.core.preference.ReminderPreference
import com.kharismarizqii.tadzkiralqurandoa.core.receiver.AlarmReceiver
import com.kharismarizqii.tadzkiralqurandoa.databinding.ActivitySettingsBinding
import com.kharismarizqii.tadzkiralqurandoa.domain.model.Reminder

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    private lateinit var reminder: Reminder
    private lateinit var alarmReceiver: AlarmReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val reminderPreference = ReminderPreference(this)
        if (reminderPreference.getReminder().isReminded){
            binding.switch1.isChecked = true
        } else {
            binding.switch1.isChecked = false
        }

        alarmReceiver = AlarmReceiver()

        binding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                saveReminder(true)
                alarmReceiver.setRepeatingAlarm(this, "RepeatingAlarm","20:38", "Ayat reminder")
            }else{
                saveReminder(false)
                alarmReceiver.cancelAlarm(this)
            }
        }
    }

    private fun saveReminder(state: Boolean) {
        val reminderPreference = ReminderPreference(this)
        reminder = Reminder()

        reminder.isReminded = state
        reminderPreference.setReminder(reminder)
    }
}