package com.skrebtsov.eugeney.messenger.ui.fragmets

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.skrebtsov.eugeney.messenger.MainActivity
import com.skrebtsov.eugeney.messenger.R
import com.skrebtsov.eugeney.messenger.activities.RegisterActivity
import com.skrebtsov.eugeney.messenger.utilits.AUTH
import com.skrebtsov.eugeney.messenger.utilits.replaceActivity
import com.skrebtsov.eugeney.messenger.utilits.replaceFragment

class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
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