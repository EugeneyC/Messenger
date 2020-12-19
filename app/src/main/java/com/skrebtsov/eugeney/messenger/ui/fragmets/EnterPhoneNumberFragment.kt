package com.skrebtsov.eugeney.messenger.ui.fragmets

import androidx.fragment.app.Fragment
import com.skrebtsov.eugeney.messenger.R
import com.skrebtsov.eugeney.messenger.utilits.replaceFragment
import com.skrebtsov.eugeney.messenger.utilits.showToast
import kotlinx.android.synthetic.main.fragment_enter_phone_number.*

class EnterPhoneNumberFragment : Fragment(R.layout.fragment_enter_phone_number) {
    override fun onStart() {
        super.onStart()
        register_btn_next.setOnClickListener { sendCode() }
    }

    private fun sendCode() {
        if (register_input_phone_number.text.toString().isEmpty()) {
            showToast(getString(R.string.register_toast_phone_number))
        } else {
            replaceFragment(EnterCodeFragment())
        }
    }
}