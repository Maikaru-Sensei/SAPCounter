package at.fhooe.sapcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import at.fhooe.sapcounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel = CounterViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        viewModel.state.observe(this) {
            binding.counterText.text = it.counter.toString()
        }

        binding.counterDown.setOnClickListener {
            viewModel.processIntent(CounterIntent.Decrement)
        }

        binding.counterUp.setOnClickListener {
            viewModel.processIntent(CounterIntent.Increment)
        }

        setContentView(binding.root)
    }
}