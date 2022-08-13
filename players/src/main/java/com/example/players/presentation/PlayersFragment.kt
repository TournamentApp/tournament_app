package com.example.players.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.players.R
import com.example.players.databinding.FragmentPlayersBinding


class PlayersFragment : Fragment() {
    private var _binding: FragmentPlayersBinding? = null
    private val binding: FragmentPlayersBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentPlayersBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root
}