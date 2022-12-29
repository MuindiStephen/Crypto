package com.steve_md.crypto_app.presentation.fragments.splash

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.steve_md.crypto_app.R
import com.steve_md.crypto_app.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    // Safest way TODO ViewBinding
private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed(
            {
            navigateToCoinListFragment()
        }, 2500)
    }

    private fun navigateToCoinListFragment() {
        findNavController().navigate(R.id.action_splashFragment_to_coinListFragment)
    }


}