package com.example.uts_akb_10120901.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_akb_10120901.R
import com.example.uts_akb_10120901.ui.gallery.GalleryModel
//Nama: Mustapha Hadzi
//Kelas: IF-10
//NIM: 10120901
//Tanggal Pengerjaan: 11 Juni 2023
class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private val galleryAdapter = GalleryAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gallery = listOf(
            GalleryModel(R.drawable.gallery1),
            GalleryModel(R.drawable.gallery2),
            GalleryModel(R.drawable.gallery3),
            GalleryModel(R.drawable.gallery4),
            GalleryModel(R.drawable.gallery16),
            GalleryModel(R.drawable.gallery6),
            GalleryModel(R.drawable.gallery7),
            GalleryModel(R.drawable.gallery8),
            GalleryModel(R.drawable.gallery9),
            GalleryModel(R.drawable.gallery10),
            GalleryModel(R.drawable.gallery11),
            GalleryModel(R.drawable.gallery12),
            GalleryModel(R.drawable.gallery13),
            GalleryModel(R.drawable.gallery14),
            GalleryModel(R.drawable.gallery15),
            GalleryModel(R.drawable.gallery17),
        )

        val rvgallery = getView()?.findViewById<RecyclerView>(R.id.rvgallery)
        rvgallery?.adapter = galleryAdapter
        galleryAdapter.differ.submitList(gallery)
    }
}