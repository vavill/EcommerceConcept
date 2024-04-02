package com.example.ecommerceconcept

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.ecommerceconcept.databinding.FragmentVMBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VMFragment : Fragment() {

    private var _binding: FragmentVMBinding? = null
    private val binding: FragmentVMBinding get() = requireNotNull(_binding)

    private val viewModel: VMViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVMBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.counterLiveData.observe(viewLifecycleOwner) {
            binding.tvTextview.text = it.toString()
        }
    //    binding.tvTextview.text = counter.toString()

        binding.btnButton.setOnClickListener {
            viewModel.onButtonClick()
           // binding.tvTextview.text = (++counter).toString()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        fun newInstance() = VMFragment()
    }
}