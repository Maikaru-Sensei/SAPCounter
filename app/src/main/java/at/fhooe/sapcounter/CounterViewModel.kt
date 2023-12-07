package at.fhooe.sapcounter

import androidx.lifecycle.MutableLiveData

class CounterViewModel {
    val state = MutableLiveData<CounterModel>()

    init {
        state.value = CounterModel()
    }

    fun processIntent(intent: CounterIntent) {
        val currentState = state.value ?: CounterModel()
        when (intent) {
            is CounterIntent.Increment -> {
                state.value = currentState.copy(counter = currentState.counter + 1)
            }
            is CounterIntent.Decrement -> {
                state.value = currentState.copy(counter = currentState.counter - 1)
            }
        }
    }
}