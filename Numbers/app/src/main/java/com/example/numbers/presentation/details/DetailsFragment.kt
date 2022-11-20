package com.example.numbers.presentation.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.numbers.data.cache.NumbersDatabase
import com.example.numbers.databinding.FragmentDetailsBinding

private const val NUMBER_KEY = "NUMBER_KEY"
private const val RANDOM = "RANDOM"
private const val CACHE_KEY = "CACHE"

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity())[DetailsViewModel::class.java]
        val dao = NumbersDatabase.getDatabase(requireContext()).numbersDao()

        arguments?.let {
            val cache = it.getString(CACHE_KEY)
            if (cache != null) {
                binding.progressBar.visibility = View.GONE
                binding.detailsTextView.text = cache
            } else
                when (val arg = it.getString(NUMBER_KEY)!!) {
                    RANDOM -> {
                        viewModel.getRandomNumber(dao) { result ->
                            binding.progressBar.visibility = View.GONE
                            if (result is com.example.numbers.data.model.Result.NumberRandomFact) {
                                binding.detailsTextView.text = result.fact
                            } else {
                                binding.errorTextView.visibility = View.VISIBLE
                                binding.errorTextView.text =
                                    (result as com.example.numbers.data.model.Result.Error).message
                            }
                        }
                    }
                    else -> {
                        viewModel.getNumber(dao, arg) { result ->
                            binding.progressBar.visibility = View.GONE
                            if (result is com.example.numbers.data.model.Result.NumberFact) {
                                binding.detailsTextView.text = result.fact
                            } else {
                                binding.errorTextView.visibility = View.VISIBLE
                                binding.errorTextView.text =
                                    (result as com.example.numbers.data.model.Result.Error).message
                            }
                        }
                    }
                }
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(number: String, isRandom: Boolean, fact: String) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    if (fact.isNotEmpty()) {
                        putString(CACHE_KEY, fact)
                    } else {
                        if (isRandom)
                            putString(NUMBER_KEY, RANDOM)
                        else
                            putString(NUMBER_KEY, number)
                    }
                }
            }
    }
}