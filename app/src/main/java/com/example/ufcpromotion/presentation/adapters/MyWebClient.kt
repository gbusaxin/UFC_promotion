package com.example.ufcpromotion.presentation.adapters

import android.app.Application
import android.graphics.Bitmap
import android.net.http.SslError
import android.webkit.*
import android.widget.Toast
import javax.inject.Inject

class MyWebClient @Inject constructor(
    private val application: Application
) : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        view?.loadUrl(request?.url.toString())
        return true
    }

    override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        super.onReceivedError(view, request, error)
        Toast.makeText(application, "Ошибка в интернет соединении.", Toast.LENGTH_SHORT).show()
    }

    override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
        super.onReceivedSslError(view, handler, error)
        handler?.cancel()
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
    }
}