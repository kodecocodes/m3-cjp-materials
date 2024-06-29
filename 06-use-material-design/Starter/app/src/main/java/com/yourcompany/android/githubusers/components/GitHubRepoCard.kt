package com.yourcompany.android.githubusers.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.yourcompany.android.githubusers.model.GitHubRepository
import com.yourcompany.android.githubusers.model.Owner

@Composable
fun GitHubRepoCard(repo: GitHubRepository) {
    Card(shape = RoundedCornerShape(16.dp), elevation = 2.dp) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(75.dp)
                    .clip(CircleShape),
                model = repo.owner.avatarUrl,
                contentDescription = null,
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = repo.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                repo.description?.let {
                    Text(text = it, fontSize = 14.sp)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = repo.htmlUrl,
                    fontWeight = FontWeight.Normal,
                    textDecoration = TextDecoration.Underline
                )

            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewGitHubRepoCard() {
    GitHubRepoCard(
        GitHubRepository(
            id = 1,
            name = "Hello Compose",
            description = "A sample app to showcase Jetpack Compose",
            htmlUrl = "www.github.com/kodecocodes",
            owner = Owner(
                id = 1,
                login = "kodecocodes",
                avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"
            ),
            fork = false,
            private = false,
            fullName = "kodecocodes/HelloCompose",
            nodeId = "1"
        )
    )
}