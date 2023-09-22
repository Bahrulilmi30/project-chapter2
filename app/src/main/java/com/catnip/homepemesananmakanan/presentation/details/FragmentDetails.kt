package com.catnip.homepemesananmakanan.presentation.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.catnip.homepemesananmakanan.R
import com.catnip.homepemesananmakanan.databinding.FragmentDetailsBinding
import com.catnip.homepemesananmakanan.databinding.FragmentHomeBinding
import com.catnip.homepemesananmakanan.presentation.model.Item


class FragmentDetails : Fragment() {
    private lateinit var binding : FragmentDetailsBinding
    private val item : Item? by lazy {
        FragmentDetailsArgs.fromBundle(arguments as Bundle).item
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showMenuData()
        navigateToGoogle()

    }
    private fun navigateToGoogle() {
        val locationUrl = item?.locationUrlFood
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(locationUrl))
        startActivity(intent)

    }
    private fun showMenuData() {
        item?.let { p ->
            binding.apply {
                ivPictMenu.load(p.imgUrl) {
                    crossfade(true)
                }
                tvTextMenu.text = p.name
                tvHargaMenu.text = p.harga
                tvTotalHarga.text = p.harga
                tvDescMenu.text = p.desc
                }
            }
        }

    }
