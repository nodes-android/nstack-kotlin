package dk.nodes.nstack.demo.splash

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dk.nodes.nstack.kotlin.NStack
import dk.nodes.nstack.kotlin.models.Result
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val viewStateInternal: MutableLiveData<SplashViewState> = MutableLiveData()
    val viewState: LiveData<SplashViewState> = viewStateInternal

    init {
        viewStateInternal.value = SplashViewState(
            isLoading = true,
            isFinished = false,
            message = null
        )
        viewModelScope.launch {
            NStack.appOpenFLow()
                .collect { result ->
                    when (result) {
                        is Result.Success -> {
                            Log.d("AppOpenResult: Success", result.toString())
                            viewStateInternal.value = viewStateInternal.value?.copy(
                                isLoading = false,
                                isFinished = true,
                                message = result.value.data.message
                            )
                        }
                        is Result.Error -> {
                            Log.d("AppOpenResult: Error", result.toString())
                            viewStateInternal.value = viewStateInternal.value?.copy(
                                isLoading = false,
                                isFinished = true
                            )
                        }
                    }
                }
        }
    }
}