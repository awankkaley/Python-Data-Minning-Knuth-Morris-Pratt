package id.skripsi.erika

import android.content.Context
import android.preference.PreferenceManager
import kotlin.math.PI

class UserPreference(context: Context?) {
    companion object {
        private const val IP = "ip"

    }

    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    var ip = preferences.getString(IP, "")
        set(value) = preferences.edit().putString(IP, value).apply()


    fun deleteData() {
        val editor = preferences.edit().clear()
        editor.apply()
    }
}