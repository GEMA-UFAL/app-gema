package br.com.gema.Fragments.Community.Handler

import br.com.gema.Fragments.Community.Model.ForumPost
import br.com.gema.R
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.forum_post_holder.view.*

class ForumPostHolder(val forumPost : ForumPost) : Item() {
    override fun bind(viewHolder: com.xwray.groupie.kotlinandroidextensions.ViewHolder, position: Int) {
        viewHolder.itemView.forum_post_alternative_title.text = forumPost.alternativeTitle
        viewHolder.itemView.forum_post_title.text = forumPost.alternativeTitle
        viewHolder.itemView.forum_post_tag1.text = forumPost.alternativeTitle
        viewHolder.itemView.forum_post_tag2.text = forumPost.alternativeTitle
        viewHolder.itemView.forum_post_description.text = forumPost.alternativeTitle
    }

    override fun getLayout(): Int {
        return R.layout.forum_post_holder
    }
}