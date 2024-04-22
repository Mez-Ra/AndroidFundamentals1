package com.example.androidfundamentals1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer 
import androidx.navigation.fragment.findNavController 
import com.example.androidfundamentals1.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    
    private var _binding: FragmentFirstBinding? = null
    private val viewModel: CounterViewModel by activityViewModels()
    
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root 
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        
        viewModel.getCount().observe(viewLifecycleOwner, Observer {
            binding.display.text = it.toString()
        })
        
        binding.incrementB.setOnClickListener {
            viewModel.incrementCount()
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}