package id.skripsi.erika

data class Kategori (
    val code: Int? = null,
    val title: String? = null
){
    override fun toString(): String {
        return title.toString()
    }
}