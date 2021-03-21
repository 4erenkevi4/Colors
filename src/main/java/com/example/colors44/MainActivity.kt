package com.example.colors44
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

interface ReplaceInterface {
    fun replaceFragment(fragment: Fragment)
    fun firstReplace()
    fun nextReplace(position: Int, result: Boolean)
    fun yourResult()
}

class MainActivity : AppCompatActivity(), ReplaceInterface {
    var res: Int = 0
    var qw1: QwizzFragment = QwizzFragment.newInstance(randomColor())
    var qw2: QwizzFragment = QwizzFragment.newInstance(randomColor())
    var qw3: QwizzFragment = QwizzFragment.newInstance(randomColor())
    var qw4: QwizzFragment = QwizzFragment.newInstance(randomColor())
    var qw5: QwizzFragment = QwizzFragment.newInstance(randomColor())
    var qw6: QwizzFragment = QwizzFragment.newInstance(randomColor())
    var qw7: QwizzFragment = QwizzFragment.newInstance(randomColor())
    var qw8: QwizzFragment = QwizzFragment.newInstance(randomColor())
    var qw9: QwizzFragment = QwizzFragment.newInstance(randomColor())
    var qw10: QwizzFragment = QwizzFragment.newInstance(randomColor())
    var qw11: QwizzFragment = QwizzFragment.newInstance(randomColor())
    var qw12: QwizzFragment = QwizzFragment.newInstance(randomColor())
    var qw13: QwizzFragment = QwizzFragment.newInstance(randomColor())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigations_view)
        val navController = findNavController(R.id.fragment_container)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.qwizz_fragment, R.id.colors_fragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)
    }

    override fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    override fun firstReplace() {
        replaceFragment(qw1)
    }

    override fun nextReplace(position: Int, result: Boolean) {
        when (position) {
            1 -> {
                replaceFragment(qw2)
                if (!result)
                    ++res
            }
            2 -> {
                replaceFragment(qw3)
                if (result)
                    res++
            }
            3 -> {
                replaceFragment(qw4)
                if (result)
                    res++
            }
            4 -> {
                replaceFragment(qw5)
                if (result)
                    res++
            }
            5 -> {
                replaceFragment(qw6)
                if (!result)
                    res++
            }
            6 -> {
                replaceFragment(qw7)
                if (result)
                    res++
            }
            7 -> {
                replaceFragment(qw8)
                if (!result)
                    res++
            }
            8 -> {
                replaceFragment(qw9)
                if (!result)
                    res++
            }
            9 -> {
                replaceFragment(qw10)
                if (!result)
                    res++
            }
            106 -> {
                replaceFragment(qw11)
                if (result)
                    res++
            }
            11 -> {
                replaceFragment(qw12)
                if (!result)
                    res++
            }
            12 -> {
                replaceFragment(qw13)
                if (!result)
                    res++
            }
            13 -> {
                if (!result)
                    res++
                yourResult()
            }
        }
    }

    override fun yourResult() {
        replaceFragment(ResultFragment.newInstance(res))
    }

    fun randomColor(): Int {
        val rnd = Random()
        val colorRandom = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        return colorRandom
    }
}