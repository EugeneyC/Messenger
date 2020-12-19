package com.skrebtsov.eugeney.messenger.ui.fragmets

import androidx.fragment.app.Fragment
import com.google.firebase.auth.PhoneAuthProvider
import com.skrebtsov.eugeney.messenger.MainActivity
import com.skrebtsov.eugeney.messenger.R
import com.skrebtsov.eugeney.messenger.activities.RegisterActivity
import com.skrebtsov.eugeney.messenger.utilits.AUTH
import com.skrebtsov.eugeney.messenger.utilits.AppTextWatcher
import com.skrebtsov.eugeney.messenger.utilits.replaceActivity
import com.skrebtsov.eugeney.messenger.utilits.showToast
import kotlinx.android.synthetic.main.fragment_enter_code.*

class EnterCodeFragment(val phoneNumber: String, val id: String) :
    Fragment(R.layout.fragment_enter_code) {

    override fun onStart() {
        super.onStart()
        (activity as RegisterActivity).title = phoneNumber
        register_input_code.addTextChangedListener(AppTextWatcher {
            val string = register_input_code.text.toString()
            if (string.length == 6) {
                enterCode()
            }
        })
    }

    private fun enterCode() {
        val code = register_input_code.text.toString()
        val credential = PhoneAuthProvider.getCredential(id, code)
        AUTH.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                showToast("Добро пожаловать")
                (activity as RegisterActivity).replaceActivity(MainActivity())
            } else it.exception?.message.toString()
        }
    }
}