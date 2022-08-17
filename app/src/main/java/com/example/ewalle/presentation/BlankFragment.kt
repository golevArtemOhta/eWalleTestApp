package com.example.ewalle.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ewalle.databinding.FragmentBlankBinding


class BlankFragment(nameFragment: String) : Fragment() {
    lateinit var binding: FragmentBlankBinding
    val name = nameFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView.text = name
    }

    companion object {
        @JvmStatic
        fun newInstance(nameFragment: String) = BlankFragment(nameFragment)
    }
}