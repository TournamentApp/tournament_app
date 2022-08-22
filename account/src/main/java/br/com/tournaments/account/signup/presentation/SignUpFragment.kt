package br.com.tournaments.account.signup.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import br.com.tournaments.account.BaseFragment

class SignUpFragment: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View {
        return ComposeView(requireContext()).apply {
            setContent {
                SignUpScreen(
                    delegate = signUpDelegate()
                )
            }
        }
    }

    private fun signUpDelegate() = object : SignUpDelegate {
        override fun navToSignIn() {
            val action = SignUpFragmentDirections.navToSignIn()
            controller.navigate(action)
        }
    }
}