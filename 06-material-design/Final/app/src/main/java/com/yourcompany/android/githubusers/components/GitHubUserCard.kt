package com.yourcompany.android.githubusers.components

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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yourcompany.android.githubusers.model.GitHubRepository

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
                    style = MaterialTheme.typography.h5,
                )
                Spacer(modifier = Modifier.height(8.dp))
                repo.description?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.body1
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = repo.htmlUrl,
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.secondary,
                    textDecoration = TextDecoration.Underline
                )

            }
        }
    }
}