package com.example.uts_akb_10120901.ui.music


import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_akb_10120901.R
import com.example.uts_akb_10120901.ui.music.MusicModel

class MusicFragment : Fragment(R.layout.fragment_music) {

    private val musicAdapter = MusicAdapter()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val music = listOf(
            MusicModel(R.drawable.music_img_1, "Paradise", "Coldplay",R.raw.paradise),
            MusicModel(R.drawable.music_img_2, "Yellow", "Coldplay",R.raw.yellow),
            MusicModel(R.drawable.music_img_3, "たぶん", "Yoasobi",R.raw.tabun),
        )

        val rvmusic = getView()?.findViewById<RecyclerView>(R.id.rvmusic)
        val videoView = getView()?.findViewById<VideoView>(R.id.videoView)
        val videoPath = "android.resource://" + requireActivity().packageName + "/" + R.raw.video

        val uri = Uri.parse(videoPath)
        videoView?.setVideoURI(uri)

        val mediaController = MediaController(requireContext())
        videoView?.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)
        mediaController.requestFocus()

        val imageButton = getView()?.findViewById<ImageButton>(R.id.play_button)
        imageButton?.setOnClickListener {
            if (!videoView?.isPlaying!!) {
                videoView.start()
                imageButton.visibility = View.GONE
            }
        }
        rvmusic?.adapter = musicAdapter
        musicAdapter.differ.submitList(music)


    }
}