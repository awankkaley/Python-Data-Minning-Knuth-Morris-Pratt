package id.skripsi.erika.activity.search

import id.skripsi.erika.model.Tanaman

interface SearchView {
    fun onSuccess(data: List<Tanaman?>,key:String?,result:String?)
    fun onFailed(t: String?)
    fun showProgress()
    fun hideProgress()
}