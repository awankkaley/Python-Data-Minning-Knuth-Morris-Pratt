package id.skripsi.erika.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TanamanResponse(

	@field:SerializedName("msg")
	val msg: String? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: List<Tanaman?>,

	@field:SerializedName("key")
	val key: String? = null
) : Parcelable

@Parcelize
data class Tanaman(

	@field:SerializedName("nama_daerah")
	val namaDaerah: String? = null,

	@field:SerializedName("penyimpanan")
	val penyimpanan: String? = null,

	@field:SerializedName("nama_lain")
	val namaLain: String? = null,

	@field:SerializedName("zat_berkhasit")
	val zatBerkhasit: String? = null,

	@field:SerializedName("bagian_yang_digunakan")
	val bagianYangDigunakan: String? = null,

	@field:SerializedName("pemerian")
	val pemerian: String? = null,

	@field:SerializedName("sediaan")
	val sediaan: String? = null,

	@field:SerializedName("keluarga")
	val keluarga: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("penggunaan")
	val penggunaan: String? = null,

	@field:SerializedName("nama_latin")
	val namaLatin: String? = null,

	@field:SerializedName("id_tumbuhan")
	val idTumbuhan: Int? = null,

	@field:SerializedName("waktu_panen")
	val waktuPanen: String? = null
) : Parcelable
