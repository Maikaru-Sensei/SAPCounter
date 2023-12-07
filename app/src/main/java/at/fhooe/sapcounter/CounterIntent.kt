package at.fhooe.sapcounter

sealed class CounterIntent {
    object Increment : CounterIntent()
    object Decrement : CounterIntent()
}