package com.example.simpleform

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.simpleform.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fName = arguments?.getString("first_name")
        val lName = arguments?.getString("last_name")
        val cName = arguments?.getString("college_name")
        val isCollege = arguments?.getBoolean("is_college_completed")
        val isHappy = arguments?.getBoolean("are_you_happy")
        val gender = arguments?.getString("gender")

//        binding.setFirstName.setText(fName)
//        binding.setLastName.setText(lName)
//        binding.setCollegeName.setText(cName)
//        binding.setGender.setText(gender)
//        binding.setIsCollegeCompleted.setText(if(isCollege == true){"Yes"} else{"false"})
//        binding.setAreYouHappy.setText(if(isHappy == true){"Yes"} else{"false"})

        binding.setFirstName.text = fName
        binding.setLastName.text = lName
        binding.setCollegeName.text = cName
        binding.setGender.text = gender
        binding.setIsCollegeCompleted.text = if(isCollege == true){"Yes"} else{"false"}
        binding.setAreYouHappy.text = if(isHappy == true){"Yes"} else{"false"}

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}