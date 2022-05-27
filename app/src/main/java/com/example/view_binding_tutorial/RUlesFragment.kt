package com.example.view_binding_tutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.fragment_rules.*
import kotlinx.android.synthetic.main.fragment_rules.view.*
import kotlinx.android.synthetic.main.layout_custom_dialog.view.*


class RUlesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_rules, container, false)

        view.dropdown_menu.setOnClickListener(View.OnClickListener { view ->
            val popupMenu = PopupMenu(requireContext(), view)

            popupMenu.menuInflater.inflate(R.menu.menu_rule, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener {
                when (it.itemId) {
                    R.id.edit -> {
                        val alert = AlertDialog.Builder(requireContext())
                        val mView = layoutInflater.inflate(R.layout.layout_custom_dialog, null)
                        val txt_inputText = mView.findViewById<View>(R.id.rule_input) as EditText
                        val txt_topic_inputText =
                            mView.findViewById<View>(R.id.rule_input_topic) as EditText
                        val btn_cancell = mView.findViewById<View>(R.id.btn_cancell) as Button
                        val btn_send = mView.findViewById<View>(R.id.btn_send) as Button
                        alert.setView(mView)

                        val rule_input_to_output = rule_topic_output.text.toString()
                        mView.rule_input_topic.setText(rule_input_to_output)
                        val rule_input_topic = rule_topic_output.text.toString()
                        mView.rule_input_topic.setText(rule_input_topic)

                        val rule_input_to_output2 = rule_output.text.toString()
                        mView.rule_input.setText(rule_input_to_output2)
                        val rule_input = rule_output.text.toString()
                        mView.rule_input.setText(rule_input)

                        val alertDialog = alert.create()
                        alertDialog.setCanceledOnTouchOutside(false)
                        alertDialog.show()
                        btn_cancell.setOnClickListener { alertDialog.dismiss() }
                        btn_send.setOnClickListener {
                            rule_output!!.text = txt_inputText.text.toString()
                            rule_topic_output!!.text = txt_topic_inputText.text.toString()
                        }
                    }
                }
                return@OnMenuItemClickListener true
            })
            popupMenu.show()
        })
        view.dropdown_menu2.setOnClickListener(View.OnClickListener { view ->
            val popupMenu = PopupMenu(requireContext(), view)

            popupMenu.menuInflater.inflate(R.menu.menu_rule2, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener {
                when (it.itemId) {
                    R.id.edit2 -> {
                        val alert = AlertDialog.Builder(requireContext())
                        val mView = layoutInflater.inflate(R.layout.layout_custom_dialog, null)
                        val txt_inputText = mView.findViewById<View>(R.id.rule_input) as EditText
                        val txt_topic_inputText = mView.findViewById<View>(R.id.rule_input_topic) as EditText
                        val btn_cancell = mView.findViewById<View>(R.id.btn_cancell) as Button
                        val btn_send = mView.findViewById<View>(R.id.btn_send) as Button
                        alert.setView(mView)

                        val rule_input_to_output = rule_topic_output2.text.toString()
                        mView.rule_input_topic.setText(rule_input_to_output)
                        val rule_input_topic = rule_topic_output2.text.toString()
                        mView.rule_input_topic.setText(rule_input_topic)

                        val rule_input_to_output2 = rule_output2.text.toString()
                        mView.rule_input.setText(rule_input_to_output2)
                        val rule_input = rule_output2.text.toString()
                        mView.rule_input.setText(rule_input)


                        val alertDialog = alert.create()
                        alertDialog.setCanceledOnTouchOutside(false)
                        alertDialog.show()
                        btn_cancell.setOnClickListener { alertDialog.dismiss() }
                        btn_send.setOnClickListener {
                            rule_output!!.text = txt_inputText.text.toString()
                            rule_topic_output!!.text = txt_topic_inputText.text.toString()
                        }
                    }
                }
                return@OnMenuItemClickListener true
            })
            popupMenu.show()
        })


        return view


    }
}