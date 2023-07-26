package com.example.sportquiz.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.sportquiz.R

class OnboardingFragment : Fragment() {
    private lateinit var title: String
    private lateinit var description: String
    private var imageResource = 0
    private lateinit var tvTitle: AppCompatTextView
    private lateinit var tvDescription: AppCompatTextView
    private lateinit var image: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            title = requireArguments().getString(ARG_PARAM1)!!
            description = requireArguments().getString(ARG_PARAM2)!!
            imageResource = requireArguments().getInt(ARG_PARAM3)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_onboarding, container, false)
        tvTitle = view.findViewById(R.id.text_onboarding_title)
        tvDescription = view.findViewById(R.id.text_onboarding_description)
        image = view.findViewById(R.id.image_onboarding_fragment)
        tvTitle.text = title
        tvDescription.text = description
        image.setImageDrawable(ContextCompat.getDrawable(view.context, imageResource))
        return view
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
        private const val ARG_PARAM3 = "param3"
        fun newInstance(
            title: String, description: String, imageResource: Int
        ): OnboardingFragment {
            val fragment = OnboardingFragment()
            val args = Bundle()
            args.putString(
                ARG_PARAM1, title
            )
            args.putString(
                ARG_PARAM2, description
            )
            args.putInt(
                ARG_PARAM3, imageResource
            )
            fragment.arguments = args
            return fragment
        }
    }
}