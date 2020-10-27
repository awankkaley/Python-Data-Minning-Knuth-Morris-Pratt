package id.skripsi.erika.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.skripsi.erika.R
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.activity_tentang.*

class TentangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tentang)
        setSupportActionBar(toolbar_tentang)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }
}