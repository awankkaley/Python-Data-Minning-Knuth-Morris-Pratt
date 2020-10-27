package id.skripsi.erika.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.skripsi.erika.R
import id.skripsi.erika.gone
import id.skripsi.erika.imageViewGlide
import id.skripsi.erika.model.Tanaman
import id.skripsi.erika.visible
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class SearchAdapter(
    private val context: Context,
    private val data: List<Tanaman?>,
    private val listener: Listener
) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    interface Listener {
        fun onItemClicked(data: Tanaman?)
        fun onDetailClicked(data: Tanaman?)
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(
                context
            ).inflate(R.layout.item_list, parent, false)
        )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(data[position], context)
        holder.itemView.onClick {
            listener.onItemClicked(data[position])
        }
        holder.itemView.button.onClick {
            listener.onDetailClicked(data[position])
        }
//        holder.itemView.button.onClick {
//            holder.itemView.button2.visible()
//            holder.itemView.tv_keluarga.visible()
//            holder.itemView.title_keluarga.visible()
//            holder.itemView.tv_penggunaan.visible()
//            holder.itemView.tv_keluarga.visible()
//            holder.itemView.title_penggunaan.visible()
//            holder.itemView.tv_zat.visible()
//            holder.itemView.title_zat.visible()
//            holder.itemView.tv_pemerian.visible()
//            holder.itemView.title_pemerian.visible()
//            holder.itemView.tv_waktu.visible()
//            holder.itemView.title_waktu_panen.visible()
//            holder.itemView.button.gone()
//        }
//        holder.itemView.button2.onClick {
//            holder.itemView.button2.gone()
//            holder.itemView.tv_keluarga.gone()
//            holder.itemView.title_keluarga.gone()
//            holder.itemView.tv_penggunaan.gone()
//            holder.itemView.tv_keluarga.gone()
//            holder.itemView.title_penggunaan.gone()
//            holder.itemView.tv_pemerian.gone()
//            holder.itemView.title_pemerian.gone()
//            holder.itemView.tv_zat.gone()
//            holder.itemView.title_zat.gone()
//            holder.itemView.tv_waktu.gone()
//            holder.itemView.title_waktu_panen.gone()
//            holder.itemView.button.visible()
//        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(data: Tanaman?, context: Context) {
            itemView.tv_nama.text = data?.nama
            itemView.tv_nama_latin.text = data?.namaLatin
            itemView.tv_keluarga.text = data?.keluarga
            itemView.tv_penggunaan.text = data?.penggunaan
            itemView.tv_pemerian.text = data?.pemerian
            itemView.tv_zat.text = data?.zatBerkhasit
            itemView.tv_waktu.text = data?.waktuPanen
            itemView.imageView.imageViewGlide(context, data?.nama)
        }
    }
}