package com.example.advancedwealthtracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import com.example.advancedwealthtrackerapp.R

class InputFragment : Fragment() {

    private lateinit var gk_li_et_income: EditText
    private lateinit var gk_li_et_expenses: EditText
    private lateinit var gk_li_btn_save: Button

    private val wealthManager = WealthManager("Giorgi", "Khizanashvili", 28)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.gk_li_fragment_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gk_li_et_income = view.findViewById(R.id.gk_li_et_income)
        gk_li_et_expenses = view.findViewById(R.id.gk_li_et_expenses)
        gk_li_btn_save = view.findViewById(R.id.gk_li_btn_save)

        gk_li_et_income.doAfterTextChanged {
            if (it.isNullOrEmpty()) gk_li_et_income.error = "შეიყვანეთ შემოსავალი"
        }
        gk_li_et_expenses.doAfterTextChanged {
            if (it.isNullOrEmpty()) gk_li_et_expenses.error = "შეიყვანეთ ხარჯები"
        }

        gk_li_btn_save.setOnClickListener {
            val incomeText = gk_li_et_income.text.toString()
            val expensesText = gk_li_et_expenses.text.toString()

            if (incomeText.isEmpty()) {
                gk_li_et_income.error = "შეიყვანეთ შემოსავალი"
                return@setOnClickListener
            }
            if (expensesText.isEmpty()) {
                gk_li_et_expenses.error = "შეიყვანეთ ხარჯები"
                return@setOnClickListener
            }

            val income = incomeText.toDoubleOrNull()
            val expenses = expensesText.toDoubleOrNull()

            if (income == null) {
                gk_li_et_income.error = "არასწორი რიცხვი"
                return@setOnClickListener
            }
            if (expenses == null) {
                gk_li_et_expenses.error = "არასწორი რიცხვი"
                return@setOnClickListener
            }

            val finalSavings = wealthManager.calculateFinalSavings(income, expenses)

            val bundle = Bundle().apply {
                putDouble("finalSavings", finalSavings)
            }
            // ✅ Using parentFragmentManager instead of setFragmentResult directly
            parentFragmentManager.setFragmentResult("savingsResult", bundle)
        }
    }
}