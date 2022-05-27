package com.example.view_binding_tutorial.languagefragment

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.example.view_binding_tutorial.R
import com.example.view_binding_tutorial.databinding.FragmentLanguageBinding
import kotlinx.android.synthetic.main.fragment_language.view.*
import java.util.*


  class LanguageFragment:Fragment(R.layout.fragment_language){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.qazaqstan_til.setOnClickListener {
            Toast.makeText(activity, "yahoo", Toast.LENGTH_SHORT).show()
            val locale = Locale("kk")
            Locale.setDefault(locale)
            val configuration = Configuration()
            configuration.locale = locale
            requireActivity().resources.updateConfiguration(configuration, requireActivity().resources.displayMetrics)
            requireActivity().recreate()
        }
        view.russia_til.setOnClickListener {
            val locale = Locale("ru")
            Locale.setDefault(locale)
            val config = Configuration()
            config.locale = locale
            requireActivity().resources.updateConfiguration(config, requireActivity().resources.displayMetrics)
            requireActivity().recreate()
        }
        view.usa_til.setOnClickListener {
            val locale = Locale("en")
            Locale.setDefault(locale)
            val config = Configuration()
            config.locale = locale
            requireActivity().resources.updateConfiguration(config, requireActivity().resources.displayMetrics)
            requireActivity().recreate()
        }


    }


}
