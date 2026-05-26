package com.softylur.basiccalculator

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.softylur.basiccalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnCalculate.setOnClickListener {
            val weight = binding.etxtWeight.text.toString().toDoubleOrNull()
            val feet = binding.etFt.text.toString().toDoubleOrNull()
            val inches = binding.etIn.text.toString().toDoubleOrNull()

            if (weight != null && feet != null && inches != null) {
                calculateBmiNumber(weight, feet, inches)
                calculateBmi(weight, feet, inches)
            } else {
                binding.tv1.text = ""
                binding.tv2.text = ""
                binding.tv3.text = ""
                binding.tv4.text = ""
                binding.tv5.text = ""
                binding.tv6.text = ""
                binding.tvText1.text = ""
                binding.tvTips.text = ""
                Toast.makeText(applicationContext, "Please enter valid weight, feet, and inches." , Toast.LENGTH_LONG).show()
            }

        }
        binding.btnReset.setOnClickListener{
            binding.tv1.text = ""
            binding.tv2.text = ""
            binding.tv3.text = ""
            binding.tv4.text = ""
            binding.tv5.text = ""
            binding.tv6.text = ""
            binding.tvText1.text = ""
            binding.tvTips.text = ""
            binding.etxtWeight.setText("")
            binding.etFt.setText("")
            binding.etIn.setText("")
        }
    }

    private fun calculateBmi(weight: Double, feet: Double, inches: Double) {
        val heightInches = (feet * 12) + inches
        val heightMeters = heightInches * 0.0254
        val bmi = weight / (heightMeters * heightMeters)

            when {
                bmi < 16.9 -> {
                    binding.tv1.text = bmi.toString()
                    binding.tvTips.text = getString(R.string.underweight)
                    binding.tv2.text = ""
                    binding.tv3.text = ""
                    binding.tv4.text = ""
                    binding.tv5.text = ""
                    binding.tv6.text = ""
                }
                bmi in 17.0..18.4 -> {
                    binding.tv1.text = ""
                    binding.tv2.text = bmi.toString()
                    binding.tvTips.text = getString(R.string.underweight)
                    binding.tv3.text = ""
                    binding.tv4.text = ""
                    binding.tv5.text = ""
                    binding.tv6.text = ""
                }
                bmi in 18.5..25.0 -> {
                    binding.tv1.text = ""
                    binding.tv2.text = ""
                    binding.tv3.text = bmi.toString()
                    binding.tvTips.text = getString(R.string.healty)
                    binding.tv4.text = ""
                    binding.tv5.text = ""
                    binding.tv6.text = ""
                }
                bmi in 25.0 .. 30.0 -> {
                    binding.tv1.text = ""
                    binding.tv2.text = ""
                    binding.tv3.text = ""
                    binding.tv4.text = bmi.toString()
                    binding.tvTips.text = getString(R.string.overweight)
                    binding.tv5.text = ""
                    binding.tv6.text = ""
                }
                bmi in 30.0 .. 34.9 -> {
                    binding.tv1.text = ""
                    binding.tv2.text = ""
                    binding.tv3.text = ""
                    binding.tv4.text = ""
                    binding.tv5.text = bmi.toString()
                    binding.tvTips.text = getString(R.string.overweight)
                    binding.tv6.text = ""
                }
            else -> {
                binding.tv1.text = ""
                binding.tv2.text = ""
                binding.tv3.text = ""
                binding.tv4.text = ""
                binding.tv5.text = ""
                binding.tv6.text = bmi.toString()
                binding.tvTips.text = getString(R.string.overweight)
            }
        }
    }

    private fun calculateBmiNumber(weight: Double, ft: Double, inches: Double) {

        val heightInches = (ft * 12) + inches
        val heightMeters = heightInches * 0.0254
        val bmi = weight / (heightMeters * heightMeters)

        binding.tvText1.text = when {
                bmi < 16.0 -> "Very Severely Underweight"
                bmi in 16.0..16.9 -> "Severely Underweight"
                bmi in 17.0..18.4 -> "Underweight"
                bmi in 18.5..24.9 -> "Normal Weight"
                bmi in 25.0..29.9 -> "Overweight"
                bmi in 30.0..34.9 -> "Obese Class I"
                bmi in 35.0..39.9 -> "Obese Class II"
                else -> "Obese Class III"
        }
    }

}