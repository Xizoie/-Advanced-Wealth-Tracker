package com.example.advancedwealthtracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.advancedwealthtrackerapp.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.gk_li_fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val wealthManager = WealthManager("Giorgi", "Khizanashvili", 28)
        val gk_li_tv_k: TextView = view.findViewById(R.id.gk_li_tv_k)
        gk_li_tv_k.text = "K კოეფიციენტი: ${String.format("%.4f", wealthManager.k)}"
    }
}