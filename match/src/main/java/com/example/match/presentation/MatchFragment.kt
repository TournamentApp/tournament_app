package com.example.match.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.match.R
import com.example.match.databinding.FragmentMatchBinding

class MatchFragment : Fragment() {

    private var _binding: FragmentMatchBinding? = null
    private val binding: FragmentMatchBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMatchBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root
}