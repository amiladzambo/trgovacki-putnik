package com.example.trgovackiputnik.data

import android.app.Application

public class Global : Application() {
    companion object {
        @JvmField
        var logic = Logic();
    }
}