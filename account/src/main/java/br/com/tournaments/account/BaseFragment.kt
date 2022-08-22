package br.com.tournaments.account

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class BaseFragment: Fragment(){

    protected val controller by lazy { findNavController() }

    protected fun onBackPressed() {
        controller.popBackStack()
    }
}