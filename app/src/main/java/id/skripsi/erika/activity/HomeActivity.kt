package id.skripsi.erika.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.tiper.MaterialSpinner
import id.skripsi.erika.Kategori
import id.skripsi.erika.R
import id.skripsi.erika.activity.search.SearchActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.sdk27.coroutines.onLongClick
import org.jetbrains.anko.toast

class HomeActivity : AppCompatActivity() {
    private var kategori: Kategori? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        btn_tentang.onClick {
            startActivity(intentFor<TentangActivity>())
        }
        btn_search.onClick {
            startActivity(intentFor<SearchActivity>())
        }
//        imageView3.onLongClick {
//            startActivity(intentFor<SetupActivity>())
//        }
    }

}