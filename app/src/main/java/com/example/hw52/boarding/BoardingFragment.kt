package com.example.hw52.boarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw52.R
import com.example.hw52.databinding.FragmentBoardingBinding


class BoardingFragment : Fragment() {

    private lateinit var binding: FragmentBoardingBinding
    private var titles = ArrayList<OnBoard>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentBoardingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadBoard()
        val adapter = BoardingAdapter(titles, this::onClick)
        binding.viewpager.adapter = adapter
        binding.wormDotsIndicator.attachTo(binding.viewpager)
    }

    private fun loadBoard(){
        titles.add(OnBoard("My testing Project","you testing os my \nmy project",
            R.drawable.img_1))
        titles.add(OnBoard("Не знаю что написать ","Пишу то что приходит в голову\nкак то так ",
            R.drawable.img))
        titles.add(OnBoard("Хочещь начать ","Жми на кнопку старт и узнавай  \nТайны \nЭтого сраного мира",
            R.drawable.ic_third))
    }

    private fun onClick(){
        findNavController().navigate(R.id.loveFragment)
    }


}