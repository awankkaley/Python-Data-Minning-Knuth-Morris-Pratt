package id.skripsi.erika.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.skripsi.erika.R
import id.skripsi.erika.imageViewGlide
import id.skripsi.erika.model.Tanaman
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.activity_search.toolbar
import kotlinx.android.synthetic.main.item_list.*
import org.jetbrains.anko.toast

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val data = intent.getParcelableExtra<Tanaman>("tanaman")
        tv_nama_detail.text = data?.nama
        tv_nama_latin_detail.text = data?.namaLatin
        tv_nama_daerah_detail.text = data?.namaDaerah
        tv_nama_lain_detail.text = data?.namaLain
        tv_keluarga_detail.text = data?.keluarga
        tv_zat_detail.text = data?.zatBerkhasit
        tv_penggunaan_detail.text = data?.penggunaan
        tv_pemerian_detail.text = data?.pemerian
        tv_bagian_detail.text = data?.bagianYangDigunakan
        tv_sediaan_detail.text = data?.sediaan
        tv_waktu_detail.text = data?.waktuPanen
        tv_penyimpanan_detail.text = data?.penyimpanan
        image_tumbuhan_detail.imageViewGlide(this, data?.nama)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }
}