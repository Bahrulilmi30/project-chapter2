package com.catnip.homepemesananmakanan.presentation.presentation.fragmenthome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.catnip.homepemesananmakanan.databinding.FragmentHomeBinding
import com.catnip.homepemesananmakanan.presentation.data.ItemMenuMakanan
import com.catnip.homepemesananmakanan.presentation.data.ItemMenuMakananImpl
import com.catnip.homepemesananmakanan.presentation.model.Item
import com.catnip.homepemesananmakanan.presentation.presentation.fragmenthome.adapter.LayoutMode
import com.catnip.homepemesananmakanan.presentation.presentation.fragmenthome.adapter.MenuItemAdapter

class FragmentHome : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val datasource : ItemMenuMakanan by lazy {
        ItemMenuMakananImpl()
    }
    private  val adapter : MenuItemAdapter by lazy {
        MenuItemAdapter(LayoutMode.GRID){ item: Item ->
            navigateToDetail(item)
        }
    }

    private fun navigateToDetail(item: Item) {
        findNavController().navigate(
            FragmentHomeDirections.actionFragmentHomeToFragmentDetails(item)
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
        setupSwitch()
    }

    private fun setupList() {
        val span = if (adapter.adapterlayoutMode == LayoutMode.GRID)2 else 1
        binding.inclMainMenu.rvMenu.apply {
            layoutManager = GridLayoutManager(requireContext(),span)
            adapter = this@FragmentHome.adapter
        }
        adapter.submitData(datasource.getMenus())
    }

    private fun setupSwitch() {
        binding.inclMainMenu.switchListGrid.setOnCheckedChangeListener { _, isChecked ->
            (binding.inclMainMenu.rvMenu.layoutManager as GridLayoutManager).spanCount =
                if (isChecked) 1 else 2
            adapter.adapterlayoutMode =
                if (isChecked) LayoutMode.LINEAR else LayoutMode.GRID
            adapter.refreshlist()
        }
    }
}
