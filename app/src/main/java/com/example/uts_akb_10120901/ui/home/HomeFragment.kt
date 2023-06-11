package com.example.uts_akb_10120901.ui.home
//Nama: Mustapha Hadzi
//Kelas: IF-10
//NIM: 10120901
//Tanggal Pengerjaan: 11 Juni 2023
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.uts_akb_10120901.R
import com.google.android.material.card.MaterialCardView

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val card1: ImageView = view.findViewById(R.id.img_hobby)
        val card2: ImageView = view.findViewById(R.id.img_ideals)
        val card3: ImageView = view.findViewById(R.id.img_drink)
        val card4: ImageView = view.findViewById(R.id.img_food)
        val card5: ImageView = view.findViewById(R.id.img_interest)

        card1.setOnClickListener {
            showPopupDialog(R.layout.dialog_hobbies)
        }

        card2.setOnClickListener {
            showPopupDialog(R.layout.dialog_ideals)
        }

        card3.setOnClickListener {
            showPopupDialog(R.layout.dialog_drink)
        }

        card4.setOnClickListener {
            showPopupDialog(R.layout.dialog_food)
        }

        card5.setOnClickListener {
            showPopupDialog(R.layout.dialog_interest)
        }
    }

    private fun showPopupDialog(layoutResId: Int) {
        val inflater = LayoutInflater.from(requireContext())
        val popupView = inflater.inflate(layoutResId, null)

        // Create and show the popup dialog
        val popupDialog = Dialog(requireContext())
        popupDialog.setContentView(popupView)

        // Adjust dialog size

        val layoutParams = popupDialog.window?.attributes
//        layoutParams?.width = ViewGroup.LayoutParams.MATCH_PARENT
//        layoutParams?.height = ViewGroup.LayoutParams.WRAP_CONTENT
        popupDialog.window?.attributes = layoutParams
        popupDialog.getWindow()?.setBackgroundDrawableResource(R.drawable.dialog);


        popupDialog.show()
    }
}
