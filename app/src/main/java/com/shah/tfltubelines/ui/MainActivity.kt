package com.shah.tfltubelines.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shah.tfltubelines.R
import com.shah.tfltubelines.adapters.TubeLinesStatusesAdapter
import com.shah.tfltubelines.databinding.ActivityMainBinding
import com.shah.tfltubelines.model.TubeLineStatus
import com.shah.tfltubelines.util.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel : MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)

        updateUI()

        setContentView(binding.root)
    }

    private fun updateUI() {
        viewModel.tubeLineStatuses.observe(this@MainActivity) { state ->
            when(state) {
                is UiState.Loading -> {
                    Log.i("API Response: ", "LOADING")
                }
                is UiState.Success -> {
                    if (!state.tubeLineStatusResponse.isEmpty()) {
                        binding.recyclerView.adapter = TubeLinesStatusesAdapter(state.tubeLineStatusResponse)
                    } else {
                        Toast.makeText(this@MainActivity, "Sorry, no results found", Toast.LENGTH_SHORT).show()
                    }
                }
                is UiState.Error -> {
                    Log.i("API Response: ", "Error -> ${state.error}")
                }
            }
        }
    }
}