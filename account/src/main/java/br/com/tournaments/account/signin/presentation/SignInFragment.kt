package br.com.tournaments.account.signin.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import br.com.tournaments.account.BaseFragment

class SignInFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View {
        return ComposeView(requireContext()).apply {
            setContent {
                SignInScreen(
                    delegate = signInDelegate()
                )
            }
        }
    }

    private fun signInDelegate() = object : SignInDelegate {
        override fun navToSignUp() {
            val action = SignInFragmentDirections.navToSignUp()
            controller.navigate(action)
        }
    }
}
