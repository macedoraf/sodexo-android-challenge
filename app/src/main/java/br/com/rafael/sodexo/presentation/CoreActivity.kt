package br.com.rafael.sodexo.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.rafael.sodexo.R
import br.com.rafael.sodexo.utill.inTransaction
import kotlinx.android.synthetic.main.core_ativity_layout.*
import kotlinx.android.synthetic.main.toolbar.*

abstract class CoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.core_ativity_layout)
        setSupportActionBar(toolbar)
        addFragment(savedInstanceState)
    }

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(
            fragmentContainer
                .id
        ) as CoreFragment).onBackPressed()
        super.onBackPressed()
    }

    private fun addFragment(savedInstanceState: Bundle?) =
        savedInstanceState ?: supportFragmentManager.inTransaction {
            add(
                R.id.fragmentContainer, fragment()
            )
        }

    abstract fun fragment(): CoreFragment
}