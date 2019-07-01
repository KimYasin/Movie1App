package com.kimyasin.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient


class Subscribe : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_subscribe, container, false)


        val  mywebview= view.findViewById(R.id.webview) as WebView
        mywebview.loadUrl("https://www.youtube.com/")

        val webSettings = mywebview.getSettings()
        webSettings.setJavaScriptEnabled(true)

        mywebview.setWebViewClient(WebViewClient())

        return view
    }
}
