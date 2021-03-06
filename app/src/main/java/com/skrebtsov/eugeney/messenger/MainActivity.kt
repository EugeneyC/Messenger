package com.skrebtsov.eugeney.messenger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.skrebtsov.eugeney.messenger.activities.RegisterActivity
import com.skrebtsov.eugeney.messenger.databinding.ActivityMainBinding
import com.skrebtsov.eugeney.messenger.models.User
import com.skrebtsov.eugeney.messenger.ui.fragments.ChatsFragment
import com.skrebtsov.eugeney.messenger.ui.objects.AppDrawer
import com.skrebtsov.eugeney.messenger.utilits.*

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    lateinit var mAppDrawer: AppDrawer
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
        if (AUTH.currentUser != null) {
            setSupportActionBar(mToolbar)
            mAppDrawer.create()
            replaceFragment(ChatsFragment(), false)
        } else {
            replaceActivity(RegisterActivity())
        }
    }


    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)
        initFareBase()
        initUser()
    }

    private fun initUser() {
        REF_DATABASE_ROOT.child(NODE_USERS).child(UID)
            .addListenerForSingleValueEvent( AppValueEventListener {
                USER = it.getValue(User::class.java) ?: User()
            })
    }
}