package br.com.tournaments.search.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

@ExperimentalMaterialApi
class SearchFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View {
        return ComposeView(requireContext()).apply {
            setContent {
                SearchScreen(searchDelegate())
            }
        }
    }

    private fun searchDelegate() = object : SearchDelegate {
        override fun navToTeams() {
            findNavController().navigate(SearchFragmentDirections.searchToTeams())
        }

        override fun navToPlayers() {
            findNavController().navigate(SearchFragmentDirections.searchToPlayers())
        }

    }
}