package br.com.gema.Fragments.Chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.gema.Fragments.Chat.Handler.MessageData

import br.com.gema.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.chat_message_holder.view.*
import kotlinx.android.synthetic.main.fragment_chat_hall.*
import kotlinx.android.synthetic.main.owner_chat_message_holder.view.*

class ChatHall : androidx.fragment.app.Fragment() {

    private lateinit var database : DatabaseReference
    private var adapter = GroupAdapter<ViewHolder>()

    companion object {
        @JvmStatic
        fun newInstance() = ChatHall()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = FirebaseDatabase.getInstance().reference
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat_hall, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chat_send_message_button.setOnClickListener {
            val messageData = MessageData(chat_message_holder.text.toString(), activity!!)
            sendMessage(messageData)
        }

        chat_hall_recycler_view.adapter = adapter
        listenMessages()
    }

    private fun sendMessage(messageData : MessageData) {
        val reference = database.child("messages").push()
        reference.setValue(messageData)
    }

    fun listenMessages() {

        database.child("messages").addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, p1: String?) {
                val message = dataSnapshot.getValue(MessageData::class.java)
                if(message != null) {
                    val messageData = MessageData(message.text, activity!!)

                    if(message.userId == FirebaseAuth.getInstance().uid.toString())
                        adapter.add(GetOwnerMessageHolder(messageData))
                    else
                        adapter.add(GetMessageHolder(messageData))
                }
                chat_hall_recycler_view.smoothScrollToPosition(chat_hall_recycler_view.adapter!!.itemCount - 1)
            }
            override fun onCancelled(p0: DatabaseError) { }
            override fun onChildChanged(p0: DataSnapshot, p1: String?) { }
            override fun onChildMoved(p0: DataSnapshot, p1: String?) { }
            override fun onChildRemoved(p0: DataSnapshot) { }
        })

    }

    class GetOwnerMessageHolder(val messageData: MessageData) : Item() {
        override fun bind(viewHolder: com.xwray.groupie.kotlinandroidextensions.ViewHolder, position: Int) {
            viewHolder.itemView.owner_message_text.text = messageData.text
            Picasso.get().load(messageData.imageUrl).into(viewHolder.itemView.owner_user_image)
        }

        override fun getLayout(): Int {
            return R.layout.owner_chat_message_holder
        }

    }

    class GetMessageHolder(val messageData: MessageData) : Item() {
        override fun bind(viewHolder: com.xwray.groupie.kotlinandroidextensions.ViewHolder, position: Int) {
            viewHolder.itemView.another_user_message_text.text = messageData.text
            Picasso.get().load(messageData.imageUrl).into(viewHolder.itemView.owner_user_image)
        }

        override fun getLayout(): Int {
            return R.layout.chat_message_holder
        }
    }
}
