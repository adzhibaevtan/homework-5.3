package com.pixabay.homework_53.ui.fragment.search

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.pixabay.homework_53.R
import com.pixabay.homework_53.data.model.PixaModel
import com.pixabay.homework_53.databinding.FragmentSearchBinding
import com.pixabay.homework_53.remote.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment(R.layout.fragment_search) {
    private val binding by viewBinding(FragmentSearchBinding::bind)
    var adapter = SearchAdapter(listOf())
    var page = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            searchBtn.setOnClickListener {
                page = 1
                search()
            }

            updateBtn.setOnClickListener {
                page++
                search()
            }
        }
    }

    private fun FragmentSearchBinding.search() {
        RetrofitService().api.searchImage(keyWord = searchEt.text.toString(), page = page)
            .enqueue(object : Callback<PixaModel> {
                override fun onResponse(
                    call: Call<PixaModel>,
                    response: Response<PixaModel>
                ) {
                    response.body()?.hits?.let {
                        adapter = SearchAdapter(it)
                        binding.recycler.adapter = this@SearchFragment.adapter
                    }
                    Log.e(
                        "check",
                        "onResponse: ${response.body()?.hits!![0].largeImageURL}",
                    )
                }

                override fun onFailure(call: Call<PixaModel>, t: Throwable) {
                    Log.e("check", "onFailure: ${t.message}")
                }
            })
    }
}
