package fyi.manpreet.roomkmp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fyi.manpreet.roomkmp.db.Meme
import fyi.manpreet.roomkmp.db.MemeDao
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(dao: MemeDao) {
    MaterialTheme {
        val memes by dao.getAllMemes().collectAsState(initial = emptyList())
        val scope = rememberCoroutineScope()

        LaunchedEffect(true) {
            listOf(
                Meme(imageUrl = "Meme URL 1"),
                Meme(imageUrl = "Meme URL 2"),
                Meme(imageUrl = "Meme URL 3"),
            ).map {
                dao.insertMeme(it)
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
        ) {
            items(memes) { meme ->
                Text(
                    text = meme.imageUrl,
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                        .clickable { scope.launch { dao.deleteMeme(meme) } }
                )
            }
        }
    }
}