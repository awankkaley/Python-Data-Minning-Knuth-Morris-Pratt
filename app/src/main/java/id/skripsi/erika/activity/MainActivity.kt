package id.skripsi.erika.activity

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import id.skripsi.erika.R
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val handler = Handler()
        val r = Runnable {
            startActivity(intentFor<HomeActivity>())
            finish()
        }
        handler.postDelayed(r, 3000)

    }

}