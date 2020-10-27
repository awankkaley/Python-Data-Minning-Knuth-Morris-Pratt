package id.skripsi.erika.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.skripsi.erika.R
import id.skripsi.erika.UserPreference
import kotlinx.android.synthetic.main.activity_setup.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class SetupActivity : AppCompatActivity() {
    private lateinit var preference: UserPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup)
        preference = UserPreference(this)
        btn_selesai.onClick {
            var isEmptyField = false
            if (ed_field_ip.text!!.isEmpty()) {
                isEmptyField = true
                ed_field_ip.error = "Field Empty"
            }

            if (!isEmptyField) {
                preference.ip = ed_field_ip.text.toString()
                finish()
            }
        }

    }
}