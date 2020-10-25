package com.skrebtsov.eugeney.messenger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.skrebtsov.eugeney.messenger.databinding.ActivityMainBinding
import com.skrebtsov.eugeney.messenger.ui.fragmets.ChatsFragment
import com.skrebtsov.eugeney.messenger.ui.objects.AppDrawer

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAppDrawer: AppDrawer
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        setSupportActionBar(mToolbar)
        mAppDrawer.create()
        supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer, ChatsFragment()).commit()

    }


    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)
    }
}