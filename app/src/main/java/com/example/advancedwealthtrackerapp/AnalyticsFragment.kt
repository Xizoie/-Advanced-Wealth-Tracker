package com.example.advancedwealthtracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.advancedwealthtrackerapp.R

class AnalyticsFragment : Fragment() {

    private lateinit var gk_li_tv_result: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.gk_li_fragment_analytics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gk_li_tv_result = view.findViewById(R.id.gk_li_tv_result)

        // ✅ Using parentFragmentManager.setFragmentResultListener
        parentFragmentManager.setFragmentResultListener("savingsResult", viewLifecycleOwner) { _, bundle ->
            val savings = bundle.getDouble("finalSavings", 0.0)
            gk_li_tv_result.text = "დაზოგვა: $savings"
        }
    }
}