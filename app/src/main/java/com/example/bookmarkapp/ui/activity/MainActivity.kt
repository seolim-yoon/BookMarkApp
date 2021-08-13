package com.example.bookmarkapp.ui.activity

import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.bookmarkapp.R
import com.example.bookmarkapp.base.BaseActivity
import com.example.bookmarkapp.databinding.ActivityMainBinding
import com.example.bookmarkapp.ui.fragment.home.HomeViewModel
import org.jetbrains.anko.toast
import kotlin.reflect.KClass

class MainActivity : BaseActivity<ActivityMainBinding, HomeViewModel>() {
    override val layoutResID: Int
        get() = R.layout.activity_main
    override val viewModelClass: KClass<HomeViewModel>
        get() = HomeViewModel::class

    private val TIME_INTERVAL = 2000
    private var backKeyPressedTime = 0L

    override fun initView() {
        val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        viewDataBinding.bnMenu.setupWithNavController(navHostFragment.navController)

        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.homeFragment || destination.id == R.id.bookMarkFragment)
                viewDataBinding.bnMenu.visibility = View.VISIBLE
            else
                viewDataBinding.bnMenu.visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + TIME_INTERVAL) {
            backKeyPressedTime = System.currentTimeMillis()
            toast("뒤로 버튼을 한번 더 누르시면 종료됩니다.")
        } else {
            finish()
        }
    }
}