package com.example.uts_akb_10120901.ui.music

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_akb_10120901.R
import com.example.uts_akb_10120901.ui.music.MusicModel
import com.example.uts_akb_10120901.databinding.ItemMusicBinding


class MusicAdapter : RecyclerView.Adapter<MusicAdapter.ViewHolder>() {

    private var mediaPlayer: MediaPlayer? = null
    private var currentPlayingPosition: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item = differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ViewHolder(private val binding: ItemMusicBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MusicModel) {
            binding.run {
                musicImg.setImageResource(item.image)
                musicTitle.text = item.name
                musicDesc.text = item.desc

                // Set click listener for the album image/button
                musicImg.setOnClickListener {
                    val context = itemView.context
                    val resourceId = item.songResId

                    if (adapterPosition == currentPlayingPosition) {
                        // If the clicked item is the currently playing song
                        if (mediaPlayer?.isPlaying == true) {
                            // If the song is playing, pause it
                            mediaPlayer?.pause()
                            binding.musicImg.setImageResource(R.drawable.start) // Change the button image to "play"
                        } else {
                            // If the song is paused, resume playing
                            mediaPlayer?.start()
                            binding.musicImg.setImageResource(R.drawable.pause) // Change the button image to "pause"
                        }
                    } else {
                        // If a new song is clicked, stop the currently playing song (if any)
                        mediaPlayer?.release()

                        // Play the new song
                        mediaPlayer = MediaPlayer.create(context, resourceId)
                        mediaPlayer?.start()
                        binding.musicImg.setImageResource(R.drawable.pause) // Change the button image to "pause"

                        // Update the currently playing position
                        if (currentPlayingPosition != -1) {
                            notifyItemChanged(currentPlayingPosition)
                        }
                        currentPlayingPosition = adapterPosition
                    }
                }
            }
        }
    }

    private val differCallBack = object : DiffUtil.ItemCallback<MusicModel>() {
        override fun areItemsTheSame(oldItem: MusicModel, newItem: MusicModel): Boolean {
            return oldItem.image == newItem.image
        }

        override fun areContentsTheSame(oldItem: MusicModel, newItem: MusicModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)
}