package com.example.simpleform

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.simpleform.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
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

        binding.clearText.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

//        code for clear button
        binding.clearText.setOnClickListener { clearForm() }

//        code for save button
        binding.saveText.setOnClickListener { handleForm() }
    }

    private fun clearForm() {
        binding.firstNameEditText.setText("")
        binding.lastNameEditText.setText("")
        binding.collegeNameEditText.setText("")

        binding.male.clearFocus()
        binding.female.clearFocus()

        binding.isCollegeCompleted.clearFocus()
        binding.areYouHappy.clearFocus()
    }

    private fun handleForm() {
        var gender = when (binding.gender.checkedRadioButtonId) {
            R.id.male -> "male"
            R.id.female -> "female"
            else -> "null"
        }

        val firstName = binding.firstNameEditText.text.toString()
        val lastName = binding.lastNameEditText.text.toString()
        val collegeName = binding.collegeNameEditText.text.toString()

        val isCollegeCompleted = binding.isCollegeCompleted.isChecked
        val areYouHappy = binding.areYouHappy.isChecked

        val bundle = bundleOf(
            "first_name" to firstName,
            "last_name" to lastName,
            "college_name" to collegeName,
            "gender" to gender,
            "is_college_completed" to isCollegeCompleted,
            "are_you_happy" to areYouHappy
        )

        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}