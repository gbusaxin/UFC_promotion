package com.example.ufcpromotion.presentation

import android.webkit.WebSettings
import android.webkit.WebView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ufcpromotion.data.network.model.ResponseDto
import com.example.ufcpromotion.domain.use_cases.GetLocaleUseCase
import com.example.ufcpromotion.domain.use_cases.SendLocaleUseCase
import com.example.ufcpromotion.domain.use_cases.SetWebSettingsUseCase
import com.example.ufcpromotion.presentation.adapters.MyWebClient
import kotlinx.coroutines.launch
import javax.inject.Inject

class WebViewModel @Inject constructor(
    private val webClient: MyWebClient,
    private val sendLocaleUseCase: SendLocaleUseCase,
    private val getLocaleUseCase: GetLocaleUseCase,
    private val setWebSettingsUseCase: SetWebSettingsUseCase
) : ViewModel() {

    private val _response = MutableLiveData<ResponseDto>()
    val response: LiveData<ResponseDto>
        get() = _response

    fun setSettings(settings: WebSettings){
        setWebSettingsUseCase(settings)
    }

    fun setWebViewClient(webView: WebView){
        webView.webViewClient = webClient
    }

    private fun sendLocale(){
        viewModelScope.launch {
            sendLocaleUseCase(getLocaleUseCase()).let {
                _response.value = it
            }
        }
    }

    init {
        sendLocale()
    }

}