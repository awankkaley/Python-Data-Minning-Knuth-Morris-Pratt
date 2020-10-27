package id.skripsi.erika.activity.search

import android.annotation.SuppressLint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import id.skripsi.erika.R
import id.skripsi.erika.activity.DetailActivity
import id.skripsi.erika.adapter.SearchAdapter
import id.skripsi.erika.gone
import id.skripsi.erika.model.Tanaman
import id.skripsi.erika.visible
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.activity_search.toolbar
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.onRefresh
import java.util.ArrayList

class SearchActivity : AppCompatActivity(),
    SearchView, SearchAdapter.Listener {
    private var tanaman: MutableList<Tanaman?> = mutableListOf()
    private lateinit var presenter: SearchPresenter
    private lateinit var adapter: SearchAdapter
    private var key: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter = SearchPresenter(this, this)
        presenter.getAll()
//        swipe_refresh_search.onRefresh {
//            presenter.getTanaman(query = key, kategory = "1")
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchMenu = menu?.findItem(R.id.searchMenu)
        val searchView = searchMenu?.actionView as androidx.appcompat.widget.SearchView
        val typeFace: Typeface? = ResourcesCompat.getFont(this.applicationContext, R.font.roboto)
        val searchAutoComplete: androidx.appcompat.widget.SearchView.SearchAutoComplete =
            searchView.findViewById(androidx.appcompat.R.id.search_src_text) as androidx.appcompat.widget.SearchView.SearchAutoComplete
        searchView.setIconifiedByDefault(false);
        searchAutoComplete.typeface = typeFace
        searchView.queryHint = getString(R.string.cari_tanaman)
        searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                tv_result.text = "Loading.."
                tv_keyword.text = "Loading.."
                key = query
                presenter.getTanaman(query = query, kategory = "1")
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }

    @SuppressLint("SetTextI18n")
    override fun onSuccess(data: List<Tanaman?>, key: String?, result: String?) {
        tanaman.clear()
        tanaman.addAll(data)
        adapter = SearchAdapter(this, data, this)
        rv_search.layoutManager = LinearLayoutManager(this)
        rv_search.adapter = adapter
        adapter.notifyDataSetChanged()
        val rex = Regex("[^A-Za-z0-9 ]")

        var keys = key
        if (key == null) {
            keys = "0.00001"
        }
        tv_keyword.text = "Durasi : $keys Detik "
        tv_result.text = "Result : $result Data"
    }

    override fun onFailed(t: String?) {
        alert(t.toString(), "Perhatian") {
            yesButton {
                finish()
            }
            noButton {}
        }.show()
    }

    override fun showProgress() {
        rv_search.gone()
        layout_progress_search.visible()
    }

    override fun hideProgress() {
        rv_search.visible()
        layout_progress_search.gone()
    }

    override fun onItemClicked(data: Tanaman?) {
        startActivity(intentFor<DetailActivity>(Pair("tanaman", data)))
    }

    override fun onDetailClicked(data: Tanaman?) {
        val dialogBuilder =
            AlertDialog.Builder(this, R.style.Base_Theme_MaterialComponents_Light_Dialog_Alert)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.activity_detail, null)
        dialogBuilder.setView(dialogView)
        val alertDialog = dialogBuilder.create()
        dialogView.image_tumbuhan_detail.gone()
        dialogView.toolbar.gone()
        dialogView.tv_nama_detail.text = data?.nama
        dialogView.tv_nama_latin_detail.text = data?.namaLatin
        dialogView.tv_nama_daerah_detail.text = data?.namaDaerah
        dialogView.tv_nama_lain_detail.text = data?.namaLain
        dialogView.tv_keluarga_detail.text = data?.keluarga
        dialogView.tv_zat_detail.text = data?.zatBerkhasit
        dialogView.tv_penggunaan_detail.text = data?.penggunaan
        dialogView.tv_pemerian_detail.text = data?.pemerian
        dialogView.tv_bagian_detail.text = data?.bagianYangDigunakan
        dialogView.tv_sediaan_detail.text = data?.sediaan
        dialogView.tv_waktu_detail.text = data?.waktuPanen
        dialogView.tv_penyimpanan_detail.text = data?.penyimpanan
        alertDialog.show()
    }
}