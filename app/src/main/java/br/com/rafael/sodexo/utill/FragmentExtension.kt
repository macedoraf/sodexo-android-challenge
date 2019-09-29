package br.com.rafael.sodexo.utill

import android.content.Context
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import br.com.rafael.sodexo.presentation.CoreActivity
import br.com.rafael.sodexo.presentation.CoreFragment
import kotlinx.android.synthetic.main.core_ativity_layout.*


fun CoreFragment.close() = fragmentManager?.popBackStack()

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) =
    beginTransaction().func().commit()

val CoreFragment.viewContainer: View get() = (activity as CoreActivity).fragmentContainer

val CoreFragment.appContext: Context get() = activity?.applicationContext!!