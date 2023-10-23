package com.example.mymultifragapplicationclear

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.setFragmentResult
import com.example.mymultifragapplicationclear.databinding.FragmentInputBinding


class InputFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentInputBinding.inflate(inflater, container , false)

        arguments?.let{
            binding.edtText.setText(it.getString("text"))
        }

        binding.edtText.addTextChangedListener {
            val resBundle = Bundle().apply {
                putString("input", binding.edtText.text.toString())
            }
            setFragmentResult("input_text", resBundle)
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(str: String? = null) =
            InputFragment().apply {
                arguments = Bundle(). apply{
                    str?. let{
                        putString("text", it)
                    }
                }
            }
    }
}