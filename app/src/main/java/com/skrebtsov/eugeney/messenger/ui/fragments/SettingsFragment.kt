package com.skrebtsov.eugeney.messenger.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.skrebtsov.eugeney.messenger.MainActivity
import com.skrebtsov.eugeney.messenger.R
import com.skrebtsov.eugeney.messenger.activities.RegisterActivity
import com.skrebtsov.eugeney.messenger.utilits.AUTH
import com.skrebtsov.eugeney.messenger.utilits.USER
import com.skrebtsov.eugeney.messenger.utilits.replaceActivity
import com.skrebtsov.eugeney.messenger.utilits.replaceFragment
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
        initFileds()
    }

    private fun initFileds() {
        settings_bio.text = USER.bio
        settings_full_name.text = USER.fullname
        settings_status.text = USER.status
        settings_username.text = USER.username
        settings_phone_number.text = USER.phone
        settings_btn_change_username.setOnClickListener {
            replaceFragment(ChangeUsernameFragment())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.settings_menu_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
            R.id.setting_menu_change_name -> {
                (activity as MainActivity).replaceFragment(ChangeNameFragment())
            }
        }
        return true
    }
}