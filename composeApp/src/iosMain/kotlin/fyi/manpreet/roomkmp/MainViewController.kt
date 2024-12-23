package fyi.manpreet.roomkmp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    val dao = remember {
        geMemeDatabase().memeDao()
    }
    App(dao)
}