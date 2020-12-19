package com.skrebtsov.eugeney.messenger.ui.fragmets

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.skrebtsov.eugeney.messenger.R
import com.skrebtsov.eugeney.messenger.utilits.AppTextWatcher
import com.skrebtsov.eugeney.messenger.utilits.showToast
import kotlinx.android.synthetic.main.fragment_enter_code.*

class EnterCodeFragment : Fragment(R.layout.fragment_enter_code) {
    override fun onStart() {
        super.onStart()
        register_input_code.addTextChangedListener(AppTextWatcher {
            val string = register_input_code.text.toString()
            if (string.length == 6) {
                verifiCode()
            }
        })
    }
    private fun verifiCode() {
        showToast("OK")
    }
}