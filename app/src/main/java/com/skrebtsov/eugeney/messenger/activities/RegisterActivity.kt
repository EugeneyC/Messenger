package com.skrebtsov.eugeney.messenger.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.skrebtsov.eugeney.messenger.R
import com.skrebtsov.eugeney.messenger.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}