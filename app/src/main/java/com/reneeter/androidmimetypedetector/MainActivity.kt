package com.reneeter.androidmimetypedetector

import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.reneeter.androidmimetypedetector.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding by lazy { ActivityMainBinding.bind(findViewById<ViewGroup>(android.R.id.content)[0]) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val launcher = registerForActivityResult(ActivityResultContracts.GetContent()) {
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.alert_title_text)
                .setMessage(contentResolver.getType(it))
                .setPositiveButton(R.string.alert_positive_text) { dialog, which ->

                }.show()
        }
        binding.button.setOnClickListener {
            launcher.launch("*/*")
        }
    }
}